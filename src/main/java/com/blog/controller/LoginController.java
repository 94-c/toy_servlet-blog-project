package com.blog.controller;

import com.blog.data.entity.User;
import com.blog.mapper.CreateRequestDto;
import com.blog.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginController implements Controller {
    private final UserService userService;
    public LoginController() {
        this.userService = new UserService();
    }
    @Override
    public String doGet(HttpServletRequest request, HttpServletResponse response) {
        return "/WEB-INF/views/login.jsp";
    }

    @Override
    public String doPost(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        LoginRequestDTO dto = new CreateRequestDto().toLoginDto(request);

        User user = userService.login(dto);

        if (user == null) {
            request.setAttribute("message", "아이디 및 비밀번호 다시 확인 부탁드립니다.");
            request.setAttribute("target", "/main.do");
            return "/WEB-INF/common/redirect.jsp";
        }
        session.setAttribute("session_id", user.getId());
        session.setAttribute("session_name", user.getName());
        session.setAttribute("session_email", user.getEmail());
        request.setAttribute("message", "로그인을 환영합니다.");
        request.setAttribute("target", "/main.do");
        return "/WEB-INF/common/redirect.jsp";
    }
}
