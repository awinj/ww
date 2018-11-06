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
    loadTable("#data_table","data",table_cols);


    var query_cols=[
        {field: 'userCode', title: '用户编码',},
        {field: 'userName', title: '用户名',},
        {field: 'isLocked', title: '是否锁定',},
        {field: 'telephone', title: '手机'},
        {field: 'email', title: '邮箱',},
        {field: 'sex', title: '性别',},
        {field: 'city', title: '城市',}
    ];
    loadQueryPanl('#querypanl',query_cols);


    var formfields=[ //表头
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
    ]

    function doAdd() {

        var html=createForm(formfields);
        layer.open({
            type:1,
            content: html,
            area: ['1000px', 'auto'],
            btn: ['保存', '取消'],
            yes: function(index, layero){
                //按钮【按钮一】的回调

                console.log(res);
            },
            cancel: function(){
                //右上角关闭回调

                //return false 开启该代码可禁止点击该按钮关闭
            }
        });
    }


    function doUpdate(selectedData) {
        var html=createForm(formfields,selectedData);
        layer.open({
            type:1,
            content: html,
            area: ['1000px', 'auto'],
            btn: ['保存', '取消'],
            yes: function(index, layero){
                //按钮【按钮一】的回调

                console.log(res);
            },
            cancel: function(){
                //右上角关闭回调

                //return false 开启该代码可禁止点击该按钮关闭
            }
        });
    }

</script>
<%@ include file="../../pub/htmlend.jsp" %>
