<%--
  Created by IntelliJ IDEA.
  User: Timon
  Date: 15.08.2021
  Time: 12:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create User</title>
</head>
<body>
<form action="user-create" method="post">
    First name:<input  type="text" name="firstName" id="firstName" placeholder="firstName">
    <br/>
    <br/>
    Last name:<input  type="text" name="lastName" id="lastName" placeholder="lastName">
    <br/>
    <br/>
    Age:<input  type="number" name="age" id="age" placeholder="age">
    <br/>
    <br/>
    <input type="submit" value="Create">
</form>
</body>
</html>
