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
    <title>资源管理</title>
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
        {field: 'pk_resource', title: '主键',hide:true},
        {field: 'permtype', title: '权限类型'},
        {field: 'secourcetype', title: '资源类型'},
        {field: 'title', title: '标题'},
        {field: 'content', title: '内容'},
        {field: 'price', title: '单价'},
        {field: 'orderno', title: '排序号'},
        {field: 'billtype', title: '数量'},
        {field: 'pk_china', title: '所属陶瓷'},
        {field: 'pk_know', title: '所属知识'},
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
    ];
    loadQueryPanl('#querypanl',query_cols);


    function doSave(data) {
        var aggVO={
            parentVO:data
        };
        var result=httpPost('/ww/chn/rsur/save',JSON.stringify(aggVO));
        if(result!=null)
            layer.msg(result.msg);
    };

    function doDelete(selecteddata) {
        var result=httpPost('/ww/chn/rsur/delete',JSON.stringify(selecteddata));
        if(result!=null)
            layer.msg(result.msg);
    };
    function doElse(event,datas) {

    }

</script>
<%@ include file="../../pub/htmlend.jsp" %>
