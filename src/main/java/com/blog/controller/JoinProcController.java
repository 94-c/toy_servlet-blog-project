package com.blog.controller;


import com.blog.dto.UserDTO;
import com.blog.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JoinProcController implements Controller{

    private static final String METHOD = "POST";
    @Override
    public String getMethod() {
        return JoinProcController.METHOD;
    }

    public UserDTO makeDTO (HttpServletRequest request) {
        UserDTO dto = new UserDTO();
        dto.setEmail(request.getParameter("email"));
        dto.setPassword(request.getParameter("password"));
        dto.setName(request.getParameter("name"));

        return dto;
    }

    @Override
    public String process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        UserDTO dto = makeDTO(request);
        UserService userService = new UserService(request);

        boolean result = userService.join(dto);

        if (result) {
            request.setAttribute("message", "회원가입을 축하합니다.");
            request.setAttribute("target", "/login.do");
            return "/WEB-INF/common/redirect.jsp";
        }
        request.setAttribute("message", "회원가입이 실패하였습니다.");
        request.setAttribute("target", "/login.do");
        return "/WEB-INF/common/redirect.jsp";
    }
}
