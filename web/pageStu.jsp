<%--
  Created by IntelliJ IDEA.
  User: 16174
  Date: 2020/2/20
  Time: 11:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>分页显示所有学生界面</title>
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
<form action="Find" method="post">
    <div style="margin-top: 100px;text-align:center">
        <h3>********分页显示所有学生********</h3>
    </div>
    <table border="1" width="700" style="margin: auto;text-align:center;border-radius: 10px;">
        <tr>
            <td colspan="5">
                按年龄查询：<input type="text" name="age">&nbsp;
                按地址查询：<input type="text" name="home">&nbsp;
                <input type="submit" value="查询">&nbsp;
                <input type="reset" value="重置">&nbsp;&nbsp;&nbsp;
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
        <tr>
            <td colspan="5">第${page}/${totalPage}页&nbsp;
                每页显示：3条&nbsp;
                总页数：${totalPage}&nbsp;&nbsp;&nbsp;&nbsp;
                <c:if test="${page != 1}">
                    <a href="Page?page=1">首页</a> | <a href="Page?page=${page-1}">上一页</a>
                </c:if>

                <c:forEach begin="1" end="${totalPage}" var="i">
                    <c:if test="${page == i}">${i}</c:if>
                    <c:if test="${page != i}"><a href="Page?page=${i}">${i}</a></c:if>
                </c:forEach>

                <c:if test="${page != totalPage}">
                    <a href="Page?page=${page+1}">下一页</a> | <a href="Page?page=${totalPage}">尾页</a>
                </c:if>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
