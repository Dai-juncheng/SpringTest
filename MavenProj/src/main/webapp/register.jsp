<html>
<body>
<meta http-equiv="Content-Language" content="zh-cn">
<h2>Welocome to REgister</h2>
<%
    String msg= (String) request.getAttribute("msg");
    if(msg==null) msg="";

%>

<h3 style="color: red"><%=msg%></h3>

<form action="register.do" method="post">
    Username:<input type="text" name="username"><br>
    Password:<input type="password" name="password"><br>
    <input type="submit" value="Register">
</form>
</body>
</html>
