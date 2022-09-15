package com.blog.controller;

import com.blog.data.entity.User;
import com.blog.dto.user.CreateRequestUserDTO;
import com.blog.mapper.CreateRequestDto;
import com.blog.service.UserService;
import com.blog.util.EmailUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CreateUserController implements Controller {
    private final UserService userService;
    private final EmailUtil emailUtil;

    public CreateUserController() {
        this.userService = new UserService();
        this.emailUtil = new EmailUtil();
    }
    @Override
    public String doGet(HttpServletRequest request, HttpServletResponse response) {
        return "/WEB-INF/views/join.jsp";
    }

    @Override
    public String doPost(HttpServletRequest request, HttpServletResponse response) {
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
