package com.blog.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginController implements Controller {


    private static final String METHOD = "GET";

    @Override
    public String getMethod() {
        return LoginController.METHOD;
    }

    @Override
    public String process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if (request.getSession().getAttribute("session_id") != null) {
            request.setAttribute("target", "/main.do");
            request.setAttribute("message", "입장을 환영합니다.");
        }
        return "/WEB-INF/views/login.jsp";
    }
}
