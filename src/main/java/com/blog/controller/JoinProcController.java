package com.blog.controller;


import com.blog.dto.user.CreateRequestUserDTO;
import com.blog.entity.User;
import com.blog.requestDto.CreateRequestDto;
import com.blog.util.EmailUtil;
import com.blog.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JoinProcController implements Controller {
    private static final String METHOD = "POST";

    private final UserService userService;
    private final EmailUtil emailUtil;

    public JoinProcController() {
        this.userService = new UserService();
        this.emailUtil = new EmailUtil();
    }

    @Override
    public String getMethod() {
        return JoinProcController.METHOD;
    }


    @Override
    public String process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CreateRequestUserDTO dto = new CreateRequestDto().toUserDto(request);

        boolean emailCheck = userService.userEmailCheck(dto.getEmail());

        if (emailCheck) {
            request.setAttribute("message", "중복되는 이메일이 있습니다.");
            request.setAttribute("target", "/join.do");
            return "/WEB-INF/common/redirect.jsp";
        }
        User result = userService.join(dto);
        if (result == null) {
            request.setAttribute("message", "회원가입이 실패하였습니다.");
            request.setAttribute("target", "/main.do");
            return "/WEB-INF/common/redirect.jsp";
        } else {
            //인증 메일 보내기
            emailUtil.sendEmail(result.getId(), dto.getEmail());

            request.setAttribute("message", "회원가입 확인 메일이 전송 되었습니다.");
            request.setAttribute("message", "회원가입을 축하합니다.");
            request.setAttribute("target", "/main.do");
        }
        return "/WEB-INF/common/redirect.jsp";
    }
}
