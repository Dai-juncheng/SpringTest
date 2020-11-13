<%--
  Created by IntelliJ IDEA.
  User: 24182
  Date: 2020/11/5
  Time: 10:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>登录页面</title>
</head>
<body>
<h1>欢迎登录</h1>
<h3 style="color: red">${msg}</h3>
<form action="/user/login" method="post">
    username:<input type="text" name="username"><br>
    password:<input type="password" name="password"><br>
    <input type="submit" value="submit"><br>

</form>
</body>
</html>
