package com.blog.controller;

import com.blog.data.dto.CommentDto;
import com.blog.data.entity.Comment;
import com.blog.mapper.CommentMapper;
import com.blog.service.CommentService;
import com.blog.util.RequestMapping;

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
        CommentDto dto = CommentMapper.mapToCreateCommentDto(request);

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
