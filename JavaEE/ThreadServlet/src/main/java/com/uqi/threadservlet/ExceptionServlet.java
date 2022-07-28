package com.uqi.threadservlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// Exception handling with jsp files exercise servlet
@WebServlet(name = "exceptionServlet", value = "/exception-servlet")
public class ExceptionServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse response) throws IOException {
        if (req.getParameter("error").equals("notFound")) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);

        } else if (req.getParameter("error").equals("servlet")) {
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);

        }
    }
}
