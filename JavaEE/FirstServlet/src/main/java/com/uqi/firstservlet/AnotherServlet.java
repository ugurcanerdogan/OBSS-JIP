package com.uqi.firstservlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "anotherServlet", value = "/another-servlet")
public class AnotherServlet extends HttpServlet {

    public void init() {

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();

        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        System.out.println("ANOTHER SERVLET: " + name + " " + surname);

        out.println("<table style=\"border:1px solid #000;\">");
        out.println("<tr><td>" + name + "</td></tr>");
        out.println("<tr><td>" + surname + "</td></tr>");
        out.println("</table>");
    }

    public void destroy() {
    }
}
