<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>회원정보</title>
</head>
<body>
<h1>회원 정보</h1>
<c:set var="action" value="${'/user/editProc.do'}"/>
<form id="user_edit_form" method="post" action="${action}">
    <input type="hidden" name="id" value="${param.id}">
    <input type="hidden" name="state" value="${user.state}">
    <table class="table">
        <tr>
            <th>이메일</th>
            <td><input type="hidden" id="email" name="email" value="${user.email}"/>
                ${user.email}</td>
        </tr>
        <tr>
            <!-- 수정 시, 비밀번호 변경도 같이 할 수 있도록 -->
            <th>비밀번호</th>
            <td><input type="password" name="password" value="${user.password}"/></td>
        </tr>
        <tr>
            <th>이름</th>
            <td><input type="text" name="name" value="${user.name}"></td>
        </tr>
    </table>
    <input type="submit" value="수정">
    <input type="button" value="이전" onclick="location.href='/main.do'">
</form>
</body>
</html>
