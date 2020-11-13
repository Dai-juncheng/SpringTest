<%--
  Created by IntelliJ IDEA.
  User: 15154
  Date: 2020/10/10
  Time: 15:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>用户管理</title>
    <link rel="stylesheet" href="../../layui/css/layui.css">
</head>
<body>
<!-- 搜索条件开始 -->
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
    <legend>查询条件</legend>
</fieldset>
<form id="searchFrm" class="layui-form" method="post">
    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">编号:</label>
            <div class="layui-input-inline">
                <input type="text" name="id"  autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label">用户名:</label>
            <div class="layui-input-inline">
                <input type="text" name="username"  autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-inline" style="margin-left: 400px;">
            <button type="button" class="layui-btn layui-btn-normal layui-btn-sm layui-icon layui-icon-search" id="doSearch">查询</button>
            <button type="reset" class="layui-btn layui-btn-warm layui-btn-sm layui-icon layui-icon-refresh">重置</button>
        </div>
    </div>
</form>

<!-- 搜索条件结束 -->


<!-- 数据表格开始 -->
<table class="layui-hide" id="userTable" lay-filter="userTable"></table>
<!-- 功能栏-->
<div style="display: none;" id="userToolBar">
    <button type="button" class="layui-btn layui-btn-sm" lay-event="add">增加</button>
    <button type="button" class="layui-btn layui-btn-sm" lay-event="batchDelete">批量删除</button>
</div>

<div  id="userBar" style="display: none;">
    <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</div>
<!-- 数据表格结束 -->

<!-- 添加和修改的弹出层开始 -->
<div style="display: none;padding: 20px" id="saveOrUpdateDiv" >
    <form class="layui-form " action="" lay-filter="dataFrm" id="dataFrm">
        <div class="layui-form-item">
            <%--编号在数据库中通过索引自动生成--%>
            <div class="layui-inline">
                <label class="layui-form-label">编号:</label>
                <div class="layui-input-inline">
                    <input type="text" name="id"  lay-verify="required" autocomplete="off"
                           class="layui-input">
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label">用户名:</label>
                <div class="layui-input-inline">
                    <input type="text" name="username" autocomplete="off"
                           class="layui-input">
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label">密码:</label>
                <div class="layui-input-inline">
                    <input type="text" name="password" autocomplete="off"
                           class="layui-input">
                </div>
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label">电话:</label>
                <div class="layui-input-inline">
                    <input type="text" name="tel"  lay-verify="required|tel" autocomplete="off"
                           class="layui-input">
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label">角色:</label>
                <div class="layui-input-inline">
                    <input type="text" name="role" lay-verify="required" autocomplete="off"
                           class="layui-input">
                </div>
            </div>
        </div>
        <!--<div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label">性别:</label>
                <div class="layui-input-inline">
                     <input type="radio" name="sex" value="1" checked="checked" title="男">
                     <input type="radio" name="sex" value="0" title="女">
                </div>
            </div>
        </div>-->
        <div class="layui-form-item" style="text-align: center;">
            <div class="layui-input-block">
                <button type="button" class="layui-btn layui-btn-normal layui-btn-sm layui-icon layui-icon-release" lay-filter="doSubmit" lay-submit="">提交</button>
                <button type="reset" class="layui-btn layui-btn-warm layui-btn-sm layui-icon layui-icon-refresh" >重置</button>
            </div>
        </div>
    </form>

</div>
<!-- 添加和修改的弹出层结束 -->

