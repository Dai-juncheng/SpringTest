<%@ page import="pojo.Car" %><%--
  Created by IntelliJ IDEA.
  User: 24182
  Date: 2020/10/29
  Time: 9:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Start Your Operation</title>
</head>
<body>
<%
    Car car =(Car)request.getAttribute("car");
%>
<form action="doUpdate.do" method="post">
    ID:<input  readonly type="text" name="id" value="<%=car.getId()%>"><br>
    CarID:<input type="text" name="carNumber"  value="<%=car.getCarid()%>"><br>
    Brand:<input type="text" name="type" value="<%=car.getType()%>"><br>
    <input type="submit" value="Enter">
</form>

</body>
</html>
