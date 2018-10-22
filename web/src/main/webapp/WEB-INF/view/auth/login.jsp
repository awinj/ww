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
    用户名：<input id="userName" autocomplete="off" type="text" name="userName"  onclick="layuiRefdoc('#userName','#pk',false,false)" value=${model.userName}>
      <input id="pk" type="text"  >
    密码：<input type="password" name="password" value=${model.password} >
    <input type="submit" value="登录">  ${model.msg}
  </div>
</form>



</body>
</html>
<%@ include  file="../pub/htmlend.jsp" %>
