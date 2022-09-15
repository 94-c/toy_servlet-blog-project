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

    .form-join {
        width: 600px;
        max-width: 600px;
        padding: 15px;
        margin: auto;
    }

    .form-join .form-floating:focus-within {
        z-index: 2;
    }

    .form-join input[type="email"] {
        margin-bottom: 10px;
        border-bottom-right-radius: 0;
        border-bottom-left-radius: 0;
    }

    .form-join input[type="password"] {
        margin-bottom: 10px;
        border-top-left-radius: 0;
        border-top-right-radius: 0;
    }

    .form-join input[type="name"] {
        margin-bottom: 10px;
        border-top-left-radius: 0;
        border-top-right-radius: 0;
    }

    .form-join button[id="joinBtn"] {
        margin-top: 10px;
        margin-bottom: 10px;
    }
</style>

<main class="form-join">
    <div class="container">
        <h3 class="text-center">회원가입</h3>
        <form id="join_form" method="post" action="/join.do">
            <div class="form-floating">
                <input type="email" class="form-control rounded-3" id="email" name="email" placeholder="name@example.com">
                <label for="email">Email address</label>

            </div>
            <div class="form-floating">
                <input type="password" class="form-control rounded-3" id="password" name="password" placeholder="Password">
                <label for="password">Password</label>
            </div>
            <div class="form-floating">
                <input type="text" class="form-control rounded-3" id="name" name="name" placeholder="Name">
                <label for="name">Name</label>
            </div>
            <button class="w-100 btn btn-lg btn-primary" id="joinBtn" type="submit">Join up</button>
            <button class="w-100 btn btn-lg btn-danger" id="backBtn" type="button" onclick="location.href='/main.do'">Back up</button>
        </form>
    </div>
</main>
<jsp:include page="../layout/footer.jsp"/>

