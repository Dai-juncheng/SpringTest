<%--
  Created by IntelliJ IDEA.
  User: 15154
  Date: 2020/11/6
  Time: 10:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="resources/layui/css/layui.css" media="all">
</head>

<body>
<table class="layui-hide" id="userTable" lay-filter="userTable"></table>

<script src="resources/layui/layui.js" charset="utf-8"></script>
<script>
    layui.use(['table'],function () {
        var table = layui.table;
        table.render({
            elem: '#userTable'
            ,height: 420
            ,url: '/user/showUser' //数据接口
            ,title: '用户表'
            ,page: true //开启分页
            ,totalRow: true //开启合计行
            ,cols: [[ //表头
                {type: 'checkbox', fixed: 'left'}
                ,{field: 'id', title: 'ID', width:80, sort: true, fixed: 'left', totalRowText: '合计：'}
                ,{field: 'username', title: '用户名', width:80}
                ,{field: 'password', title: '密码', width: 90, sort: true, totalRow: true}
                ,{field: 'tel', title: '联系方式', width:80, sort: true}
                ,{field: 'role', title: '角色', width: 80, sort: true, totalRow: true}
            ]]
        });
    });

</script>
</body>
</html>
