<%--
  Created by IntelliJ IDEA.
  User: 16174
  Date: 2020/2/19
  Time: 12:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加学生界面</title>
</head>
<body>
    <div style="margin-top: 100px;text-align:center">
        <h3>********添加学生********</h3>
    </div>
    <form action="Add" method="post">
        <table border="1" width="260" style="margin: auto;text-align:center;border-radius: 10px;">
        <tr>
            <td>编号</td>
            <td><input type="text" name="id"></td>
        </tr>
        <tr>
            <td>姓名</td>
            <td><input type="text" name="name"></td>
        </tr>
        <tr>
            <td>年龄</td>
            <td><input type="text" name="age"></td>
        </tr>
        <tr>
            <td>住址</td>
            <td><input type="text" name="home"></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="添加">
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <input type="reset" value="重置">
            </td>
        </tr>
        </table>
    </form>
</body>
</html>
