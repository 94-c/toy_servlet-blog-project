package com.blog.controller.comment.parentComment;

import com.blog.controller.Controller;
import com.blog.dto.comment.parenteComment.CreateRequestParentCommentDTO;
import com.blog.entity.Comment;
import com.blog.requestDto.CreateRequestDto;
import com.blog.service.CommentService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CreateProcParentCommentController implements Controller {
    private static final String METHOD = "POST";

    private final CommentService commentService;

    public CreateProcParentCommentController() {
        this.commentService = new CommentService();
    }

    @Override
    public String getMethod() {
        return CreateProcParentCommentController.METHOD;
    }

    @Override
    public String process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CreateRequestParentCommentDTO dto = new CreateRequestDto().toParentCommentDto(request);
        Comment result = commentService.createParentComment(dto);
        if (result == null) {
            request.setAttribute("message", "대댓글 등록이 실패하었습니다.");
            request.setAttribute("target", "javascript:history.back()");
            return "/WEB-INF/common/redirect.jsp";
        }
        request.setAttribute("message", "대댓글이 등록 되었습니다.");
        request.setAttribute("target", "javascript:history.back()");
        return "/WEB-INF/common/redirect.jsp";
    }
}
