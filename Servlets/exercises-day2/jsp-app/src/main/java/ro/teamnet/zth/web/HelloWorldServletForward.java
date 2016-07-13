package ro.teamnet.zth.web;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by user on 7/13/2016.
 */
public class HelloWorldServletForward extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String user = "";
        String s =(String ) request.getAttribute("testAttribute");

        user = request.getParameter("user");

        response.getWriter().write("<HTML> Hello <b>" + user + "</b> from the Forward Servlet " + s + "</HTML>");

    }
}
