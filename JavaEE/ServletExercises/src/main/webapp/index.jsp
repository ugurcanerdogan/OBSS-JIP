<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Users</title>
</head>
<body>


<div>
    <h3>PARAMETER SET-GET PLAYGROUND</h3>
    <form action="${pageContext.request.contextPath}/hello-servlet" method="post">
        <h1>
            Choose your champion!
        </h1>
        <img src="r25.jpg" height="300" width="400">
        <input type="submit" name="button1" value="ALONSO"/>
        <img src="4.jpg" height="400" width="400">
        <input type="submit" name="button2" value="VETTEL"/>
    </form>
</div>

<div>
    <h3>NO IMAGE PLAYGROUND</h3>
    <a href="hello-servlet">Hello Servlet</a>
</div>

<div>
    <h3>INIT PARAMETER PLAYGROUND</h3>
    <a href="OtherServlet.jsp">Other Servlet</a>
</div>


<div>
    <h3>JSP INCLUDE PLAYGROUND</h3>
    <a href="includeEachOther/home.jsp">HOME </a>
    <a href="includeEachOther/main.jsp">MAIN</a>
</div>

</body>
</html>