package com.blog.controller.user;

import com.blog.controller.Controller;
import com.blog.dto.UserDTO;
import com.blog.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class EditProcUserController implements Controller {

    private static final String METHOD = "POST";

    @Override
    public String getMethod() {
        return EditProcUserController.METHOD;
    }

    private UserDTO makeDTO(HttpServletRequest request) {
        UserDTO dto = new UserDTO();

        dto.setId(Integer.valueOf(request.getParameter("id")));
        dto.setName(request.getParameter("name"));
        dto.setEmail(request.getParameter("email"));
        dto.setPassword(request.getParameter("password"));

        return dto;
    }

    @Override
    public String process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        UserDTO dto = makeDTO(request);
        UserService userService = new UserService(request);

        boolean result = userService.updateUser(dto);

        if (result) {
            request.setAttribute("message", "회원 정보 수정이 완료되었습니다.");
            request.setAttribute("target", "/main.do");
            return "/WEB-INF/common/redirect.jsp";
        }
        request.setAttribute("message", "회원 정보 수정이 실패하였습니다.");
        request.setAttribute("target", "/user/edit.do=id" + dto.getId());
        return "/WEB-INF/common/redirect.jsp";
    }
}
