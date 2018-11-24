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


<div id="tree" style="display: none">
    <ul class="wintree" >
        <li class="node">
            <div >
                <div class="extend"><span>+</span></div>
                <input type="checkbox">
                <label>根目录</label>
            </div>
            <ul  >
                <li><input type="checkbox"><label>一级目录</label></li>
                <li><input type="checkbox"><label>一级目录</label></li>
                <%--<li> <div class="extend"><span>+</span></div><input type="checkbox"><label>一级目录</label></li>--%>
                <li class="node">
                    <div ><div class="extend"><span>+</span></div><input type="checkbox"><label>一级目录</label></div>
                    <ul  >
                        <li><input type="checkbox"><label>二级目录</label></li>
                        <li><input type="checkbox"><label>二级目录</label></li>
                        <li><input type="checkbox"><label>二级目录</label></li>
                        <li class="node">
                            <div ><div class="extend"><span>+</span></div><input type="checkbox"><label>二级目录</label></div>
                            <ul  >
                                <li><input type="checkbox"><label>三级目录</label></li>
                                <li><input type="checkbox"><label>三级目录</label></li>
                                <li><input type="checkbox"><label>三级目录</label></li>
                            </ul>
                        </li>
                    </ul>
                </li>
                <li><input type="checkbox"><label>一级目录</label></li>
                <li><input type="checkbox"><label>一级目录</label></li>
            </ul>
        </li>
        <li>
            <input type="checkbox"><label>根目录</label>
        </li>


    </ul>
    <input class="tree_ok" type="button" value="确认" />
    <input class="tree_cancel" type="button" value="取消">
</div>
</body>

</html>
<script id="toolbar" type="text/html">
    <div class="layui-btn-container">
            <div title="增加" class="layui-inline" lay-event="add"><i class="layui-icon layui-icon-add-1"></i></div>
            <div title="修改" class="layui-inline" lay-event="update"><i class="layui-icon layui-icon-edit"></i></div>
            <div title="分配" class="layui-inline" lay-event="assigne"><i>分配</i>分配</div>
            <div title="删除" class="layui-inline" lay-event="delete"><i class="layui-icon layui-icon-delete"></i></div>
    </div>
</script>
<script>
    var table_cols=[[ //表头
//                {field: 'pk_user', title: 'ID', width:80, sort: true, fixed: 'left',hide:true}
        {type: 'checkbox', fixed: 'left'},
        {field: 'pk_user', title: '主键', fixed: 'left', hide: true},
        {field: 'userCode', title: '用户编码'},
        {field: 'userName', title: '用户名',},
        {field: 'password', title: '密码', hide: true},
        {field: 'isLocked', title: '已锁定', 'width': 85},
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
//        {field: 'city', title: '城市',}
    ];
    loadQueryPanl('#querypanl',query_cols);


    function doSave(data) {
        var aggVO={
            parentVO:data
        };

//        $.ajax({
//            url:'/ww/auth/user/save',
//            type:'post',
//            dataType:'json',
//            contentType:'application/json;charset=UTF-8',
//            data:JSON.stringify(aggVO),
//            success:function (result) {
//                layer.msg("保存成功");
//            },
//            error:function (result) {
//                layer.msg("保存失败");
//            }
//        });
        var result=httpPost('/ww/auth/user/save',JSON.stringify(aggVO));
        if(result!=null)
            layer.msg(result.msg);

    }

    function doElse(event,data) {

        var result=httpPost("/ww/auth/role/availableRole")
        layer.open({
            type:1,
            content: result,
            area:  '40%',
        });
    }

</script>
<%@ include file="../../pub/htmlend.jsp" %>
