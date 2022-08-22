package com.blog.controller.comment;

import com.blog.controller.Controller;
import com.blog.dto.CommentDTO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CreateProcParentCommentController implements Controller {

    private static final String METHOD = "POST";

    @Override
    public String getMethod() {
        return CreateProcParentCommentController.METHOD;
    }

    private CommentDTO makeDTO(HttpServletRequest request) {
        CommentDTO dto = new CommentDTO();

        dto.setId(Integer.valueOf(request.getParameter("commentId")));

        return dto;
    }

    @Override
    public String process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        return "/WEB-INF/views/parentComment.jsp";
    }
}
