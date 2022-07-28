package com.uqi.cookies;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "sessionServlet", value = "/home")
public class SessionServlet extends HttpServlet {

    public void init() {
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        Object isUserLoggedIn = request.getSession().getAttribute("isUserLoggedIn");
        if (isUserLoggedIn != null) {
            response.sendRedirect(request.getContextPath() + "/public/home.jsp");
        } else {
            response.sendRedirect(request.getContextPath() + "/login.jsp");
        }
    }

    public void destroy() {
    }
}