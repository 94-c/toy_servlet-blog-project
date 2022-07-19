package com.blog.controller;


import com.blog.dto.UserDTO;
import com.blog.dto.UserLogDTO;
import com.blog.entity.User;
import com.blog.entity.UserLog;
import com.blog.service.UserLogService;
import com.blog.service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginProcController implements Controller {

    private static final String METHOD = "POST";

    @Override
    public String getMethod() {
        return LoginProcController.METHOD;
    }

    @Override
    public String process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        UserService userService = new UserService(request);

        String email = request.getParameter("email");

        boolean result = userService.login(email);

        if (result) {
            User user = new User();
            session.setAttribute("session_user_name", user.getName());
            session.setAttribute("session_email", user.getEmail());
            request.setAttribute("message", "로그인을 환영합니다.");
            request.setAttribute("target", "/main.do");
            return "/WEB-INF/common/redirect.jsp";
        }
        request.setAttribute("message", "아이디 및 비밀번호 다시 확인 부탁드립니다.");
        request.setAttribute("target", "/login.do");
        return "/WEB-INF/common/redirect.jsp";
    }
}
