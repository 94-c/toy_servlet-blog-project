<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="top.jsp"/>
<header>
    <!-- Fixed navbar -->
    <nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
        <div class="container-fluid">
            <a class="navbar-brand" href="#">Fixed navbar</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarCollapse"
                    aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarCollapse">
                <ul class="navbar-nav me-auto mb-2 mb-md-0">
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="#">Home</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Link</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link disabled">Disabled</a>
                    </li>
                </ul>
                <button id="loginBtn" class="btn btn-outline-success m-1" type="button" onclick="location.href='/login.do'">Login</button>
                <button class="btn btn-outline-danger m-3" type="button">Join</button>
            </div>
        </div>
    </nav>
</header>

<%--
<header class="p-3 text-bg-dark">
    <div class="container">
        <div class="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start">
            <a href="/main.do" class="d-flex align-items-center mb-2 mb-lg-0 text-white text-decoration-none">
                <svg class="bi me-2" width="40" height="32" role="img" aria-label="Bootstrap"><use xlink:href="#bootstrap"></use></svg>
            </a>

            &lt;%&ndash;<ul class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0">
                <li><a href="#" class="nav-link px-2 text-secondary">Home</a></li>
                <li><a href="#" class="nav-link px-2 text-white">Features</a></li>
                <li><a href="#" class="nav-link px-2 text-white">Pricing</a></li>
                <li><a href="#" class="nav-link px-2 text-white">FAQs</a></li>
                <li><a href="#" class="nav-link px-2 text-white">About</a></li>
            </ul>&ndash;%&gt;

            <c:if test="${sessionScope.session_id == null}">
                <form class="col-12 col-lg-auto mb-3 mb-lg-0 me-lg-3" id="login_form" method="post" action="/loginProc.do">
                    <label>
                        <input type="text" class="form-control form-control-dark text-bg-dark" placeholder="E-mail" name="email">
                    </label>
                    <label>
                        <input type="password" class="form-control form-control-dark text-bg-dark" placeholder="password" name="password">
                    </label>
                        <button type="submit" class="btn btn-outline-light">Login</button>
                        <button type="button" class="btn btn-warning" onclick="location.href='/join.do'">Sign-up</button>
                </form>
            </c:if>

            <c:if test="${sessionScope.session_id != null}">
                <input type="hidden" id="id" value="${sessionScope.session_id}">
                ${sessionScope.session_name} 님 환영 합니다.
                <button type="button" class="btn btn-warning" onclick="location.href='/user/edit.do?id=${sessionScope.session_id}'">회원정보</button>
                <button type="button" class="btn btn-outline-light" onclick="location.href='/logOut.do'">로그아웃</button>
            </c:if>
        </div>
    </div>
</header>
--%>


