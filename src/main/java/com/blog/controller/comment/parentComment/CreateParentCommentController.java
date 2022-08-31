package com.blog.controller.comment.parentComment;

import com.blog.controller.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CreateParentCommentController implements Controller {

    private static final String METHOD = "GET";

    @Override
    public String getMethod() {
        return CreateParentCommentController.METHOD;
    }


    @Override
    public String process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        return "/WEB-INF/views/parentComment.jsp";
    }
}
