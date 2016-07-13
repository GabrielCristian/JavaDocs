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
public class HelloWorldInclude extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/helloIncludeForward");

        request.setAttribute("testAttribute", "Enjoy Z2H");
        requestDispatcher.include(request, response);

        response.getWriter().print("  After");

    }
}
