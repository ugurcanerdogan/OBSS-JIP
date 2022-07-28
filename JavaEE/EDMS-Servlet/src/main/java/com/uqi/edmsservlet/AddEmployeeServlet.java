package com.uqi.edmsservlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "addEmployee", value = "/addEmployee")
public class AddEmployeeServlet extends HttpServlet {
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

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        Integer id = Integer.valueOf(request.getParameter("id"));
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String title = request.getParameter("title");
        Integer birth_year = Integer.valueOf(request.getParameter("birth_year"));

        Employee newUser = new Employee(id, name, surname, title, birth_year);
        employeeDAO.insertEmployee(newUser);
        response.sendRedirect(request.getContextPath() + "/listEmployee");

    }


    public void destroy() {
    }
}