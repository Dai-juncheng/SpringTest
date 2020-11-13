<%@ page import="java.util.ArrayList" %>
<%@ page import="pojo.Car" %>
<%@ page import="pojo.User" %>
<html>
<body>
<title>Auto show</title>
<meta http-equiv="Content-Language" content="zh-cn">

<h3>Hello <%=((User)session.getAttribute("user")).getUsername()%></h3>
<table>
    <tr>
        <td>ID</td>
        <td>CarID</td>
        <td>Brand</td>
        <td>Operation</td>
    </tr>
    <%
        ArrayList<Car> carList= (ArrayList<Car>) request.getAttribute("carList");
        for (Car car:carList) {
    %>
    <tr>
        <td><%=car.getId()%></td>
        <td><%=car.getCarid()%></td>
        <td><%=car.getType()%></td>
        <td>
            <a href="update.do?id=<%=car.getId()%>">Edit</a>
            <a href="delete.do?id=<%=car.getId()%>">Delete</a>
        </td>
    </tr>


    <%
        }
    %>


</table>
</form>
</body>
</html>
