<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
    <title>藏品管理</title>
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
<body class="layui-layout-body site">
<div class="layui-layout layui-layout-admin">

    <%--<%@ include file="../../pub/nav.jsp" %>--%>
    <jsp:include page="/auth/nav"></jsp:include>
    <div class="layui-body">
        <!-- 内容主体区域 -->
        <div class="layui-fluid">

            <div class="layui-card">
                <div id="querypanl"></div>
                <div class="layui-card-body">
                    <table class="layui-hide" id="data_table" lay-filter="data"></table>
                </div>
            </div>
        </div>
    </div>
    <%@ include file="../../pub/footer.jsp" %>
</div>
<%@ include file="form.jsp"%>

</body>

</html>
<script id="toolbar" type="text/html">
    <div class="layui-btn-container">
            <div title="增加" class="layui-inline" lay-event="add"><i class="layui-icon layui-icon-add-1"></i></div>
            <div title="修改" class="layui-inline" lay-event="update"><i class="layui-icon layui-icon-edit"></i></div>
            <div title="分配" class="layui-inline" lay-event="assign"><i>分配</i>分配</div>
            <div title="删除" class="layui-inline" lay-event="delete"><i class="layui-icon layui-icon-delete"></i></div>
    </div>
</script>
<script>
    var table_cols=[[
        {field: 'pk_china', title: '主键',hide:true},
        {field: 'title', title: '标题'},
        {field: 'code', title: '编号'},
        {field: 'pk_author', title: '作者'},
        {field: 'kilneye', title: '窑口'},
        {field: 'times', title: '年代'},
        {field: 'model', title: '造型'},
        {field: 'num', title: '数量'},
        {field: 'memo', title: '简介'},
        {field: 'keyword', title: '关键词'},
        {field: 'syskeyword', title: '系统关键词'},
        {field: 'price', title: '单价'},
        {field: 'creator', title: '创建人'},
        {field: 'creationTime', title: '创建时间'},
        {field: 'modifier', title: '修改人'},
        {field: 'modifyTime', title: '修改时间'},
        {field: 'ts', title: '时间戳'},
        {field: 'dr', title: '删除标志'},


    ]];





    loadTable("#data_table","data",table_cols);


    var query_cols=[
        {field: 'title', title: '标题'},
        {field: 'code', title: '编号'},
    ];
    loadQueryPanl('#querypanl',query_cols);


    function doSave(data) {
        var aggVO={
            parentVO:data
        };
        var result=httpPost('/ww/chn/china/save',JSON.stringify(aggVO));
        if(result!=null)
            layer.msg(result.msg);
    };

    function doDelete(selecteddata) {
        var result=httpPost('/ww/chn/china/delete',JSON.stringify(selecteddata));
        if(result!=null)
            layer.msg(result.msg);
    };
    function doElse(event,datas) {

    }

</script>
<%@ include file="../../pub/htmlend.jsp" %>