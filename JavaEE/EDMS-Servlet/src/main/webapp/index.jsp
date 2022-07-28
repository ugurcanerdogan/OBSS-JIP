<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "EMPLOYEE MANAGEMENT SYSTEM" %>
</h1>
<br/>
<div>
    <form action="addEmployee.jsp">
        <br><br>
        <input type="submit" value="Add Employee">
    </form>
</div>
<div>
    <form action="listEmployee" method="get">
        <br><br>
        <input type="submit" value="List Employee">
    </form>
</div>
<div>
    <form action="editEmployee.jsp" method="post">
        <br><br>
        <input type="submit" value="Edit Employee">
    </form>
</div>

</body>
</html>