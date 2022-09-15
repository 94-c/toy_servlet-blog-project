<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<body id="wrap">
<h2>댓글 답변</h2>
<div id="parent_comment_form">
    <c:set var="action" value="${parentComment == null ? '/parenComment/create.do' : '/parenComment/edit.do'}"/>
    <form name="parent_comment_form" target="parentForm" method="post" action="${action}">
        <c:if test="${parentComment.parentsId == null}">
            <input type="hidden" id="commentId" name="commentId" value="${param.commentId}">
            <input type="hidden" id="postId" name="postId" value="${param.postId}">
            <input type="hidden" id="userId" name="userId" value="${sessionScope.session_id}">
        </c:if>
        <c:if test="${parentComment.parentsId != null}">
            <input type="hidden" id="id" name="id" value="${parentComment.id}">
            <input type="hidden" id="parentId" name="parentId" value="${parentComment.parentsId}">
            <input type="hidden" id="postId" name="postId" value="${parentComment.post.id}">
            <input type="hidden" id="userId" name="userId" value="${parentComment.user.id}">
        </c:if>

        <textarea type="rows" cols="50" name="parentBody">${parentComment.body}</textarea>
        <br><br>

        <c:if test="${parentComment.parentsId == null}">
            <button type="submit">등록</button>
        </c:if>
        <c:if test="${parentComment.parentsId != null}">
            <button type="submit">수정</button>
        </c:if>
        <button type="button" onclick="window.close()">닫기</button>
    </form>
</div>
</body>

