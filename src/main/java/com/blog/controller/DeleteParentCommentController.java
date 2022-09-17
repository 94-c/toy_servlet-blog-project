package com.blog.controller;

import com.blog.data.dto.ParentCommentDto;
import com.blog.mapper.ParentCommentMapper;
import com.blog.service.CommentService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteParentCommentController implements Controller {
    private final CommentService commentService;

    public DeleteParentCommentController() {
        this.commentService = new CommentService();
    }

    @Override
    public String doGet(HttpServletRequest request, HttpServletResponse response) {
        ParentCommentDto dto = ParentCommentMapper.mapToDeleteParentCommentDto(request);

        try {
            commentService.deleteComment(dto);
            request.setAttribute("message", "대댓글 삭제가 성공하었습니다.");
            request.setAttribute("target", "/post/edit.do?id=" + dto.getPostId());
            return "/WEB-INF/common/redirect.jsp";
        } catch (Exception e) {
            request.setAttribute("message", "대댓글 삭제가 실패하었습니다.");
            request.setAttribute("target", "/post/edit.do?id=" + dto.getPostId());
            return "/WEB-INF/common/redirect.jsp";
        }
    }

    @Override
    public String doPost(HttpServletRequest request, HttpServletResponse response) {
        return null;
    }
}
