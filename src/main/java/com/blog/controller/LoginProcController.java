package com.blog.controller;


import com.blog.dto.UserDTO;
import com.blog.dto.UserLogDTO;
import com.blog.entity.User;
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
        UserDTO userDTO = new UserDTO();
        UserLogDTO userLogDTO = new UserLogDTO();
        UserService userService = new UserService(request);
        UserLogService userLogService = new UserLogService(request);

        userDTO.setEmail(request.getParameter("email"));
        userDTO.setPassword(request.getParameter("password"));

        try {
            User user = new User();
            userLogDTO.setUserAgent("로그인");
            userLogDTO.setUserId(user.getId());
            session.setAttribute("session_id", user.getId());
            session.setAttribute("session_email", user.getEmail());
            session.setAttribute("session_name", user.getName());

            userLogService.createUserLog(userLogDTO);

            System.out.println("로그인 성공");
            request.setAttribute("message", user.getName() + " 님 환영합니다.");
            request.setAttribute("target", "/main.do");

            return "/WEB-INF/common/redirect.jsp";

        }catch (Exception e) {
            e.printStackTrace();
            System.out.println("로그인 실패");
            request.setAttribute("message", "로그인 실패");
            request.setAttribute("target", "/login.do");

            return "/WEB-INF/common/redirect.jsp";
        }
    }
}
