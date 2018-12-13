<%--
  Created by IntelliJ IDEA.
  User: chenwei
  Date: 2018/12/12
  Time: 15:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Login</title>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/static/css/login.css"/>
</head>
<body>
<div id="login">
    <h1>Login</h1>
    <form method="post" action="<%=request.getContextPath() %>/login">
        <input type="text" required="required" placeholder="用户名" name="userName"></input>
        <input type="password" required="required" placeholder="密码" name="password"></input>
        <button class="button" type="submit">登录</button>
    </form>
</div>
</body>
</html>