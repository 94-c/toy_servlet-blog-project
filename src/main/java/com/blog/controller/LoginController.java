package com.blog.controller;

import com.blog.data.dto.UserDto;
import com.blog.data.entity.User;
import com.blog.mapper.EmailConfirmMapper;
import com.blog.mapper.UserMapper;
import com.blog.service.UserService;
import com.blog.util.SessionUtil;

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
        UserDto dto = UserMapper.mapToLogin(request);

        User user = userService.login(dto);

        if (user == null) {
            request.setAttribute("message", "아이디 및 비밀번호 다시 확인 부탁드립니다.");
            request.setAttribute("target", "/main.do");
            return "/WEB-INF/common/redirect.jsp";
        }
        SessionUtil.getInstance().setSession(request.getSession());


        SessionUtil.getInstance()
                .set("session_id", user.getId());

        request.setAttribute("message", "로그인을 환영합니다.");
        request.setAttribute("target", "/main.do");
        return "/WEB-INF/common/redirect.jsp";
    }
}
