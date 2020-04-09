<%--
  Created by IntelliJ IDEA.
  User: Grace
  Date: 08/04/2020
  Time: 9:37 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration Successful</title>
</head>
<body>
<h3>Hii <%=request.getAttribute("name")%> <%=request.getAttribute("lastName")%></h3>
<h4>Your Email ID = <%=request.getAttribute("email")%>></h4>
<h4>Your Contact Number = <%=request.getAttribute("number")%>></h4>

If You Want To Login Then Click <a href="login.html">Login</a> Here.
</body>
</html>
