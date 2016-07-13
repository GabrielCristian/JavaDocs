package ro.teamnet.zth.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by user on 7/13/2016.
 */
public class HttpSessionZTH extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if(req.getParameter("username").toString().equals("admin")) {
            if(req.getParameter("password").toString().equals("admin")) {
                resp.getWriter().write("<HTML> Wellcome back <b>" + req.getParameter("username") + "</b> ! </HTML>");
            }
            else {
                req.getSession().setAttribute("user",req.getParameter("username").toString());
                req.getSession().setAttribute("session",req.getSession());
                resp.sendRedirect("views/loginFail.jsp");

            }
        }
        else {
            req.getSession().setAttribute("user",req.getParameter("username").toString());
            req.getSession().setAttribute("session",req.getSession());
            resp.sendRedirect("views/loginFail.jsp");

        }
    }
}
