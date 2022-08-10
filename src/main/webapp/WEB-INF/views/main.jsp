<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
    <div class="container">
        <div class="row">
            <table class="table table-hover">
                <thead>
                <tr>
                    <th>Index</th>
                    <th>Title</th>
                    <th>Writer</th>
                    <th>Date Created</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="post" items="${postList}" varStatus="status">
                    <tr>
                        <td>${post.id}</td>
                        <td><a href="/post/edit.do?id=${post.id}">${post.title}</a></td>
                        <td>${post.user.name}</td>
                        <td><fmt:formatDate pattern='MM/dd/yyyy' value='${post.createdAt}'/></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <tr align="right">
                <td colspan="2">
                <c:if test="${sessionScope.session_id != null}">
                    <button class="btn btn-outline-info" type="button" id="createBtn"
                            onclick="location.href='/post/create.do'">작성
                    </button>
                </c:if>
                </td>
            </tr>
        </div>
    </div>
</main>
<jsp:include page="../layout/footer.jsp"/>

