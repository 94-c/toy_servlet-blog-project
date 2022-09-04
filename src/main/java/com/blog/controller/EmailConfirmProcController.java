package com.blog.controller;

import com.blog.dto.EmailTokensDTO;
import com.blog.dto.email.EmailConfirmRequestDTO;
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

    private EmailConfirmRequestDTO makeDTO(HttpServletRequest request) {
        return EmailConfirmRequestDTO.builder()
                .token(request.getParameter("token"))
                .userId(Integer.valueOf(request.getParameter("userId")))
                .build();
    }


    @Override
    public String process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EmailConfirmRequestDTO dto = makeDTO(request);
        EmailTokensService emailTokensService = new EmailTokensService();
        UserService userService = new UserService();
        
        
        boolean result = emailTokensService.updateState(dto);

        if (result) {
            userService.updateEmailStateAuth(dto.getUserId());
            request.setAttribute("message", "인증이 완료되었습니다.");
            request.setAttribute("target", "/main.do");
            return "/WEB-INF/common/redirect.jsp";
        }
        request.setAttribute("message", "인증이 실패하었습니다.");
        request.setAttribute("target", "/main.do");
        return "/WEB-INF/common/redirect.jsp";
    }
}
