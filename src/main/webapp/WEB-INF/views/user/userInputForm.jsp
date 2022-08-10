<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>회원정보</title>
</head>
<jsp:include page="../../layout/header.jsp"/>
<style>
    .form-userEdit {
        width: 600px;
        max-width: 600px;
        padding: 15px;
        margin: auto;
    }

    .form-userEdit .form-floating:focus-within {
        z-index: 2;
    }

    .form-userEdit input[id="email"] {
        margin-bottom: 10px;
        border-top-left-radius: 0;
        border-top-right-radius: 0;
    }

    .form-userEdit input[id="password"] {
        margin-bottom: 10px;
        border-top-left-radius: 0;
        border-top-right-radius: 0;
    }

    .form-userEdit input[id="name"] {
        margin-bottom: 10px;
        border-top-left-radius: 0;
        border-top-right-radius: 0;
    }

</style>
<main class="form-userEdit">
    <div class="container">
        <h3 class="text-center">회원정보</h3>
        <c:set var="action" value="${'/user/editProc.do'}"/>
        <form id="user_edit_form" method="post" action="${action}">
            <input type="hidden" name="id" value="${param.id}">
            <input type="hidden" name="state" value="${user.state}">
            <div class="form-floating">
                <input type="email" class="form-control rounded" id="email" name="email" value="${user.email}" readonly>
                <label for="email">Email Address</label>
            </div>
            <div class="form-floating">
                <input type="password" class="form-control rounded" id="password" name="password">
                <label for="password">Password</label>
            </div>
            <div class="form-floating">
                <input type="text" class="form-control rounded" id="name" name="name"
                       value="${user.name}">
                <label for="name">Name</label>
            </div>
            <button class="w-100 btn btn-lg btn-primary" type="submit">수정 하기</button>

        </form>
    </div>
</main>

<jsp:include page="../../layout/footer.jsp"/>