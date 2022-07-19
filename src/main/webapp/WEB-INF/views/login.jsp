<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>로그인 화면</title>
  </head>
  <body>
  <form id="login_form" method="post" action="/loginProc.do">
    <div class="container">
      이메일 : <input type="text" name="email">
      비밀번호 : <input type="password" name="password">
      <input type="submit" value="로그인">
      <input type="button" onclick="location.href='/join.do'" value="회원가입">
    </div>
  </form>
  </body>
</html>
