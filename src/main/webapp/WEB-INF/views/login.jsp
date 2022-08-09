<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="../layout/header.jsp"/>


    <div class="container">
        <!-- <h5 class="modal-title">Modal title</h5> -->
        <h2 class="fw-bold mb-0">Sign up for free</h2>

    <div class="modal-body p-5 pt-0">
        <form id="login_form" method="post" action="/loginProc.do">
            <div class="form-floating mb-3">
                <input type="email" class="form-control rounded-3" id="email" placeholder="name@example.com">
                <label for="email">Email address</label>
            </div>
            <div class="form-floating mb-3">
                <input type="password" class="form-control rounded-3" id="password" placeholder="Password">
                <label for="password">Password</label>
            </div>
            <button class="w-100 mb-2 btn btn-lg rounded-3 btn-primary" type="submit">Sign up</button>
            <small class="text-muted">By clicking Sign up, you agree to the terms of use.</small>
        </form>
    </div>
    </div>
