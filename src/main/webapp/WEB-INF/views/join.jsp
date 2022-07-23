<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>회원가입</title>
</head>
<body>
<form id="join_form" method="post" action="/joinProc.do" >
    <table class="table">
        <tr>
            <th>이메일</th>
            <td><input type="text" id="email" name="email" required oninput="checkEmail(this)"/></td>
            <span class="email_success" style="color:green; display: none" >사용 가능한 이메일입니다.</span>
            <span class="email_fail" style="color:red; display: none" >이미 회원 가입 된 이메일입니다.</span>
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
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script type="text/javascript">
    function checkEmail(){
        document.getElementById("email");
        $.ajax({
            url: '/emailCheck',
            type: 'POST',
            data: {email : email},
            success:function (){
                if(cnt != 1) {
                    $('.email_success').css("display", "inline-block");
                    $('.email_fail').css("display", "inline-block");
                } else {
                    $('.email_fail').css("display", "inline-block");
                    $('.email_success').css("display", "inline-block");
                }
            },
            error:function () {
                alert("에러입니다.");
            }
        });
    };

</script>
</html>
