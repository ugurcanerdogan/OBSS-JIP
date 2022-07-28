package com.uqi.cookies;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

@WebServlet(name = "cookiesServlet", value = "/getCookies")
public class CookiesServlet extends HttpServlet {

    public void init() {
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        Arrays.stream(request.getCookies()).forEach(cookie ->
                System.out.println(
                        cookie.getName() + " " +
                                cookie.getValue() + " " +
                                cookie.getMaxAge() + " " +
                                cookie.getSecure()));
    }

    public void destroy() {
    }
}