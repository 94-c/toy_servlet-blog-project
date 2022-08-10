package com.blog.controller.user;

import com.blog.controller.Controller;
import com.blog.entity.User;
import com.blog.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class EditUserController implements Controller {

    private static final String METHOD = "GET";

    @Override
    public String getMethod() {
        return EditUserController.METHOD;
    }



    @Override
    public String process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

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
}
