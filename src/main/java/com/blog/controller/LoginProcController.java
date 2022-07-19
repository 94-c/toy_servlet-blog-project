package com.blog.controller;


import com.blog.dto.LoginDTO;
import com.blog.entity.User;
import com.blog.service.UserService;

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

    private LoginDTO makeDTO(HttpServletRequest request) {
        LoginDTO dto = new LoginDTO();
        dto.setEmail(request.getParameter("email"));
        dto.setPassword(request.getParameter("password"));
        return dto;
    }

    @Override
    public String process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        LoginDTO dto = makeDTO(request);
        UserService userService = new UserService(request);

        boolean user = userService.login(dto);

        if (user) {
            session.setAttribute("session_email", dto.getEmail());
            request.setAttribute("message", "로그인을 환영합니다.");
            request.setAttribute("target", "/main.do");
            return "/WEB-INF/common/redirect.jsp";
        }
        request.setAttribute("message", "아이디 및 비밀번호 다시 확인 부탁드립니다.");
        request.setAttribute("target", "/login.do");
        return "/WEB-INF/common/redirect.jsp";


    }
}
