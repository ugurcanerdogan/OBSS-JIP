package com.uqi.edmsservlet;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {
    private final Connection connection;

    public EmployeeDAO(String connectionString, String username, String password) throws SQLException {

        try {
            connection = DriverManager.getConnection(connectionString, username, password);
            System.out.println("DB CONNECTION COMPLETED !");
        } catch (SQLException e) {
            System.out.println("MYSQL DB CONNECTION FAIL..!");
            System.out.println(e.getMessage());
            throw e;
        }
    }

    public void insertEmployee(Employee e) {
        String sqlQuery = "INSERT INTO Employees (id, name, surname, title, birth_year) values (?,?,?,?,?)";
        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement(sqlQuery);

            preparedStatement.setInt(1, e.getId());
            preparedStatement.setString(2, e.getName());
            preparedStatement.setString(3, e.getSurname());
            preparedStatement.setString(4, e.getTitle());
            preparedStatement.setInt(5, e.getBirth_year());

            int result = preparedStatement.executeUpdate();
            System.out.println("Record has been added.");
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    public List<Employee> listEmployees(OrderField of) {

        List<Employee> employeeList = new ArrayList<>();
        String sqlQuery = "SELECT * FROM Employees ORDER BY " + of.name();
        try {
            Statement statement = this.connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sqlQuery);
            while (resultSet.next()) {
                employeeList.add(new Employee(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getInt(5)));
            }
            System.out.println();
            System.out.println("Fetching done. Total row number: " + employeeList.size());
            return employeeList;

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    public void editEmployees(int id, String name, String surname, String title, int birth_year) {

        String sql = "UPDATE Employees SET id=?,name=?,surname=?,title=?,birth_year=? WHERE id=? ";

        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, name);
            preparedStatement.setString(3, String.valueOf(surname));
            preparedStatement.setString(4, String.valueOf(title));
            preparedStatement.setInt(5, birth_year);
            preparedStatement.setInt(6, id);

            preparedStatement.executeUpdate();

            System.out.println("Record has been updated.");
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
}
