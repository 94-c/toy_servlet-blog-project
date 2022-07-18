<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>회원가입</title>
</head>
<body>
    <form id="join_form" method="post" action="/joinProc.do">
        이메일 : <input type="text" name="email"/>
        비밀번호 : <input type="password" name="password"/>
        이름 : <input type="text" name="name"/>
        <input type="submit" value="완료">
        <input type="button" value="이전" onclick="location.href='/login.do'">
    </form>
</body>
</html>
