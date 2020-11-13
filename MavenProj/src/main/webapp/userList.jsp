<%@ page import="java.util.List" %>
<%@ page import="pojo.Customer" %>
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
    <title>用户信息展示</title>
</head>
<%
    List<Customer> list = (List<Customer>) request.getAttribute("users");
%>
<body>
<table>
    <tr>
        <td>序号</td>
        <td>姓名</td>
        <td>密码</td>
        <td>联系方式</td>
        <td>角色</td>
    </tr>
    <%
        for (Customer customer : list) {

    %>
    <tr>
        <td><%=customer.getId()%></td>
        <td><%=customer.getUsername()%></td>
        <td><%=customer.getPassword()%></td>
        <td><%=customer.getTel()%></td>
        <td><%=customer.getRole()%></td>

    </tr>
    <%
        }
    %>
</table>

</body>
</html>
