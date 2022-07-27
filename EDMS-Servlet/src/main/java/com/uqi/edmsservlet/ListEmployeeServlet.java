package com.uqi.edmsservlet;

import java.io.*;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "listEmployee", value = "/listEmployee")
public class ListEmployeeServlet extends HttpServlet {
    private EmployeeDAO employeeDAO;

    {
        try {
            employeeDAO = new EmployeeDAO("jdbc:mysql://uqi-mysql-works-do-user-12084402-0.b.db.ondigitalocean.com:25060/defaultdb?ssl-mode=REQUIRED", "doadmin", "AVNS_9PXAtkxYwYlDsPUqB6n");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public void init() {

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String sortBy = request.getParameter("sortBy");

        OrderField sortParam;

        if (sortBy != null  && sortBy.equals("name")){
            sortParam = OrderField.name;
        } else if (sortBy != null  && sortBy.equals("surname")) {
            sortParam = OrderField.surname;
        }else {
            sortParam = OrderField.birth_year;
        }
        List< Employee > listUser = employeeDAO.listEmployees(sortParam);
        request.setAttribute("listUser", listUser);

        RequestDispatcher dispatcher = request.getRequestDispatcher("listEmployee.jsp");
        dispatcher.forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        List< Employee > listUser = employeeDAO.listEmployees(OrderField.name);
        request.setAttribute("listUser", listUser);
        RequestDispatcher dispatcher = request.getRequestDispatcher("listEmployee.jsp");
        dispatcher.forward(request, response);
    }


    public void destroy() {
    }
}