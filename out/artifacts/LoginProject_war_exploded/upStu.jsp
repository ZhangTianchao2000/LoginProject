<%--
  Created by IntelliJ IDEA.
  User: 16174
  Date: 2020/2/19
  Time: 14:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改学生界面</title>
</head>
<body>
<div style="margin-top: 100px;text-align:center">
    <h3>********修改学生********</h3>
</div>
<form action="Update" method="post">
    <table border="1" width="260" style="margin: auto;text-align:center;border-radius: 10px;">
        <tr>
            <td>编号</td>
            <td><input type="text" name="id" value="${id}"></td>
        </tr>
        <tr>
            <td>姓名</td>
            <td><input type="text" name="name" value="${name}"></td>
        </tr>
        <tr>
            <td>年龄</td>
            <td><input type="text" name="age" value="${age}"></td>
        </tr>
        <tr>
            <td>住址</td>
            <td><input type="text" name="home" value="${home}"></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="确认">
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <input type="reset" value="重置">
            </td>
        </tr>
    </table>
</form>
</body>
</html>
