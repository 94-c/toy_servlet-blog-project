<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<body id="wrap">
<h2>댓글 답변</h2>
<div id="parent_comment_form">
    <form name="parent_comment_form" target="parentForm" method="post" action="/parenComment/createProc.do">
        <input type="hidden" id="commentId" name="commentId" value="${param.commentId}">
        <input type="hidden" id="postId" name="postId" value="${param.postId}">
        <input type="hidden" id="userId" name="userId" value="${sessionScope.session_id}">

        <textarea type="rows" cols="50" name="parentBody"></textarea>
        <br><br>
        <button type="submit" onclick="">등록</button>
        <button type="button" onclick="window.close()">닫기</button>
    </form>
</div>
</body>

