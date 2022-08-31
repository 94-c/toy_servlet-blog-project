package com.blog.controller.comment.parentComment;

import com.blog.controller.Controller;
import com.blog.entity.Comment;
import com.blog.service.CommentService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class EditParentCommentController implements Controller {

    private static final String METHOD = "GET";

    @Override
    public String getMethod() {
        return EditParentCommentController.METHOD;
    }


    @Override
    public String process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Integer parentId = Integer.valueOf(request.getParameter("parentId"));

        CommentService commentService = new CommentService();

        Comment parentComment = commentService.findByCommentId(parentId);

        if (parentComment == null) {
            request.setAttribute("message", "대댓글 정보를 못 찾았습니다.");
            request.setAttribute("target", "javascript:history.back()");
        }
        request.setAttribute("parentComment", parentComment);
        return "/WEB-INF/views/parentComment.jsp";
    }
}
