<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<body>
<h2>댓글 작성</h2>
<c:if test="${sessionScope.session_id != null}">
    <form action="/comment/createProc.do" name="create_comment" method="POST">
        <input type="hidden" id="postId" name="postId" value="${param.id}">
        <input type="hidden" id="userId" name="userId" value="${sessionScope.session_id}">
        <td>
            <div>
                    ${sessionScope.session_userId}
            </div>
        </td>
        <td>
            <div>
                <input type="text" name="body">
            </div>
        </td>
        <td>
            <button type="submit">작성</button>
        </td>
    </form>
</c:if>

<c:if test="${commentList != null}">
    <c:forEach var="comment" items="${commentList}">
        <tr>
            <td>
                <div>
                        ${comment.user.name}
                </div>
            </td>
            <td>
                <div>
                        ${comment.body}
                </div>
            </td>
            <td>
                <div id="button">
                    <c:if test="${comment.user.id == sessionScope.session_id}">
                        <input type="hidden" name="postId" value="${param.id}">
                        <button type="button" onclick="replyComment(${comment.id})">답변</button>
                        <a href="#">수정</a>
                        <button type="button" onclick="location.href='/comment/deleteProc.do?commentId='+${comment.id}+'&postId='+${param.id}">삭제</button>
                    </c:if>
                </div>
            </td>
        </tr>
    </c:forEach>
</c:if>
</body>
<script type="text/javascript">
    function replyComment(commentId)
    {
        window.name = "parentForm";
        window.open("/parenComment/create.do?commentId="+commentId, "replyForm", "width=570, height=350, resizable=no, scrollbars=no");
    }
</script>