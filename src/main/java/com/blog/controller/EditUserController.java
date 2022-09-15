package com.blog.controller;

import com.blog.data.entity.User;
import com.blog.dto.user.EditRequestUserDTO;
import com.blog.requestDto.EditRequestDto;
import com.blog.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EditUserController implements Controller {
    private final UserService userService;

    public EditUserController() {
        this.userService = new UserService();
    }

    @Override
    public String doGet(HttpServletRequest request, HttpServletResponse response) {
        Integer id = Integer.valueOf(request.getParameter("id"));

        UserService userService = new UserService();

        User result = userService.findUserId(id);

        if (result != null) {
            request.setAttribute("user", result);
            return "/WEB-INF/views/user/userInputForm.jsp";
        }
        request.setAttribute("message", "회원 정보를  찾을 수 없습니다.");
        request.setAttribute("target", "/main.do");
        return "/WEB-INF/common/redirect.jsp";
    }

    @Override
    public String doPost(HttpServletRequest request, HttpServletResponse response) {
        EditRequestUserDTO dto = new EditRequestDto().toUserDto(request);

        if (dto.getPassword().isEmpty()) {
            request.setAttribute("message", "회원 정보 수정이 실패하였습니다.");
            request.setAttribute("target", "/user/edit.do?id=" + dto.getId());
            return "/WEB-INF/common/redirect.jsp";
        }
        userService.updateUser(dto);
        request.setAttribute("message", "회원 정보 수정이 완료되었습니다.");
        request.setAttribute("target", "/main.do");
        return "/WEB-INF/common/redirect.jsp";
    }
}
