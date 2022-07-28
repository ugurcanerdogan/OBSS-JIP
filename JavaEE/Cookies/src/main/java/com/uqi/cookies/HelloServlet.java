package com.uqi.cookies;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "helloServlet", value = "/setCookie")
public class HelloServlet extends HttpServlet {

    public void init() {
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        Cookie cookie = new Cookie("obss", "uqi");
        response.addCookie(cookie);
        response.sendRedirect(request.getContextPath() + "/getCookies");
    }

    public void destroy() {
    }
}