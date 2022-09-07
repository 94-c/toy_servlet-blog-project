package com.blog.controller.user;

import com.blog.controller.Controller;
import com.blog.dto.user.EditRequestUserDTO;
import com.blog.requestDto.EditRequestDto;
import com.blog.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EditProcUserController implements Controller {
    private static final String METHOD = "POST";
    private final UserService userService;

    public EditProcUserController() {
        this.userService = new UserService();
    }

    @Override
    public String getMethod() {
        return EditProcUserController.METHOD;
    }



    @Override
    public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
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
