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
    <title>角色管理</title>
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

<script>
    var table_cols=[[ //表头
//                {field: 'pk_user', title: 'ID', sort: true, fixed: 'left',hide:true}
        {type: 'checkbox', fixed: 'left'},
        {field: 'pk_role', title: '主键',hide:true},
        {field: 'roleCode', title: '角色编码'},
        {field: 'roleName', title: '角色名称'},
        {field: 'roleType', title: '角色类型'},
        {field: 'memo', title: '备注'},
        {field: 'enable', title: '是否锁定'},
        {field: 'creator', title: '创建人',hide:true},
        {field: 'creationTime', title: '创建时间',hide:true},
        {field: 'modifier', title: '修改人',hide:true},
        {field: 'modifyTime', title: '修改时间',hide:true},
        {field: 'ts', title: '时间戳',hide:true},
        {field: 'dr', title: '删除标志',hide:true}


    ]];
    loadTable("#data_table","data",table_cols);


    var query_cols=[
        {field: 'roleCode', title: '角色编码'},
        {field: 'roleName', title: '角色名称'},
        {field: 'roleType', title: '角色类型'},
        {field: 'isLocked', title: '是否锁定',}
//        {field: 'city', title: '城市',}
    ];
    loadQueryPanl('#querypanl',query_cols);


    function doSave(data) {
        var aggVO={
            parentVO:data
        };

        $.ajax({
            url:'/ww/auth/role/save',
            type:'post',
            dataType:'json',
            contentType:'application/json;charset=UTF-8',
            data:JSON.stringify(aggVO),
            success:function (result) {
                layer.msg("保存成功");
            },
            error:function (result) {
                layer.msg("保存失败");
            }
        });

    }


</script>
<%@ include file="../../pub/htmlend.jsp" %>
