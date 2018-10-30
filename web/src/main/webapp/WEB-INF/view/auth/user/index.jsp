<%--
  Created by IntelliJ IDEA.
  User: aWin
  Date: 2018-09-11
  Time: 17:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  %>
<html>
<head>
    <title>用户管理</title>
    <%@ include  file="../../pub/head.jsp" %>
</head>
<body>

<table id="demo" lay-filter="test"></table>

<script>
    layui.use('table', function(){
        var table = layui.table;

        //第一个实例
        table.render({
            elem: '#demo'
            ,height: 400
            ,url: 'query' //数据接口
            ,request: {
                pageName: 'index' //页码的参数名称，默认：page
                ,limitName: 'pageSize' //每页数据量的参数名，默认：limit
            }
            ,page: true //开启分页
            ,cols: [[ //表头
//                {field: 'pk_user', title: 'ID', width:80, sort: true, fixed: 'left',hide:true}
                {field: 'pk_user', title: '主键', width:80, fixed: 'left',hide:true},
                {field: 'userCode', title: '用户编码', width:80},
                {field: 'userName', title: '用户名', width:80},
                {field: 'password', title: '密码', width:80, hide:true},
                {field: 'isLocked', title: '是否锁定', width:80},
                {field: 'telephone', title: '手机', width:80},
                {field: 'email', title: '邮箱', width:80},
                {field: 'sex', title: '性别', width:80},
                {field: 'city', title: '城市', width:80},
                {field: 'sign', title: '签名', width:80},
                {field: 'score', title: '分数', width:80},
                {field: 'creator', title: '创建人', width:80},
                {field: 'creationTime', title: '创建时间', width:80},
                {field: 'modifier', title: '修改人', width:80},
                {field: 'modifyTime', title: '修改时间', width:80,hide:true},
                {field: 'ts', title: '时间戳', width:80,hide:true},
                {field: 'dr', title: '删除标志', width:80 ,hide:true}

            ]]
        });

    });
</script>
</body>
</html>
<%@ include  file="../../pub/htmlend.jsp" %>
