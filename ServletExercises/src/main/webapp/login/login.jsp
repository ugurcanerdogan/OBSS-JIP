<%--
  Created by IntelliJ IDEA.
  User: uqi
  Date: 26.07.2022
  Time: 13:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>LOG IN PAGE</title>
</head>
<body>
<form method="POST" action="j_security_check">
    <table>
        <tr>
            <td colspan="2">Login to the Tomcat-Demo application:</td>
        </tr>
        <tr>
            <td>Name:</td>
            <td><input type="text" name="j_username"/></td>
        </tr>
        <tr>
            <td>Password:</td>
            <td><input type="password" name="j_password"/></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="Go"/></td>
        </tr>
    </table>
</form>
</body>
</html>
