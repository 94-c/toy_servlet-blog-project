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
                <input type="text" id="body">
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
                        ${comment.id}
                </div>
            </td>
            <td>
                <div>
                        ${comment.body}
                </div>
            </td>
            <td>
                <div id="button">
                    <a href="#">답변</a>
                    <c:if test="${comment.user.id == sessionScope.session_id}">
                        <a href="#">수정</a>
                        <a href="#">삭제</a>
                    </c:if>
                </div>
            </td>
        </tr>
    </c:forEach>
</c:if>


</body>
