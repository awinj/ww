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
    <%@ include file="../../pub/head.jsp" %>
    <style>.win_content { margin: 20px;}</style>
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
        <div class="layui-logo">标题</div>
        <!-- 头部区域（可配合layui已有的水平导航） -->
        <%--<ul class="layui-nav layui-layout-left">--%>
            <%--<li class="layui-nav-item"><a href="">控制台</a></li>--%>
            <%--<li class="layui-nav-item"><a href="">商品管理</a></li>--%>
            <%--<li class="layui-nav-item"><a href="">用户</a></li>--%>
            <%--<li class="layui-nav-item">--%>
                <%--<a href="javascript:;">其它系统</a>--%>
                <%--<dl class="layui-nav-child">--%>
                    <%--<dd><a href="">邮件管理</a></dd>--%>
                    <%--<dd><a href="">消息管理</a></dd>--%>
                    <%--<dd><a href="">授权管理</a></dd>--%>
                <%--</dl>--%>
            <%--</li>--%>
        <%--</ul>--%>
        <ul class="layui-nav layui-layout-right">
            <li class="layui-nav-item">
                <a href="javascript:;">
                    <img src="http://t.cn/RCzsdCq" class="layui-nav-img">
                    win
                </a>
                <dl class="layui-nav-child">
                    <dd><a href="">基本资料</a></dd>
                    <dd><a href="">安全设置</a></dd>
                </dl>
            </li>
            <li class="layui-nav-item"><a href="">注销</a></li>
        </ul>
    </div>

    <div class="layui-side layui-bg-black">
        <div class="layui-side-scroll">
            <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
            <ul class="layui-nav layui-nav-tree"  lay-filter="demo">
                <li class="layui-nav-item layui-nav-itemed">
                    <a class="javascript:;" href="javascript:;">基本元素<span class="layui-nav-more"></span></a>
                    <dl class="layui-nav-child">
                        <dd class="layui-this"><a href="index">列表一</a></dd>
                        <dd><a href="index">列表二</a></dd>
                        <dd><a href="index">列表三</a></dd>
                        <dd><a href="index">超链接</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a href="javascript:;">解决方案</a>
                    <dl class="layui-nav-child">
                        <dd><a href="index">列表一</a></dd>
                        <dd><a href="index">列表二</a></dd>
                        <dd><a href="index">超链接</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item"><a href="index">云市场</a></li>
                <li class="layui-nav-item"><a href="index">发布商品</a></li>

                <li class="layui-nav-item" style="height: 30px; text-align: center"></li>
                <span class="layui-nav-bar" ></span>
            </ul>
        </div>
    </div>

    <div class="layui-body">
        <!-- 内容主体区域 -->
        <div class="win_content">
            <table class="layui-hide" id="demo" lay-filter="test"></table>
        </div>
    </div>

    <div class="layui-footer">
        <!-- 底部固定区域 -->
        © layui.com - 底部固定区域
    </div>

</div>
<script>
    //JavaScript代码区域


    layui.use(['table','element'], function () {
        var table = layui.table;
        var element = layui.element;


        //第一个实例
        table.render({
            elem: '#demo',
            title: '用户',
            toolbar: 'default',
            url: 'query', //数据接口
            request: {
                pageName: 'index', //页码的参数名称，默认：page
                limitName: 'pageSize' //每页数据量的参数名，默认：limit
            },
            page: true, //开启分页
            cols: [[ //表头
//                {field: 'pk_user', title: 'ID', width:80, sort: true, fixed: 'left',hide:true}
                {type: 'checkbox', fixed: 'left'},
                {field: 'pk_user', title: '主键',  fixed: 'left', hide: true},
                {field: 'userCode', title: '用户编码', },
                {field: 'userName', title: '用户名', },
                {field: 'password', title: '密码',  hide: true},
                {field: 'isLocked', title: '是否锁定','width':85},
                {field: 'telephone', title: '手机'},
                {field: 'email', title: '邮箱', },
                {field: 'sex', title: '性别', },
                {field: 'city', title: '城市', },
                {field: 'sign', title: '签名', },
                {field: 'score', title: '分数', },
                {field: 'creator', title: '创建人',hide: true},
                {field: 'creationTime', title: '创建时间', hide: true},
                {field: 'modifier', title: '修改人',hide: true},
                {field: 'modifyTime', title: '修改时间',  hide: true},
                {field: 'ts', title: '时间戳',  hide: true},
                {field: 'dr', title: '删除标志', hide: true}
            ]]
        });

        //监听导航点击
        element.on(function(elem){
            console.log(elem); //得到当前点击的DOM对象
        });
    });
</script>
</body>

</html>
<%@ include file="../../pub/htmlend.jsp" %>
