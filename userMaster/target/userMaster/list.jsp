<%--
  Created by IntelliJ IDEA.
  User: 24182
  Date: 2020/11/5
  Time: 10:41
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>message show</title>
</head>
<body>
<h1>信息展示</h1>
<table>
    <tr>
        <td>序号</td>
        <td>用户名</td>
        <td>密码</td>
        <td>联系方式</td>
        <td>角色</td>
    </tr>
    <c:forEach items="${list}" var="user">
        <tr>
            <td>${user.id}</td>
            <td>${user.username}</td>
            <td>${user.password}</td>
            <td>${user.tel}</td>
            <td>${user.role}</td>
            <td>
                <A href="/user/update/${user.id}">update</A>
                <A href="/user/delete/${user.id}">delete</A>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
