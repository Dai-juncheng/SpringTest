<%--
  Created by IntelliJ IDEA.
  User: 24182
  Date: 2020/11/6
  Time: 9:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>信息修改</title>
</head>
<body>
<h1>信息修改</h1>
<form action="/user/doUpdate" method="post">
<c:forEach items="${user}"  var="user">
    <input type="hidden" name="_method" value="put">
    <input name="id" readonly value="${user.id}"><br>
    <input name="username" value="${user.username}"><br>
    <input name="password" value="${user.password}"><br>
    <input name="tel" value="${user.tel}"><br>
    <input name="role" value="${user.role}"><br>

    <input type="submit" value="提交"><br>
</c:forEach>
</form>
</body>
</html>
