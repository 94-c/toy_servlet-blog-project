<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<body>
<form action="/emailConfirmProc.do" method="post">
    <input type="hidden" name="userId" value="${param.userId}">
    <input type="hidden" name="token" value="${param.authKey}">
    <input type="hidden" name="email" value="${param.email}">
    <input type="hidden" name="id" value="${param.id}">

    <h1>회원가입을 축하드립니다.</h1>
    <h2>하단의 버튼 클릭 시, 블로그 접속이 가능합니다.</h2>

    <button type="submit">확인</button>
</form>
</body>
</html>
