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
    <title>功能管理</title>
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

    <%@ include file="../../pub/nav.jsp" %>
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
        <div title="增加"  class="layui-inline" lay-event="add"><i class="layui-icon layui-icon-add-1"></i></div>
        <div title="修改"  class="layui-inline" lay-event="update"><i class="layui-icon layui-icon-edit"></i></div>
        <div title="删除"  class="layui-inline" lay-event="delete"><i class="layui-icon layui-icon-delete"></i></div>
    </div>
</script>
<script>
    var table_cols=[[ //表头
//                {field: 'pk_user', title: 'ID', sort: true, fixed: 'left',hide:true}
        {type: 'checkbox', fixed: 'left'},
        {field: 'pk_power', title: '主键',hide:true},
        {field: 'powerCode', title: '功能编码'},
        {field: 'powerName', title: '功能名称'},
        {field: 'powerType', title: '功能类型'},
        {field: 'url', title: '地址'},
        {field: 'memo', title: '备注'},
        {field: 'enable', title: '是否锁定'},
        {field: 'creator', title: '创建人',hide:true},
        {field: 'creationTime', title: '创建时间',hide:true},
        {field: 'modifier', title: '修改人',hide:true},
        {field: 'modifyTime', title: '修改时间',hide:true},
        {field: 'ts', title: '时间戳',hide:true},
        {field: 'dr', title: '删除标志',hide:true},

    ]];
    loadTable("#data_table","data",table_cols);


    var query_cols=[
        {field: 'powerCode', title: '功能编码'},
        {field: 'powerName', title: '功能名称'},
        {field: 'powerType', title: '功能类型'},
        {field: 'isLocked', title: '是否锁定',}
//        {field: 'city', title: '城市',}
    ];
    loadQueryPanl('#querypanl',query_cols);


    function doSave(data) {
        var aggVO = {
            parentVO: data
        };

        var result = httpPost('/ww/auth/power/save', JSON.stringify(aggVO));
        if (result != null)
            layer.msg(result.msg);
    };

    function doDelete(selecteddata) {
        var result=httpPost('/ww/auth/power/delete',JSON.stringify(selecteddata));
        if(result!=null)
            layer.msg(result.msg);
    };


</script>
<%@ include file="../../pub/htmlend.jsp" %>
