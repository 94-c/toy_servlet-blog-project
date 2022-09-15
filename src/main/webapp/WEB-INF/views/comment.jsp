<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="card-body">
    <c:if test="${sessionScope.session_id != null}">
        <form class="form-horizontal" action="/comment/create.do" name="create_comment" method="POST">
   1         <input type="hidden" id="postId" name="postId" value="${param.id}">
            <input type="hidden" id="userId" name="userId" value="${sessionScope.session_id}">
            <div class="row">
                <div class="form-group col-sm-9">
                    <input class="form-control input-sm" id="body" name="body" type="text" placeholder="댓글 입력...">
                </div>
                <div class="form-group col-sm-2">
                    <input class="form-control input-sm" type="text" readonly
                           value="${sessionScope.session_name}" style="background-color: #b9bbbe">
                </div>
                <c:if test="${sessionScope.session_id != null}">
                    <div class="form-group col-sm-1">
                        <button type="submit" class="btn btn-outline-primary btn-block ">
                            <i class="fa fa-save"></i> 저장
                        </button>
                    </div>
                </c:if>
            </div>
        </form>
    </c:if>
</div>

<div class="card card-primary card-outline">
    <div class="card-header">
        <a href="" class="link-black text-lg"><i class="fas fa-comments margin-r-5 replyCount"></i></a>
        <div class="card-tools">
            <button type="button" class="btn primary" data-widget="collapse">
                <i class="fa fa-plus"></i>
            </button>
        </div>
    </div>
    <div class="card-body repliesDiv">
        <c:if test="${commentList != null}">
        <table class="table table-hover" style="width: 100%">
            <colgroup>
                <col width="150px">
                <col width="50px">
                <col width="50px">
            </colgroup>
            <tr>
                <th>내용</th>
                <th>작성자</th>
                <th style="text-align: center">버튼</th>
            </tr>
            <c:forEach var="comment" items="${commentList}">
                <tr>
                    <td>${comment.body}</td>
                    <td>${comment.user.name}</td>
                    <td>
                        <div name="button" style="align-content: end; text-align: center">
                            <c:if test="${comment.user.id == sessionScope.session_id}">
                                <input type="hidden" name="postId" value="${param.id}">
                                <button type="button" class="btn btn-outline-info btn-sm"
                                        onclick="replyComment(${comment.id}, ${param.id})">답변
                                </button>
                                <button type="button" class="btn btn-outline-warning btn-sm"
                                        onclick="updateComment(${comment.id})">수정
                                </button>
                                <button type="button" class="btn btn-outline-danger btn-sm"
                                        onclick="location.href='/comment/deleteProc.do?commentId='+${comment.id}+'&postId='+${param.id}">
                                    삭제
                                </button>
                            </c:if>
                        </div>
                    </td>
                </tr>
            </c:forEach>
            <c:forEach var="parentComment" items="${parentComment}">
                    <tr style="">
                        <td>${parentComment.body}</td>
                        <td>${parentComment.user.name}</td>
                        <td>
                            <div name="button" style="align-content: end; text-align: center">
                                <c:if test="${parentComment.user.id == sessionScope.session_id}">
                                    <input type="hidden" name="parentCommentId" value="${param.id}">
                                    <button type="button" class="btn btn-outline-warning btn-sm" onclick="replyEditComment(${parentComment.id})">수정
                                    </button>
                                    <button type="button" class="btn btn-outline-danger btn-sm" onclick="location.href='/parenComment/deleteProc.do?parentId='+${parentComment.id}+'&postId='+${param.id}">
                                        삭제
                                    </button>
                                </c:if>
                            </div>
                        </td>
                    </tr>
                </c:forEach>
            </c:if>
        </table>
    </div>
</div>

<script type="text/javascript">
    function updateComment(commentId) {
        window.name = "parentForm";
        window.open("/comment/edit.do?commentId=" + commentId, "updateForm", "width=570, height=350, resizable=no, scrollbars=no");
    }

    function replyComment(commentId, postId) {
        window.name = "parentForm";
        window.open("/parenComment/create.do?commentId=" + commentId + "&postId=" + postId, "replyForm", "width=570, height=350, resizable=no, scrollbars=no");
    }

    function replyEditComment(parentId) {
        window.name = "parentForm";
        window.open("/parenComment/edit.do?parentId=" + parentId, "replyForm", "width=570, height=350, resizable=no, scrollbars=no");
    }
</script>