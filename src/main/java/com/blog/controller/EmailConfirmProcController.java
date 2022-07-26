package com.blog.controller;

import com.blog.dto.EmailTokensDTO;
import com.blog.entity.EmailTokens;
import com.blog.service.EmailTokensService;
import com.blog.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class EmailConfirmProcController implements Controller {

    private static final String METHOD = "POST";

    @Override
    public String getMethod() {
        return EmailConfirmProcController.METHOD;
    }

    private EmailTokensDTO makeDTO(HttpServletRequest request) {
        EmailTokensDTO dto = new EmailTokensDTO();
        dto.setUserId(Integer.valueOf(request.getParameter("userId")));
        dto.setToken(request.getParameter("token"));
        return dto;
    }

    @Override
    public String process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EmailTokensDTO dto = makeDTO(request);
        EmailTokensService emailTokensService = new EmailTokensService(request);
        UserService userService = new UserService(request);

        boolean result = emailTokensService.updateState(dto);

        if (result) {
            userService.updateState(dto.getUserId());
            request.setAttribute("message", "인증이 완료되었습니다.");
            request.setAttribute("target", "/main.do");
            return "/WEB-INF/common/redirect.jsp";
        }
        request.setAttribute("message", "인증이 실패하었습니다.");
        request.setAttribute("target", "/main.do");
        return "/WEB-INF/common/redirect.jsp";
    }
}
