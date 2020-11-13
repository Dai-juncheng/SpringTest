<%--
  Created by IntelliJ IDEA.
  User: 24182
  Date: 2020/11/1
  Time: 13:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ page import="java.util.List" %>
        <%@ page import="pojo.Car" %>
        <%--
          Created by IntelliJ IDEA.
          User: 15154
          Date: 2020/10/30
          Time: 10:59
          To change this template use File | Settings | File Templates.
        --%>
        <%@ page contentType="text/html;charset=UTF-8" language="java" %>
        <html>
        <head>
            <title> 汽车展示</title>
        </head>
<%
    List<Car> list = (List<Car>) request.getAttribute("cars");
%>
<body>
<table>
    <tr>
        <td>序号</td>
        <td>车牌号</td>
        <td>品牌</td>
        <td>编辑</td>
        <td>删除</td>
        
    </tr>
    <%
        for (Car car : list) {

    %>
    <tr>
        <td><%=car.getId()%></td>
        <td><%=car.getCarid()%></td>
        <td><%=car.getType()%></td>
        <td><a href="updatecar.action?id=<%=car.getId()%>">Update</a></td>
        <td><a href="deletecar.action?id=<%=car.getId()%>">Delete</a></td>




    </tr>
    <%
        }
    %>
</table>

</body>
</html>
</title>
</head>
<body>

</body>
</html>
