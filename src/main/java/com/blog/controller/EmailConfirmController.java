package com.blog.controller;

import com.blog.data.dto.EmailConfirmDto;
import com.blog.mapper.CreateRequestDto;
import com.blog.service.EmailTokensService;
import com.blog.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EmailConfirmController implements Controller{

    private final EmailTokensService emailTokensService;
    private final UserService userService;

    public EmailConfirmController() {
        this.emailTokensService = new EmailTokensService();
        this.userService = new UserService();
    }

    @Override
    public String doGet(HttpServletRequest request, HttpServletResponse response) {
        return "/WEB-INF/common/emailConfirm.jsp";
    }

    @Override
    public String doPost(HttpServletRequest request, HttpServletResponse response) {
        EmailConfirmDto dto = new CreateRequestDto().toEmailConfirmDto(request);

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
