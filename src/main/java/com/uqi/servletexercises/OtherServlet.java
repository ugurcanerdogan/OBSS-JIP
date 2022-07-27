package com.uqi.servletexercises;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@WebServlet(name = "otherServlet", value = "/other-servlet")

public class OtherServlet extends HttpServlet {
    String input = "";
    ServletConfig config;
    @Override
    public void init(ServletConfig config) throws ServletException {
        this.config = config;
        input = config.getInitParameter("input");
        super.init(config);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");


        String input = request.getParameter("input");
        if (input.equals(this.input)){
            request.getRequestDispatcher("HelloServlet.jsp").forward(request, response);
        }else {
            request.getRequestDispatcher("login/login_failed.jsp").forward(request, response);
        }
    }
}
