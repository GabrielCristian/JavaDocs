package ro.teamnet.zth;

import org.codehaus.jackson.map.ObjectMapper;
import ro.teamnet.zth.api.annotations.MyController;
import ro.teamnet.zth.api.annotations.MyRequestMethod;
import ro.teamnet.zth.api.annotations.MyRequestParam;
import ro.teamnet.zth.fmk.AnnotationScanUtils;
import ro.teamnet.zth.fmk.MethodAttributes;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by user on 7/14/2016.
 */
public class DispatcherServlet extends HttpServlet {

    HashMap<String, MethodAttributes> allowedMethods = new HashMap<String, MethodAttributes>();

    @Override
    public void init() throws ServletException {
        /* Cautare clase din pachet */
        Iterable<Class> classes = null;
        try {
            classes = AnnotationScanUtils.getClasses("ro.teamnet.zth.appl.controller");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        for(Class controller : classes) {
            if(controller.isAnnotationPresent(MyController.class)) {
                MyController contr = (MyController) controller.getAnnotation(MyController.class);
                String controllerUrlPath = contr.urlPath();
                Method[] controllerMethods = controller.getMethods();
                for (Method contrMeth : controllerMethods) {
                    if(contrMeth.isAnnotationPresent(MyRequestMethod.class)) {

                        MyRequestMethod myRequestMethodMeth = contrMeth.getAnnotation(MyRequestMethod.class);
                        String methodUrlPath = myRequestMethodMeth.urlPath();
                        //construiesc cheia pentru HashMap
                        String urlPath = controllerUrlPath + methodUrlPath;

                        MethodAttributes methodAttributes = new MethodAttributes();
                        methodAttributes.setControllerClass(controller.getName());
                        methodAttributes.setMethodName(contrMeth.getName());
                        methodAttributes.setMethodType(myRequestMethodMeth.methodType());
                        methodAttributes.setParameterTypes(contrMeth.getParameterTypes());
                        allowedMethods.put(urlPath + myRequestMethodMeth.methodType(),methodAttributes);
                    }
                }
            }
        }
    }

    protected Object dispatch(HttpServletRequest req, HttpServletResponse resp, String option) throws Exception {

        String path = req.getPathInfo();
        path+= option;

        allowedMethods.get(path);
        MethodAttributes methodAttributes = allowedMethods.get(path);


        if(methodAttributes != null) {
            String controllerName = methodAttributes.getControllerClass();
            Class<?> controllerClass = Class.forName(controllerName);



                Object controllerInstance = controllerClass.newInstance();
                Method method = controllerClass.getMethod(methodAttributes.getMethodName(), methodAttributes.getParametersTypes());
                Parameter[] parameters = method.getParameters();
                List<Object> parameterValues = new ArrayList<>();
                for(Parameter parameter : parameters) {
                    if(parameter.isAnnotationPresent(MyRequestParam.class)) {
                        MyRequestParam annotation = parameter.getAnnotation(MyRequestParam.class);
                        String name = annotation.name();
                        String requestParamValue = req.getParameter(name);
                        Class<?> type = parameter.getType();
                        Object requestParamObject;
                        if(parameter.getType().equals(String.class)) {
                            requestParamObject = requestParamValue;
                        }
                        else
                            requestParamObject = new ObjectMapper().readValue(requestParamValue,type);

                        parameterValues.add(requestParamObject);
                    }
                }
                return method.invoke(controllerInstance, parameterValues.toArray());



        }

        return "Hello";
    }
    protected void reply(Object r, HttpServletRequest req, HttpServletResponse resp, String option) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        String jsonInString = mapper.writeValueAsString(r);
        PrintWriter out = resp.getWriter();
        out.printf(jsonInString);


    }
    protected void sendExceptionError(Exception e, HttpServletRequest req, HttpServletResponse resp) {

    }

    protected void dispacthReply (HttpServletRequest req, HttpServletResponse resp, String option) throws IOException {
        Object r = new Object();
        try {
            r = dispatch(req, resp, option);

        }
        catch (Exception e) {
            sendExceptionError(e, req, resp);
        }
            reply(r, req, resp, option);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        dispacthReply(req, resp, "POST");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        dispacthReply(req, resp, "GET");
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        dispacthReply(req, resp, "DELETE");
    }
}
