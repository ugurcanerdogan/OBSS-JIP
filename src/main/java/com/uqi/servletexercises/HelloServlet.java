package com.uqi.servletexercises;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

//@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    ArrayList<User> users = new ArrayList<>();

    public void init() {
        User user1 = new User(1, "Jack", "London");
        User user2 = new User(2, "Mark", "Twain");
        User user3 = new User(3, "Victor", "Hugo");
        users.add(user1);
        users.add(user2);
        users.add(user3);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");

        request.setAttribute("users", users);
        request.getRequestDispatcher("HelloServlet.jsp").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");

        if (request.getParameter("button1") != null) {
            request.setAttribute("pictureChoice", "r25.jpg");
        } else if (request.getParameter("button2") != null) {
            request.setAttribute("pictureChoice", "4.jpg");
        }

        request.setAttribute("users", users);
        request.getRequestDispatcher("HelloServlet.jsp").forward(request, response);

    }

    public void destroy() {
    }
}