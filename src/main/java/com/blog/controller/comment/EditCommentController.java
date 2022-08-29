package com.blog.controller.comment;

import com.blog.controller.Controller;
import com.blog.entity.Comment;
import com.blog.service.CommentService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class EditCommentController implements Controller {

    private static final String METHOD = "GET";

    @Override
    public String getMethod() {
        return EditCommentController.METHOD;
    }


    @Override
    public String process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        Integer commentId = Integer.valueOf(request.getParameter("commentId"));

        CommentService commentService = new CommentService();

        Comment result = commentService.findByCommentId(commentId);

        if (result == null) {
            request.setAttribute("message", "해당 댓글을 확인 할 수 없습니다.");
            return "/WEB-INF/views/commentInput.jsp";
        }
        request.setAttribute("comment", result);

        return "/WEB-INF/views/commentInput.jsp";


    }
}
