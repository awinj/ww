<%--
  Created by IntelliJ IDEA.
  User: aWin
  Date: 2018-09-11
  Time: 17:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
//            ,data:[{id:10000,username:"user-0",sex:"女",city:"城市-0",sign:"签名-0",experience:255,logins:24,wealth:82830700,classify:"作家",score:57},
//                {id:10000,username:"user-0",sex:"女",city:"城市-0",sign:"签名-0",experience:255,logins:24,wealth:82830700,classify:"作家",score:57},
//                {id:10000,username:"user-0",sex:"女",city:"城市-0",sign:"签名-0",experience:255,logins:24,wealth:82830700,classify:"作家",score:57},
//                {id:10000,username:"user-0",sex:"女",city:"城市-0",sign:"签名-0",experience:255,logins:24,wealth:82830700,classify:"作家",score:57},
//                {id:10000,username:"user-0",sex:"女",city:"城市-0",sign:"签名-0",experience:255,logins:24,wealth:82830700,classify:"作家",score:57},
//                {id:10000,username:"user-0",sex:"女",city:"城市-0",sign:"签名-0",experience:255,logins:24,wealth:82830700,classify:"作家",score:57},
//                {id:10000,username:"user-0",sex:"女",city:"城市-0",sign:"签名-0",experience:255,logins:24,wealth:82830700,classify:"作家",score:57},
//                {id:10000,username:"user-0",sex:"女",city:"城市-0",sign:"签名-0",experience:255,logins:24,wealth:82830700,classify:"作家",score:57},
//                {id:10000,username:"user-0",sex:"女",city:"城市-0",sign:"签名-0",experience:255,logins:24,wealth:82830700,classify:"作家",score:57},
//                {id:10000,username:"user-0",sex:"女",city:"城市-0",sign:"签名-0",experience:255,logins:24,wealth:82830700,classify:"作家",score:57},
//                {id:10000,username:"user-0",sex:"女",city:"城市-0",sign:"签名-0",experience:255,logins:24,wealth:82830700,classify:"作家",score:57},
//                {id:10000,username:"user-0",sex:"女",city:"城市-0",sign:"签名-0",experience:255,logins:24,wealth:82830700,classify:"作家",score:57},
//                {id:10000,username:"user-0",sex:"女",city:"城市-0",sign:"签名-0",experience:255,logins:24,wealth:82830700,classify:"作家",score:57},
//            ]
            ,request: {
                pageName: 'nowIndex' //页码的参数名称，默认：page
                ,limitName: 'pageSize' //每页数据量的参数名，默认：limit
            }
            ,page: true //开启分页
            ,cols: [[ //表头
                {field: 'pk_user', title: 'ID', width:80, sort: true, fixed: 'left',hide:true}
                ,{field: 'userCode', title: 'ID', width:80, sort: true, fixed: 'left',hide:true}
                ,{field: 'userName', title: '用户名', width:80}
                ,{field: 'sex', title: '性别', width:80, sort: true}
                ,{field: 'city', title: '城市', width:80}
                ,{field: 'sign', title: '签名', width: 177}
                ,{field: 'telephone', title: '积分', width: 80, sort: true}
                ,{field: 'email', title: '评分', width: 80, sort: true}
                ,{field: 'score', title: '职业', width: 80}
                ,{field: 'wealth', title: '财富', width: 135, sort: true}
            ]]
        });

    });
</script>
</body>
</html>
<%@ include  file="../../pub/htmlend.jsp" %>
