<jsp:include page="main.jsp"/>
<div align="center">
    <table border="1" cellpadding="5">
        <tr>
            <th>Index</th>
            <th>Title</th>
            <th>Writer</th>
            <th>Date Created</th>
        </tr>
        <c:forEach var="post" items="${postList}" varStatus="status">
            <tr>
                <td>${post.id}</td>
                <td>${post.title}</td>
                <td>${post.user.name}</td>
                <td><fmt:formatDate pattern='MM/dd/yyyy' value='${post.createdAt}'/></td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
