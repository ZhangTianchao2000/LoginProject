<%--
  Created by IntelliJ IDEA.
  User: 16174
  Date: 2020/2/19
  Time: 17:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>模糊查询界面</title>
    <script type="text/javascript">
        function doDelete(id) {
            var flag = confirm("是否确定删除！！！");
            if(flag){
                //确定删除，在当前标签页上打开超链接
                //window.location.href="DeleteServlet?id="+id;//等价于
                location.href="DeleteServlet?id="+id;
            }
        }
    </script>
</head>
<body>
<div style="margin-top: 100px;text-align:center">
    <h3>********显示模糊查询学生********</h3>
</div>
<table border="1" width="700" style="margin: auto;text-align:center;border-radius: 10px;">
    <tr>
        <td colspan="5">
            <a href="addStu.jsp">添加</a>
        </td>
    </tr>
    <tr>
        <td>编号</td>
        <td>姓名</td>
        <td>年龄</td>
        <td>地址</td>
        <td>操作</td>
    </tr>
    <%--@elvariable id="list" type="java.util.List"--%>
    <c:forEach items="${list}" var="stu">
        <tr>
            <td>${stu.id}</td>
            <td>${stu.name}</td>
            <td>${stu.age}</td>
            <td>${stu.home}</td>
            <td>
                <a href="Up?id=${stu.id}">更新</a>
                <a href="#" onclick="doDelete(${stu.id})">删除</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
