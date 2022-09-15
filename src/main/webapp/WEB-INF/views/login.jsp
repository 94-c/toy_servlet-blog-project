<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="../layout/header.jsp"/>
<style>
    .form-sign {
        width: 600px;
        max-width: 600px;
        padding: 15px;
        margin: auto;
    }
    .form-sign .form-floating:focus-within {
        z-index: 2;
    }

    .form-sign input[type="email"] {
        margin-bottom: 10px;
        border-bottom-right-radius: 0;
        border-bottom-left-radius: 0;
    }

    .form-sign input[type="password"] {
        margin-bottom: 10px;
        border-top-left-radius: 0;
        border-top-right-radius: 0;
    }

</style>

<main class="form-sign">
    <div class="container">
        <h3 class="text-center">로그인</h3>
        <form id="login_form" method="post" action="/login.do">
            <div class="form-floating">
                <input type="email" class="form-control rounded-3" id="email" name="email" placeholder="name@example.com">
                <label for="email">Email address</label>

            </div>
            <div class="form-floating">
                <input type="password" class="form-control rounded-3" id="password" name="password" placeholder="Password">
                <label for="password">Password</label>
            </div>
            <button class="w-100 btn btn-lg btn-primary" type="submit">Sign up</button>

        </form>
    </div>
</main>
<jsp:include page="../layout/footer.jsp"/>