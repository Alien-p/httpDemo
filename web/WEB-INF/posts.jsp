<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Ildar
  Date: 14.12.2016
  Time: 21:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border = 1>
    <c:forEach items="${posts}" var="post">
        <tr>
            <td>${post.id}</td>
            <td><c:out value="${post.txt}"></c:out></td>
            <td>
                <a href="delete?id=${post.id}">
                    <img src="delete.png"/>
                </a>
            </td>
        </tr>
    </c:forEach>
    <form action="/add" method="post">
        <tr>
            <td>Введите текст: </td>
            <td colspan="2"><input type="text" name="txt"></td>
        </tr>
        <tr>
            <td colspan="1"><input type="submit" value="Отправить"></td>
        </tr>
    </form>
</table>
</body>
</html>
