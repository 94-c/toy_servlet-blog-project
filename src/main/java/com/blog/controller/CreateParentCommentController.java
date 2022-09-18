package com.blog.controller;

import com.blog.data.dto.ParentCommentDto;
import com.blog.data.entity.Comment;
import com.blog.mapper.ParentCommentMapper;
import com.blog.service.CommentService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CreateParentCommentController implements Controller {

    private final CommentService commentService;

    public CreateParentCommentController() {
        this.commentService = new CommentService();
    }

    @Override
    public String doGet(HttpServletRequest request, HttpServletResponse response) {
        return "/WEB-INF/views/parentComment.jsp";
    }

    @Override
    public String doPost(HttpServletRequest request, HttpServletResponse response) {

        ParentCommentDto dto = ParentCommentMapper.mapToCreateCommentDto(request);

        Comment result = commentService.createParentComment(dto);

        if (result == null) {
            request.setAttribute("message", "대댓글 등록이 실패하었습니다.");
            return "/WEB-INF/common/redirect.jsp";
        }
        request.setAttribute("message", "대댓글이 등록 되었습니다.");
        return "/WEB-INF/common/redirect.jsp";
    }
}
