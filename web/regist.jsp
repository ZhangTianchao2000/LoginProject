<%--
  Created by IntelliJ IDEA.
  User: 16174
  Date: 2020/2/16
  Time: 14:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册界面</title>
</head>
<body>
<div style="text-align: center;margin: 0 auto;width: 300px;height: 200px;background: cadetblue;border-radius: 10px">
    <form action="Regist" method="post">
        <div style="margin-top: 100px">
            <h3>欢迎注册！！！</h3>
        </div>
        <div style="background: lightskyblue;margin: 20px;border-radius: 10px;width:260px;height: 30px;text-align: center">
            账号：<input name="username" type="text" style="width:150px">
        </div>
        <div style="background: lightskyblue;margin: 20px;border-radius: 10px;width: 260px;height: 30px;text-align: center">
            密码：<input name="password" type="password" style="width:150px">
        </div>
        <div>
            <input type="submit" style="background: aqua;width: 100px;height: 25px;text-align: center;border-radius: 10px" value="注册">
            <input type="reset" style="background: aqua;width: 100px;height: 25px;text-align: center;border-radius: 10px" value="重置">
        </div>
    </form>
</div>
</body>
</html>
