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

        dto.setId(Integer.valueOf(request.getParameter("id")));
        dto.setUserId(Integer.valueOf(request.getParameter("userId")));
        dto.setToken(request.getParameter("token"));

        return dto;
    }


    @Override
    public String process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EmailTokensDTO dto = makeDTO(request);
        EmailTokensService emailTokensService = new EmailTokensService(request);
        UserService userService = new UserService(request);
        
        
        //TODO 이메일 토큰 보낼 때, 토큰 파라미터를 토대로 검색하여 가져오기
        boolean result = emailTokensService.updateState(dto);

        //TODO 토큰 값으로 하여 인증번호 찾기
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
