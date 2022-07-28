<%--
  Created by IntelliJ IDEA.
  User: uqi
  Date: 25.07.2022
  Time: 13:01
  To change this template use File | Settings | File Templates.
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>LIST EMPLOYEE</title>
</head>
<body>
</div>
<br>
<div>
    <table border=1 class="table table-bordered">
        <thead>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Surname</th>
            <th>Title</th>
            <th>Birthyear</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="user" items="${listUser}">

            <tr>
                <td>
                    <c:out value="${user.id}"/>
                </td>
                <td>
                    <c:out value="${user.name}"/>
                </td>
                <td>
                    <c:out value="${user.surname}"/>
                </td>
                <td>
                    <c:out value="${user.title}"/>
                </td>
                <td>
                    <c:out value="${user.birth_year}"/>
                </td>
            </tr>
        </c:forEach>
        <!-- } -->
        </tbody>

    </table>
</div>
<div>
    <form action="listEmployee" method="get">
        <label for="sort">Sort by : </label>
        <input type="text" name="sortBy" id="sort">
        <input type="submit" value="List Employee">
    </form>
</div>


</body>
</html>
