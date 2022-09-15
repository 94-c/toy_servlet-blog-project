package com.blog.controller;

import com.blog.data.entity.Comment;
import com.blog.mapper.CreateRequestDto;
import com.blog.service.CommentService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CreateCommentController implements Controller {
    private final CommentService commentService;

    public CreateCommentController() {
        this.commentService = new CommentService();
    }

    @Override
    public String doGet(HttpServletRequest request, HttpServletResponse response) {
        return null;
    }

    @Override
    public String doPost(HttpServletRequest request, HttpServletResponse response) {
        CreateRequestCommentDTO dto = new CreateRequestDto().toCommentDto(request);
        Comment result = commentService.createComment(dto);

        if (result == null) {
            request.setAttribute("message", "댓글 등록이 실패하었습니다.");
            request.setAttribute("target", "/post/edit.do?id=" + dto.getPostId());
            return "/WEB-INF/common/redirect.jsp";
        }
        request.setAttribute("message", "댓글이 등록 되었습니다.");
        request.setAttribute("target", "/post/edit.do?id=" + dto.getPostId());
        return "/WEB-INF/common/redirect.jsp";
    }
}
