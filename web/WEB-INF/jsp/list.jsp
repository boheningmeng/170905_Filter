<%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 2017/9/1
  Time: 18:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>信息查看</title>
</head>
<body>


<table align='center' border='1' cellspacing='0'>
    <tr>
        <td>ID</td>
        <td>Name</td>
        <td>Age</td><td>Password</td>
        <td>修改</td>
        <td>删除</td>
    </tr>
    <c:forEach items="${list}" var="student">
        <tr>
            <td>${student.id}</td>
            <td>${student.name}</td>
            <td>${student.age}</td>
            <td>${student.password}</td>
            <td><a href="change.jsp?id=${c.id}">修改</a></td>
            <td><a href="delete.jsp?id=${c.id}">删除</a></td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
