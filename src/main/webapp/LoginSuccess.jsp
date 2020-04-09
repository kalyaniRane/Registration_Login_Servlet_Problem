<%--
  Created by IntelliJ IDEA.
  User: Grace
  Date: 08/04/2020
  Time: 12:49 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Success Page</title>
</head>
<body>
<h3>Hii <%= request.getAttribute("user")%>,LoginSuccessful.</h3>
<a href="login.html">Login Page</a>
</body>
</html>
