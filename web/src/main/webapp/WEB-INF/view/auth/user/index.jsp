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
    <style>
        .layui-card-header.layuiadmin-card-header-auto {
            padding-top: 15px;
            padding-bottom: 15px;
            height: auto;
        }

        .layuiadmin-card-header-auto :last-child.layui-form-item {
            margin-bottom: 0px;
        }

    </style>
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">

    <%@ include file="../../pub/nav.jsp" %>
    <div class="layui-body">
        <!-- 内容主体区域 -->
        <div class="layui-fluid">

            <div class="layui-card">
                <div id="querypanl"></div>
                <%--<div class="layui-form layui-card-header layuiadmin-card-header-auto"--%>
                     <%--lay-filter="app-content-workorder">--%>
                    <%--<div class="layui-form-item">--%>
                        <%--<div class="layui-inline">--%>
                            <%--<label class="layui-form-label">用户名</label>--%>
                            <%--<div class="layui-input-block">--%>
                                <%--<input name="userName" class="layui-input" type="text" placeholder="请输入"--%>
                                       <%--autocomplete="off">--%>
                            <%--</div>--%>
                        <%--</div>--%>
                        <%--<div class="layui-inline">--%>
                            <%--<label class="layui-form-label">用户编码</label>--%>
                            <%--<div class="layui-input-block">--%>
                                <%--<input name="userCode" class="layui-input" type="text" placeholder="请输入"--%>
                                       <%--autocomplete="off">--%>
                            <%--</div>--%>
                        <%--</div>--%>
                        <%--<div class="layui-inline">--%>
                            <%--<label class="layui-form-label">手机号</label>--%>
                            <%--<div class="layui-input-block">--%>
                                <%--<input name="attr" class="layui-input" type="text" placeholder="请输入" autocomplete="off">--%>
                            <%--</div>--%>
                        <%--</div>--%>
                        <%--<div class="layui-inline">--%>
                            <%--<label class="layui-form-label">性别</label>--%>
                            <%--<div class="layui-input-block">--%>
                                <%--<input name="accept" class="layui-input" type="text" placeholder="请输入"--%>
                                       <%--autocomplete="off">--%>
                            <%--</div>--%>
                        <%--</div>--%>
                        <%--<div class="layui-inline">--%>
                            <%--<button class="layui-btn layuiadmin-btn-order" lay-filter="LAY-app-order-search"--%>
                                    <%--lay-submit="">--%>
                                <%--<i class="layui-icon layui-icon-search layuiadmin-button-btn"></i>--%>
                            <%--</button>--%>
                        <%--</div>--%>
                    <%--</div>--%>
                <%--</div>--%>

                <div class="layui-card-body">
                    <table class="layui-hide" id="data_table" lay-filter="data"></table>
                </div>
            </div>
        </div>
    </div>

    <%@ include file="../../pub/footer.jsp" %>

</div>
</body>

</html>

<script>
    var table_cols=[[ //表头
//                {field: 'pk_user', title: 'ID', width:80, sort: true, fixed: 'left',hide:true}
        {type: 'checkbox', fixed: 'left'},
        {field: 'pk_user', title: '主键', fixed: 'left', hide: true},
        {field: 'userCode', title: '用户编码',},
        {field: 'userName', title: '用户名',},
        {field: 'password', title: '密码', hide: true},
        {field: 'isLocked', title: '是否锁定', 'width': 85},
        {field: 'telephone', title: '手机'},
        {field: 'email', title: '邮箱',},
        {field: 'sex', title: '性别',},
        {field: 'city', title: '城市',},
        {field: 'sign', title: '签名',},
        {field: 'score', title: '分数',},
        {field: 'creator', title: '创建人', hide: true},
        {field: 'creationTime', title: '创建时间', hide: true},
        {field: 'modifier', title: '修改人', hide: true},
        {field: 'modifyTime', title: '修改时间', hide: true},
        {field: 'ts', title: '时间戳', hide: true},
        {field: 'dr', title: '删除标志', hide: true}
    ]];
    loadtable("#data_table","data",table_cols);


    var query_cols=[
        {field: 'userCode', title: '用户编码',},
        {field: 'userName', title: '用户名',},
        {field: 'isLocked', title: '是否锁定',},
        {field: 'telephone', title: '手机'},
        {field: 'email', title: '邮箱',},
        {field: 'sex', title: '性别',},
        {field: 'city', title: '城市',}
    ];
    loadquerypanl('#querypanl',query_cols);
</script>
<%@ include file="../../pub/htmlend.jsp" %>
