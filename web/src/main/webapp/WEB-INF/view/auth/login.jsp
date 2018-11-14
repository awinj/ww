<%--
  Created by IntelliJ IDEA.
  User: aWin
  Date: 2018-09-08
  Time: 10:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Title</title>
  <%@ include  file="../pub/head.jsp" %>
</head>
<body>

<form action="" method="post">
  <div>


        <div class="layui-form-item">
          <div class="layui-inline">
            <label class="layui-form-label">用户名</label>
            <div class="layui-input-inline">
              <input name="userName" class="layui-input"  autocomplete="off" lay-verify="required" value=${model.userName}>
            </div>
          </div>
          <div class="layui-inline">
            <label class="layui-form-label">密码</label>
            <div class="layui-input-inline">
              <input name="password" class="layui-input" type="password" autocomplete="off" lay-verify="password|required" value=${model.password}>
            </div>
          </div>
          <div class="layui-inline">
            <button class="layui-btn layui-btn-primary">登陆</button>
          </div>
        </div>







  </div>
</form>



</body>
</html>
<%@ include  file="../pub/htmlend.jsp" %>
