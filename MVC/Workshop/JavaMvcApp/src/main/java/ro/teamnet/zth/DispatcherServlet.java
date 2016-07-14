package ro.teamnet.zth;

import ro.teamnet.zth.api.annotations.MyController;
import ro.teamnet.zth.api.annotations.MyRequestMethod;
import ro.teamnet.zth.appl.controller.DepartmentController;
import ro.teamnet.zth.appl.controller.EmployeeController;
import ro.teamnet.zth.fmk.AnnotationScanUtils;
import ro.teamnet.zth.fmk.MethodAttributes;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.util.HashMap;

/**
 * Created by user on 7/14/2016.
 */
public class DispatcherServlet extends HttpServlet {

    HashMap<String, MethodAttributes> allowedMethods = new HashMap<String, MethodAttributes>();

    @Override
    public void init() throws ServletException {
        try {
            /* Cautare clase din pachet */
            Iterable<Class> classes = AnnotationScanUtils.getClasses("ro.teamnet.zth.appl.controller");
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

                            allowedMethods.put(urlPath,methodAttributes);
                        }
                    }
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected Object dispatch(HttpServletRequest req, HttpServletResponse resp) throws Exception {

        String path = req.getPathInfo();
        allowedMethods.get(path);
        MethodAttributes methodAttributes = allowedMethods.get(path);
        if(methodAttributes != null) {
            String controllerName = methodAttributes.getControllerClass();
            try {
                Class<?> controllerClass = Class.forName(controllerName);
                try {
                    Object controllerInstance = controllerClass.newInstance();
                    Method method = controllerClass.getMethod(methodAttributes.getMethodName());
                    return method.invoke(controllerInstance);
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
//        if(req.getPathInfo().equals("/employees")) {
//            String s = new EmployeeController().getAllEmployees();
//            //resp.getWriter().write(s);
//            return s;
//
//        }
//        else if(req.getPathInfo().equals("/departments")) {
//            String s = new DepartmentController().getAllDepartments();
//            return s;
//        }

        return "Hello";
    }
    protected void reply(Object r, HttpServletRequest req, HttpServletResponse resp) throws IOException {
        PrintWriter out = resp.getWriter();
        out.printf(r.toString());
    }
    protected void sendExceptionError(Exception e, HttpServletRequest req, HttpServletResponse resp) {

    }

    protected void dispacthReply (HttpServletRequest req, HttpServletResponse resp, String option) throws IOException {
        Object r = new Object();
        try {
            r = dispatch(req, resp);
           // req.getRequestURI();
            //resp.getWriter().write(req.getRequestURL().toString().substring(36));
            //resp.getWriter().write(req.getPathInfo());
            //resp.getWriter().write((String) r);
        }
        catch (Exception e) {
            sendExceptionError(e, req, resp);
        }
            reply(r, req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        dispacthReply(req, resp, "GET");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        dispacthReply(req, resp, "POST");
    }
}
