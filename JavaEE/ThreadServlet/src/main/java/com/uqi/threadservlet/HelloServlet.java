package com.uqi.threadservlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// Synchronized keyword exercise servlet - THREADS
@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    public int deger = 1000;

    public void init() {

    }

    @Override
    protected synchronized void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int param = Integer.parseInt(request.getParameter("amount"));

        deger -= param;

        try {
            Thread.sleep(5000);
            System.out.println("Para çekildi : " + param + " Yeni Bakiye:" + deger);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    public void destroy() {
    }
}