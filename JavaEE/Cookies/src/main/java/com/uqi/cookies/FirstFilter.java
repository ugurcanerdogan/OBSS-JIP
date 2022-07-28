package com.uqi.cookies;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@WebFilter(filterName = "MyOwnServlet",servletNames = {"logIn","sesionServlet"},description = "Filters by session parameter")

@WebFilter(filterName = "MyOwnServlet", servletNames = {"sessionServlet"}, description = "Filters by session parameter")
public class FirstFilter implements javax.servlet.Filter {

    private FilterConfig filterConfig;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
    }

    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest request1 = (HttpServletRequest) request;
        HttpServletResponse response1 = (HttpServletResponse) response;

        Object isUserLoggedIn = request1.getSession().getAttribute("isUserLoggedIn");
        if (isUserLoggedIn != null) {
            response1.sendRedirect(request1.getContextPath() + "/public/home.jsp");
        } else {
//            response1.sendRedirect(request1.getContextPath() + "/login.jsp");
            response1.sendError(403);
        }

        chain.doFilter(request, response);

    }

}