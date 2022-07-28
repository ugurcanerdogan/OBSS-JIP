<%--
  Created by IntelliJ IDEA.
  User: uqi
  Date: 26.07.2022
  Time: 16:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>


<form method="get" action="${pageContext.request.contextPath}/other-servlet">
    <table>
        <tr>
            <td colspan="2">Login to the Tomcat-Demo application:</td>
        </tr>
        <tr>
            <td>Name:</td>
            <td><input type="text" name="input"/></td>
        </tr>
        <td colspan="2"><input type="submit" value="Go"/></td>
        </tr>
    </table>
</form>

</body>
</html>
