<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:set var="action" value="${posts == null ? '/post/createProc.do' : '/post/editProc.do'}"/>
<form action="${action}" name="post_form" method="POST">
    <c:if test="${posts != null}">
        <input type="hidden" id="id" name="id" value="${posts.id}">
    </c:if>
    <h2>글쓰기</h2>
    <table>
        <input type="hidden" id="userId" name="userId" value="${sessionScope.session_id}">
        <tr>
            <td align="center">제목</td>
            <td><input type="text" id="title" name="title" value="${posts.title}">
        </tr>
        <tr>
            <td align="center">내용</td>
            <td><input type="text" id="body" name="body" value="${posts.body}">
        </tr>

        <tr align="center">
            <td colspan="2">
                <c:if test="${posts == null}">
                <button type="submit">등록</button>
                </c:if>
                <c:if test="${sessionScope.session_id == posts.user.id}">
                <button type="submit">수정</button>
                </c:if>
                <button type="button" onclick="location.href='/main.do'">이전</button>
                <c:if test="${sessionScope.session_id == posts.user.id}">
                <button type="button" onclick="location.href='/post/deleteProc.do?id='+ ${posts.id}">삭제</button>
                </c:if>
        </tr>
    </table>
</form>
<c:if test="${posts != null}">
    <jsp:include page="comment.jsp"/>
</c:if>
</body>
</html>
