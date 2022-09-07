package com.blog.controller.comment.parentComment;

import com.blog.controller.Controller;
import com.blog.dto.comment.parenteComment.EditRequestParentCommentDTO;
import com.blog.entity.Comment;
import com.blog.requestDto.EditRequestDto;
import com.blog.service.CommentService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class EditProcParentCommentController implements Controller {
    private static final String METHOD = "POST";

    private final CommentService commentService;

    public EditProcParentCommentController() {
        this.commentService = new CommentService();
    }

    @Override
    public String getMethod() {
        return EditProcParentCommentController.METHOD;
    }



    @Override
    public String process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EditRequestParentCommentDTO dto = new EditRequestDto().toParentDto(request);
        Comment result = commentService.updateParentComment(dto);

        if (result == null) {
            request.setAttribute("message", "대댓글 수정이 실패하었습니다.");
            return "/WEB-INF/common/redirect.jsp";
        }
        request.setAttribute("message", "대댓글이 수정 되었습니다.");
        return "/WEB-INF/common/redirect.jsp";
    }
}
