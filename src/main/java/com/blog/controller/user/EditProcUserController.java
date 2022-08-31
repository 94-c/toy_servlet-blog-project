package com.blog.controller.user;

import com.blog.controller.Controller;
import com.blog.dto.user.EditRequestUserDTO;
import com.blog.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EditProcUserController implements Controller {

    private static final String METHOD = "POST";

    @Override
    public String getMethod() {
        return EditProcUserController.METHOD;
    }

    private EditRequestUserDTO makeDTO(HttpServletRequest request) {
        return EditRequestUserDTO.builder()
                .id(Integer.valueOf(request.getParameter("id")))
                .email(request.getParameter("email"))
                .name(request.getParameter("name"))
                .password(request.getParameter("password"))
                .state(Integer.valueOf(request.getParameter("state")))
                .build();
    }


    @Override
    public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {

        EditRequestUserDTO dto = makeDTO(request);

        UserService userService = new UserService();

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
