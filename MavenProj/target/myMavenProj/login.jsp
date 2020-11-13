<%@ page import="pojo.User" %>
<html>
<body>
<meta http-equiv="Content-Language" content="zh-cn">

<h2>Welcome to Login</h2>
<%
    String msg= (String) request.getAttribute("msg");
    if(msg==null) msg="";
    System.out.println(msg);

%>

<h3 style="color: #ff0000"><%=msg%></h3>

<form action="login.do" method="post">
    Username:<input type="text" name="username"><br>
    Password:<input type="password" name="password"><br>
    <input type="submit" value="Login">
</form>
</body>
</html>
