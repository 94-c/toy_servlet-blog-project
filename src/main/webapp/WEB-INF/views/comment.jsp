<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<body>
<h2>댓글 작성</h2>
<c:if test="${sessionScope.session_id != null}">
    <form action="/comment/createProc.do" name="create_comment" method="POST">
        <input type="hidden" id="postId" name="postId" value="${param.id}">
        <input type="hidden" id="userId" name="userId" value="${sessionScope.session_id}">
        <table>
            <tr>
                <td align="center">작성자</td>
                <td>${sessionScope.session_name}</td>
            </tr>
            <tr>
                <td align="center">내용</td>
                <td><input type="text" id="body" name="body"></td>
            </tr>

            <tr align="center">
                <td colspan="2">
                    <c:if test="${sessionScope.session_id != null}">
                    <button type="submit">작성</button>
                    </c:if>
            </tr>
        </table>
    </form>
</c:if>
<h2>댓글 목록</h2>
<c:if test="${commentList != null}">
    <table border="1" cellpadding="5">
        <tr>
            <th>작성자</th>
            <th>내용</th>
            <th>버튼</th>
        </tr>
        <c:forEach var="comment" items="${commentList}">
            <tr>
                <td>${comment.user.name}</td>
                <td>${comment.body}</td>
                <td>
                    <div id="button">
                        <c:if test="${comment.user.id == sessionScope.session_id}">
                            <input type="hidden" name="postId" value="${param.id}">
                            <button type="button" onclick="replyComment(${comment.id})">답변</button>
                            <button type="button" onclick="updateComment(${comment.id})">수정</button>
                            <button type="button"
                                    onclick="location.href='/comment/deleteProc.do?commentId='+${comment.id}+'&postId='+${param.id}">
                                삭제
                            </button>
                        </c:if>
                    </div>
                </td>
            </tr>
        </c:forEach>
    </table>
</c:if>
</body>
<script type="text/javascript">
    function updateComment(commentId) {
        window.name = "parentForm";
        window.open("/comment/edit.do?commentId=" + commentId, "updateForm", "width=570, height=350, resizable=no, scrollbars=no");
    }

    function replyComment(commentId) {
        window.name = "parentForm";
        window.open("/parenComment/create.do?commentId=" + commentId, "replyForm", "width=570, height=350, resizable=no, scrollbars=no");
    }
</script>