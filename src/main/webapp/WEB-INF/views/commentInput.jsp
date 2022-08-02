<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<body id="wrap">
    <h2>댓글 상세보기</h2>
<div id="commentUpdateForm">
    <form name="comment_update_form" target="parentForm" action="/comment/editProc.do" method="POST">
        <input type="hidden" name="commentId" value="${comment.id}">
        <input type="hidden" name="postId" value="${comment.post.id}">
        <input type="hidden" name="userId" value="${sessionScope.session_id}">

        <input type="text" name="body" value="${comment.body}">
        <br><br>
        <button type="submit">수정</button>
        <button type="button" onclick="window.close()">닫기</button>
    </form>
</div>
</body>

