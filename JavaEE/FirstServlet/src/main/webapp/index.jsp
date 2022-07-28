<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<form action="hello-servlet" method="post">
    <label for="fname">First name:</label><br>
    <input type="text" id="fname" name="name"><br>
    <label for="lname">Last name:</label><br>
    <input type="text" id="lname" name="surname">
    <input type="submit" value="Submit">
</form>
<br/>
</body>
</html>