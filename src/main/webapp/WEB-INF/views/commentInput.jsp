<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://getbootstrap.com/docs/5.2/assets/css/docs.css" rel="stylesheet">
    <title>Bootstrap Example</title>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"></script>
</head>

<body class="p-3 m-0 border-0 bd-example">
<div class="card" style="width: 540px; height: 300px">
    <div class="card-body">
        <h5 class="card-title">댓글 상세보기</h5>
        <div id="commentUpdateForm">
            <form name="comment_update_form" target="parentForm" action="/comment/editProc.do" method="POST">
                <input type="hidden" name="commentId" value="${comment.id}">
                <input type="hidden" name="postId" value="${comment.post.id}">
                <input type="hidden" name="userId" value="${sessionScope.session_id}">

                <input type="text" class="form-control" name="body" value="${comment.body}" style="margin-bottom: 10px; margin-top: 10px; height: 80px">

                <tr align="right">
                    <td colspan="2" >
                        <button type="submit" class="btn btn-outline-warning m-md-2">수정</button>
                        <button type="button" class="btn btn-outline-danger" onclick="window.close()">닫기</button>
                    </td>
                </tr>
            </form>
        </div>
    </div>
</div>
</body>
</html>



