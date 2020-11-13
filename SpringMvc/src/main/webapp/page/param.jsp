<%--
  Created by IntelliJ IDEA.
  User: 24182
  Date: 2020/11/3
  Time: 9:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <a href="${pageContext.request.contextPath}/param?id=1">参数测试1</a>
    <form action="${pageContext.request.contextPath}/param2" method="post">
        username:<input type="text" name="username"><br>
        password:<input type="password" name="password"><br>
        <input type="submit" value="参数测试2">
    </form>
    <a href="${pageContext.request.contextPath}/param3?username=1&age=100">参数测试3</a><br>
    <a href="${pageContext.request.contextPath}/param4">参数测试4</a>
    <form action="${pageContext.request.contextPath}/param5" method="post">
        username:<input type="text" name="username"><br>
        password:<input type="password" name="password"><br>
        <input type="submit" value="参数测试5">
    </form>

    <form action="${pageContext.request.contextPath}/param6" method="post">
        username:<input type="text" name="name"><br>
        password:<input type="password" name="password"><br>
        tel:<input type="text" name="tel"><br>

        carid:<input type="text" name="car.carNumber"><br>
        cartype:<input type="text" name="car.type"><br>

        <input type="submit" value="参数测试6">
    </form>


</body>
</html>
