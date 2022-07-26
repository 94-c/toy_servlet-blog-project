<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:if test="${sessionScope.session_id == null}">
    <form id="login_form" method="post" action="/loginProc.do">
        <div class="container">
            이메일 : <input type="text" name="email">
            비밀번호 : <input type="password" name="password">
            <input type="submit" value="로그인">
            <input type="button" onclick="location.href='/join.do'" value="회원가입">
        </div>
    </form>
</c:if>
<c:if test="${sessionScope.session_id != null}">
    ${sessionScope.session_name} 님 환영 합니다.
    <button type="button" onclick="">회원정보</button>
    <button type="button" onclick="">로그아웃</button>
</c:if>
<c:if test="${sessionScope.session_id != null}">
    <br><br>
    <button type="button"  onclick="location.href='/post/create.do'">작성</button>
</c:if>
<br>
<br>
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
                <td>${post.id}</td>
                <td><a href="/post/edit.do?id=${post.id}">${post.title}</a></td>
                <td>${post.user.name}</td>
                <td><fmt:formatDate pattern='MM/dd/yyyy' value='${post.createdAt}'/></td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>

