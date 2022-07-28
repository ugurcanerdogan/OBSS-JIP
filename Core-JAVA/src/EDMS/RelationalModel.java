package EDMS;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RelationalModel {
    private final Connection connection;

    public RelationalModel(String connectionString, String username, String password) throws SQLException {

        try {
            connection = DriverManager.getConnection(connectionString, username, password);
            System.out.println("DB CONNECTION COMPLETED !");
        } catch (SQLException e) {
            System.out.println("MYSQL DB CONNECTION FAIL..!");
            System.out.println(e.getMessage());
            throw e;
        }
    }

    public static void main(String[] args) throws SQLException {
        RelationalModel relationalModel = new RelationalModel("jdbc:mysql://uqi-mysql-works-do-user-12084402-0.b.db.ondigitalocean.com:25060/defaultdb?ssl-mode=REQUIRED", "doadmin", "AVNS_9PXAtkxYwYlDsPUqB6n");

        relationalModel.insertEmployee(new Employee(0, "Jesse", "James", "Group Manager", 1847));
        relationalModel.insertEmployee(new Employee(1, "Butch", "Cassidy", "Senior Developer", 1866));
        relationalModel.insertEmployee(new Employee(2, "Buffalo", "Bill", "Junior Developer", 1846));
        relationalModel.insertEmployee(new Employee(3, "Tom", "Ketchum", "Software Architect", 1863));
        relationalModel.insertEmployee(new Employee(4, "Billy", "the Kid", "Product Owner", 1859));
        relationalModel.insertEmployee(new Employee(5, "Nat", "Love", "CTO", 1854));

        List<Employee> employeeList = relationalModel.listEmployees(OrderField.surname);

        System.out.println();
        System.out.println("Printing names...");
        employeeList.forEach(employee -> System.out.println(employee.name()));
        System.out.println();
        System.out.println("Printing surnames...");
        employeeList.forEach(employee -> System.out.println(employee.surname()));
        System.out.println();
        System.out.println("Printing titles...");
        employeeList.forEach(employee -> System.out.println(employee.title()));
    }

    public void insertEmployee(Employee e) {
        String sqlQuery = "INSERT INTO Employees (id, name, surname, title, birth_year) values (?,?,?,?,?)";
        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement(sqlQuery);

            preparedStatement.setInt(1, e.id());
            preparedStatement.setString(2, e.name());
            preparedStatement.setString(3, e.surname());
            preparedStatement.setString(4, e.title());
            preparedStatement.setInt(5, e.birthYear());

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
}
