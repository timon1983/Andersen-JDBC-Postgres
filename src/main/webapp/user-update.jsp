<%--
  Created by IntelliJ IDEA.
  User: Timon
  Date: 15.08.2021
  Time: 7:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en" xmlns:th="http://www.w3.org/1999/xhtml">
<head>
    <title>Update</title>
</head>
<body>
<form action="user-update" object="${user}" method="post">
    ID: <input readonly type="number" name="id" id="id" value=${user.id}>
    <br/>
    <br/>
    First name:<input  type="text" name="firstName" id="firstName" value=${user.firstName}>
    <br/>
    <br/>
    Last name:<input  type="text" name="lastName" id="lastName" value=${user.lastName}>
    <br/>
    <br/>
    Age:<input  type="number" name="age" id="age" value=${user.age}>
    <br/>
    <br/>
    <input type="submit" value="Update User">
</form>
</body>
</html>
