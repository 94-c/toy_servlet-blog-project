<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:set var="action" value="${post == null ? '/post/createProc.do' : '/post/editProc.do'}"/>
<form action="${action}" name="post_form" method="POST">
<table>
    <tr>
        <td>
            <table width="100%" cellpadding="0" cellspacing="0" border="0">
                <td>글쓰기</td>
            </table>
            <input type="hidden" name="userId" value="${sessionScope.session_id}">
            <table>
                <tr>
                    <td>&nbsp;</td>
                    <td align="center">제목</td>
                    <td><input name="title" size="50" maxlength="100"></td>
                    <td>&nbsp;</td>
                </tr>
                <tr>
                    <td>&nbsp;</td>
                    <td align="center">내용</td>
                    <td><textarea name="body" cols="50" rows="13"></textarea></td>
                    <td>&nbsp;</td>
                </tr>

                <tr align="center">
                    <td>&nbsp;</td>
                    <td colspan="2">
                        <button type="submit">등록</button>
                        <button type="button" onclick="location.href='/main.do'">이전</button>
                    <td>&nbsp;</td>
                </tr>
            </table>
        </td>
    </tr>
</table>
</form>
</body>
</html>
