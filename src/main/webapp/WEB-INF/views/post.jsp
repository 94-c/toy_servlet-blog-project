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
    <div class="container">
        <c:set var="action" value="${posts == null ? '/post/create.do' : '/post/edit.do'}"/>
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
                        <td><input type="text" class="form-control" id="title" name="title" value="${posts.title}"
                                   maxlength="40" placeholder="글 제목을 입력해주세요."></td>
                    </c:if>
                    <c:if test="${sessionScope.session_id == null}">
                        <td><input type="text" class="form-control" value="${posts.title}" maxlength="40"
                                   placeholder="글 제목을 입력해주세요." readonly></td>
                    </c:if>
                </tr>
                <tr>
                    <c:if test="${sessionScope.session_id != null}">
                        <td><input type="text" class="form-control" id="body" name="body" value="${posts.body}"
                                   maxlength="1024" style="height: 400px" placeholder="글 내용을 작성하세요."></td>
                    </c:if>
                    <c:if test="${sessionScope.session_id == null}">
                        <td><input type="text" class="form-control" value="${posts.body}" maxlength="1024"
                                   style="height: 400px" placeholder="글 내용을 작성하세요." readonly></td>
                    </c:if>
                    <td>
                </tr>
                </tbody>

                <c:if test="${sessionScope.session_id == null}">
                    <tr>
                        <td><input type="hidden" class="btn btn-outline-light">좋아요 [${totalLikeCount}]</td>
                    </tr>
                </c:if>
                <c:if test="${sessionScope.session_id != null}">
                    <tr>
                        <td><input type="button" class="btn btn-outline-light" id="likeButton"><img src="../img/heart.png">좋아요 [${totalLikeCount}]</td>
                    </tr>
                </c:if>

                <tr align="right">
                    <td colspan="2">
                        <c:if test="${posts == null}">
                        <button type="submit" class="btn btn-outline-primary">등록</button>
                        </c:if>
                        <c:if test="${sessionScope.session_id == posts.user.id}">
                        <button type="submit" class="btn btn-outline-warning">수정</button>
                        </c:if>
                        <button type="button" class="btn btn-outline-secondary" onclick="location.href='/main.do'">이전
                        </button>
                        <c:if test="${sessionScope.session_id == posts.user.id}">
                        <button type="button" class="btn btn-outline-danger"
                                onclick="location.href='/post/deleteProc.do?id='+ ${posts.id}">삭제
                        </button>
                        </c:if>
                </tr>


            </table>
            <div class="tr_hashTag_area">
                <p><strong>태그</strong></p>
                <div class="form-group">
                    <input type="hidden" value="" name="tag" id="rdTag"/>
                </div>

                <ul id="tag-list"></ul>

                <div class="form-group">
                    <input type="text" class="form-control" id="tag" size="7" placeholder="엔터로 해시태그를 등록해주세요."/>
                </div>
            </div>
        </form>
        <br><br>
        <c:if test="${posts != null}">
            <p><strong>댓글</strong></p>
            <jsp:include page="comment.jsp"/>
        </c:if>
    </div>
</main>
<script type="text/javascript">
    document.getElementById("likeButton").onclick = function () {
        const postId = ${posts.id};
        const userId = ${sessionScope.session_id};
        $.ajax({
            type: 'POST',
            url: '/like/create.do',
            data: {
                "postId": postId,
                "userId": userId
            },
            success: function (data) {
                alert("게시물 좋아요")
            }
        })
    }
    $(document).ready(function () {
        var tag = {};
        var counter = 0;

        // 입력한 값을 태그로 생성한다.
        function addTag (value) {
            tag[counter] = value;
            counter++; // del-btn 의 고유 id 가 된다.
        }

        // tag 안에 있는 값을 array type 으로 만들어서 넘긴다.
        function marginTag () {
            return Object.values(tag).filter(function (word) {
                return word !== "";
            });
        }

        // 서버에 제공
        $("#tag-form").on("submit", function (e) {
            var value = marginTag(); // return array
            $("#rdTag").val(value);

            $(this).submit();
        });

        $("#tag").on("keypress", function (e) {
            var self = $(this);
            //엔터나 스페이스바 눌렀을때 실행
            if (e.key === "Enter" || e.keyCode == 32) {
                var tagValue = self.val(); // 값 가져오기
                // 해시태그 값 없으면 실행X
                if (tagValue !== "") {
                    // 같은 태그가 있는지 검사한다. 있다면 해당값이 array 로 return 된다.
                    var result = Object.values(tag).filter(function (word) {
                        return word === tagValue;
                    })
                    // 해시태그가 중복되었는지 확인
                    if (result.length == 0) {
                        $("#tag-list").append("<li class='tag-item'>"+tagValue+"<span class='del-btn' idx='"+counter+"'>x</span></li>");
                        addTag(tagValue);
                        console.log(tagValue)
                    } else {
                        alert("태그값이 중복됩니다.");
                    }
                }
                e.preventDefault(); // SpaceBar 시 빈공간이 생기지 않도록 방지
            }

        });

        // 삭제 버튼
        // 인덱스 검사 후 삭제
        $(document).on("click", ".del-btn", function (e) {
            var index = $(this).attr("idx");
            tag[index] = "";
            $(this).parent().remove();
        });
    })
</script>
<jsp:include page="../layout/footer.jsp"/>