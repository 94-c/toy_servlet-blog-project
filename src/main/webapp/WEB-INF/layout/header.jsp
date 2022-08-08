<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

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
<input type="hidden" id="id" value="${sessionScope.session_id}">
    ${sessionScope.session_name} 님 환영 합니다.
<button type="button" onclick="location.href='/user/edit.do?id=${sessionScope.session_id}'">회원정보</button>
<button type="button" onclick="location.href='/logOut.do'">로그아웃</button>
</c:if>
