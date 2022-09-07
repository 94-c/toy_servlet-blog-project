package com.blog.controller;


import com.blog.dto.LoginRequestDTO;
import com.blog.entity.User;
import com.blog.service.UserService;
import com.blog.util.Md5Util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginProcController implements Controller {

    private static final String METHOD = "POST";

    @Override
    public String getMethod() {
        return LoginProcController.METHOD;
    }

    private LoginRequestDTO makeDTO(HttpServletRequest request) {
        return LoginRequestDTO.builder()
                .email(request.getParameter("email"))
                .password(Md5Util.md5(request.getParameter("password")))
                .build();
    }

    @Override
    public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {

        HttpSession session = request.getSession();
        LoginRequestDTO dto = makeDTO(request);
        UserService userService = new UserService();

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
