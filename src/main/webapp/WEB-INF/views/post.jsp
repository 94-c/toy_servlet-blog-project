<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="../layout/header.jsp"/>

<style>
    html,
    body {
        height: 100%;
    }

    body {
        display: flex;
        align-items: center;
        padding-top: 40px;
        padding-bottom: 40px;
        background-color: #ffffff;
    }

    .container {
        width: 1200px;
        max-width: 1200px;
        padding: 15px;
        margin: auto;
    }

    .container table {
        padding: 60px 15px 0;
    }

    .container table > td {
        text-align: center;
    }

    .container button[id="createBtn"] {
        width: 200px;
        text-align: center;
        margin: .25rem;
        padding: .5rem 1rem;
        text-decoration: none;
        font-weight: bold;
    }
</style>
<main class="flex-shrink-0">
    <div class="container" >
        <c:set var="action" value="${posts == null ? '/post/createProc.do' : '/post/editProc.do'}"/>
        <form action="${action}" name="post_form" method="POST">
            <c:if test="${posts != null}">
                <input type="hidden" id="id" name="id" value="${posts.id}">
            </c:if>
            <h2>글쓰기</h2>
            <table class="table table-hover">
                <tbody>
                <input type="hidden" id="userId" name="userId" value="${sessionScope.session_id}">
                <tr>
                    <c:if test="${sessionScope.session_id != null}">
                    <td><input type="text" class="form-control" id="title" name="title" value="${posts.title}" maxlength="40" placeholder="글 제목을 입력해주세요."></td>
                    </c:if>
                    <c:if test="${sessionScope.session_id == null}">
                        <td><input type="text" class="form-control" value="${posts.title}" maxlength="40" placeholder="글 제목을 입력해주세요." readonly></td>
                    </c:if>
                </tr>
                <tr>
                    <c:if test="${sessionScope.session_id != null}">
                    <td><input type="text" class="form-control" id="body" name="body" value="${posts.body}" maxlength="1024" style="height: 400px" placeholder="글 내용을 작성하세요."></td>
                    </c:if>
                    <c:if test="${sessionScope.session_id == null}">
                        <td><input type="text" class="form-control" value="${posts.body}" maxlength="1024" style="height: 400px" placeholder="글 내용을 작성하세요." readonly></td>
                    </c:if>
                </tr>
                </tbody>
                <tr align="right">
                    <td colspan="2">
                        <c:if test="${posts == null}">
                        <button type="submit" class="btn btn-outline-primary">등록</button>
                        </c:if>
                        <c:if test="${sessionScope.session_id == posts.user.id}">
                        <button type="submit" class="btn btn-outline-warning">수정</button>
                        </c:if>
                        <button type="button" class="btn btn-outline-secondary" onclick="location.href='/main.do'">이전</button>
                        <c:if test="${sessionScope.session_id == posts.user.id}">
                        <button type="button" class="btn btn-outline-danger" onclick="location.href='/post/deleteProc.do?id='+ ${posts.id}">삭제</button>
                        </c:if>
                </tr>
            </table>
        </form>
        <c:if test="${sessionScope.session_id != null}">
            <jsp:include page="tag.jsp"/>
        </c:if>
        <br><br>
        <c:if test="${posts != null}">
            <jsp:include page="comment.jsp"/>
        </c:if>
    </div>
</main>
<jsp:include page="../layout/footer.jsp"/>