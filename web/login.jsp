<%--
  Created by IntelliJ IDEA.
  User: 16174
  Date: 2020/2/16
  Time: 14:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录界面</title>
</head>
<body>
<div style="text-align: center;margin: 0 auto;width: 300px;height: 220px;background: cadetblue;border-radius: 10px">
    <form action="Login" method="post">
        <div style="margin-top: 100px">
            <h3>欢迎登录！！！</h3>
        </div>
        <div style="background: lightskyblue;margin: 20px;border-radius: 10px;width:260px;height: 30px;text-align: center">
            账号：<input name="username" type="text" style="width:150px">
        </div>
        <div style="background: lightskyblue;margin: 20px;border-radius: 10px;width: 260px;height: 30px;text-align: center">
            密码：<input name="password" type="password" style="width:150px">
        </div>
        <div>
            <input type="checkbox" name="auto_login" style="background: cadetblue;margin: 10px;width: 15px;height: 15px;text-align: center">自动登录
        </div>
        <div>
            <input type="submit" style="background: aqua;width: 100px;height: 25px;text-align: center;border-radius: 10px" value="登录">
            <input type="reset" style="background: aqua;width: 100px;height: 25px;text-align: center;border-radius: 10px" value="重置">
        </div>
    </form>
</div>
</body>
</html>
