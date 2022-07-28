package com.uqi.threadservlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// GetRequestURI exercise servlet
@WebServlet(name = "secureServlet", value = "/secured")
public class SecureServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        if (request.getRequestURI().contains("secured")) {
            response.sendError(HttpServletResponse.SC_FORBIDDEN);
            System.out.println(request.getRequestURL().toString());
        }
    }
}
