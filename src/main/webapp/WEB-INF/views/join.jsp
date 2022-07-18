<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>회원가입</title>
</head>
<body>
<form id="join_form" method="post" action="/joinProc.do">
    <table class="table">
        <tr>
            <th>이메일</th>
            <td><input type="text" name="email"/></td>

        </tr>
        <tr>
            <th>비밀번호</th>
            <td><input type="password" name="password"/></td>
        </tr>
        <tr>
            <th>이름</th>
            <td><input type="text" name="name"></td>
        </tr>
    </table>
    <input type="submit" value="완료">
    <input type="button" value="이전" onclick="location.href='/login.do'">
</form>
</body>
</html>
