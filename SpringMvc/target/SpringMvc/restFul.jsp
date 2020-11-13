<%--
  Created by IntelliJ IDEA.
  User: 24182
  Date: 2020/11/4
  Time: 11:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="user/1">Rest_GET</a>
<form action="user/post" method="post">
    <input type="submit" value="submit">

</form>

<form action="/user/1" method="post">
    <input type="hidden" name="_method" value="DELETE">
    <input type="submit" value="DELETE_submit">

</form>
</body>
</html>
