<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>내가 쓴 게시글</h1>
    <div>
        <table border="1" cellpadding="5">
            <tr>
                <th>Index</th>
                <th>Title</th>
                <th>Writer</th>
                <th>Date Created</th>
            </tr>
            <c:forEach var="post" items="${postList}" varStatus="status">
                <tr>
                    <td><input type="hidden" id="id" value="${param.id}"></td>
                    <%--<td>${post.id}</td>
                    <td><a href="/post/edit.do?id=${post.id}">${post.title}</a></td>
                    <td>${post.user.name}</td>
                    <td><fmt:formatDate pattern='MM/dd/yyyy' value='${post.createdAt}'/></td>--%>
                </tr>
            </c:forEach>
        </table>
    </div>
</body>
</html>