<script src="../../layui/layui.js"></script>
<script>
    layui.use(['table','layer','jquery','form'], function(){
        var $ = layui.jquery;
        var table = layui.table;
        var layer = layui.layer;
        var form = layui.form;

        //请求的变量
        var url;
        var mainIndex;
        var tableIns = table.render({
            elem: '#userTable' //渲染的目标对象
            ,url:'/userList'  //数据接口
            ,cellMinWidth: 80 //全局定义常规单元格的最小宽度，layui 2.2.1 新增
            ,toolbar:"#userToolBar" //表格的工具条
            ,height:'full-160'
            ,page:true // 启用分页
            ,limit:4  //每页数据条数
            ,limits:[2,3,4,5] //每页数据条数选项
            ,cols: [[  //列表数据
                {type:'checkbox',fixed:'left'}
                ,{field:'id', title: '序号', sort: true}
                ,{field:'username', title: '用户名'}
                ,{field:'password', title: '密码', sort: true}
                ,{field:'tel', title: '联系方式'}
                ,{field:'role', title: '角色'
                    ,templet:function(d){
                        if (d.role == '超级管理员'){
                            return '超级管理员';
                        } else if(d.role == '用户管理员'){
                            return '用户管理员';
                        } else {
                            return '汽车管理员';
                        }
                    }} //minWidth：局部定义当前单元格的最小宽度，layui 2.2.1 新增
                ,{fixed:'right',title:'操作'
                    ,toolbar:'#userBar'
                    ,width:200,align:'center'}
            ]]
        });

        //模糊查询
        $('#doSearch').click(function () {
            url='/getUsers'
            //获得要查询的内容
            var params=$("#searchFrm").serialize();
            tableIns.reload({
                url:url+'?'+params
            })
        })


        //监听头部工具栏事件
        table.on('toolbar(userTable)', function(obj){
            /*var checkStatus
                = table.checkStatus(obj.config.id);*/
            switch(obj.event){
                case 'add':
                    //打开页面弹出层
                    openAddUser();
                    break;
                case 'batchDelete':
                    batchDelete();
                    break;

            }
        });

        //监听工具条
        table.on('tool(userTable)', function(obj){ //注：tool 是工具条事件名，test 是 table 原始容器的属性 lay-filter="对应的值"
            var data = obj.data; //获得当前行数据
            var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
            //var tr = obj.tr; //获得当前行 tr 的 DOM 对象（如果有的话）

            if(layEvent === 'del'){ //删除
                layer.confirm('真的删除行么', function(index){
                    //obj.del(); //删除对应行（tr）的DOM结构，并更新缓存
                    //layer.close(index);
                    //向服务端发送删除指令
                    deleteUser(data.id);
                });
            } else if(layEvent === 'edit'){ //编辑
                //do something
                openUpdateUser(data)
                //同步更新缓存对应的值

            } else if(layEvent === 'LAYTABLE_TIPS'){
                layer.alert('Hi，头部工具栏扩展的右侧图标。');
            }
        });

        //打开添加页面
        function openAddUser() {
                mainIndex = layer.open({
                type:1,
                title:'添加用户',
                content:$('#saveOrUpdateDiv'),
                area:['800px','400px'],
                success:function (index) {
                    url = '/addUser';
                    //清空表单数据
                    $('#dataFrm')[0].reset();
                }
            })
        }

        //执行批量删除
        function batchDelete(){
            //得到数据行中所有的id
            var checkStatus=table.checkStatus('userTable')
            //得到id
            var data = checkStatus.data //属性
            var params=''
            url='/deleteUsers'
            $.each(data,function(index,elem){
                if(index=0){
                    params+='ids='+elem.id;
                }else {
                    params+='&ids='+elem.id;
                }

            })
            //将所有哦用户id传向后台
            layer.confirm("Sure you want to delelte this?",function(index) {
                    var res=$.post(url,params,function () {
                    layer.msg(res.responseText)
                    tableIns.reload()
                })
            })

        }
        //删除当前行数据
        function deleteUser(id){
            url='/deleteUser'
            var res=$.post(url,{'id':id},function (obj) {
                //弹出删除成功与否的提示信息
                layer.msg(res.responseText)
                //刷新数据表格
                tableIns.reload()


            })
        }
        //打开修改数据
        function openUpdateUser(data){
                mainIndex=layer.open({
                type:1.,
                title:"update user",
                content:$('#saveOrUpdateDiv'),
                area:['800px','400px'],
                success:function (index) {
                    //将当前行数据显示在弹出层中
                    form.val('dataFrm',data);
                    url='/editUser'
                }
            })

        }

        //提交按钮的点击事件
        form.on('submit(doSubmit)',function (obj) {
            //序列化表单数据
            var params = $('#dataFrm').serialize();
            var res=$.post(url,params,function (obj) {
                //关闭弹出层
                layer.close(mainIndex);
                //弹出添加成功与否的信息
                layer.msg(res.responseText)
                //刷新数据表格
                tableIns.reload();
            })
        })
    });
</script>
</body>
</html>
