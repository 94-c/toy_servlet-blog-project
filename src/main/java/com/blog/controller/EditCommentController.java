package com.blog.controller;

import com.blog.controller.Controller;
import com.blog.data.entity.Comment;
import com.blog.dto.comment.EditRequestCommentDTO;
import com.blog.requestDto.EditRequestDto;
import com.blog.service.CommentService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EditCommentController implements Controller {

    private final CommentService commentService;

    public EditCommentController() {
        this.commentService = new CommentService();
    }

    @Override
    public String doGet(HttpServletRequest request, HttpServletResponse response) {
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

    @Override
    public String doPost(HttpServletRequest request, HttpServletResponse response) {
        EditRequestCommentDTO dto = new EditRequestDto().toCommentDto(request);
        Comment result = commentService.updateComment(dto);

        if (result == null) {
            request.setAttribute("message", "댓글 변경이 실패하였습니다.");
            request.setAttribute("target", "/post/edit.do?id=" + dto.getPostId());
            return "/WEB-INF/common/redirect.jsp";
        }
        request.setAttribute("message", "댓글 변경이 완료되었습니다.");
        request.setAttribute("target", "/post/edit.do?id=" + dto.getPostId());
        return "/WEB-INF/common/redirect.jsp";
    }
}
