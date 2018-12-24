<%--
  Created by IntelliJ IDEA.
  User: aWin
  Date: 2018-12-21
  Time: 23:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>藏品资源</title>
    <%@ include file="../../pub/head.jsp" %>
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
                        <table class="layui-table">
                            <tr>
                                <td><label class="layui-form-label">标题</label><input name="title" value="青花瓷"></td>
                                <td><label>标题</label><input name="title" value="青花瓷"></td>
                                <td><label>标题</label><input name="title" value="青花瓷"></td>
                                <td><label>标题</label><input name="title" value="青花瓷"></td>
                                <td><label>标题</label><input name="title" value="青花瓷"></td>
                                <td><label>标题</label><input name="title" value="青花瓷"></td>
                            </tr>
                        </table>
                    </div>
                </div>
            </div>
        </div>


<%@ include file="../../pub/footer.jsp" %>
</div>
</body>
</html>
