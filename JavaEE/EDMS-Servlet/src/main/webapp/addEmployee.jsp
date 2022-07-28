<%--
  Created by IntelliJ IDEA.
  User: uqi
  Date: 25.07.2022
  Time: 13:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ADD EMPLOYEE</title>
</head>
<body>


<form action="addEmployee" method="post">
    <div>
        <label for="id">ID : </label>
        <input type="text" name="id" id="id">
    </div>
    <br><br>
    <div>
        <label for="name">Name : </label>
        <input type="text" name="name" id="name">
    </div>
    <br><br>
    <div>
        <label for="surname">Surname : </label>
        <input type="text" name="surname" id="surname">
    </div>
    <br><br>
    <div>
        <label for="title">Title : </label>
        <input type="text" name="title" id="title">
    </div>
    <br><br>
    <div>
        <label for="birth_year">B.Year : </label>
        <input type="text" name="birth_year" id="birth_year">
    </div>
    <br><br>
    <input type="submit" value="ADD">
    <span class="error">${error}</span>
</form>
</body>
</html>
