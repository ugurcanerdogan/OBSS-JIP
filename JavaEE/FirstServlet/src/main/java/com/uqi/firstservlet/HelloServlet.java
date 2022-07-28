package com.uqi.firstservlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {

    public void init() {

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");

        System.out.println("HELLO SERVLET: " + name + " " + surname);

        if (name.equals("Ugurcan") && surname.equals("Erdogan")) {
            System.out.println("Redirecting...");
            RequestDispatcher rd = request.getRequestDispatcher("another-servlet");
            rd.forward(request, response);
        } else {
            System.out.println("Failed.");
            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
            rd.forward(request, response);
        }
    }

    public void destroy() {
    }
}