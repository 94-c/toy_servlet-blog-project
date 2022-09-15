package com.blog.controller;

import com.blog.dto.comment.DeleteResponseCommentDTO;
import com.blog.service.CommentService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteParentCommentController implements Controller {
    private final CommentService commentService;

    public DeleteParentCommentController() {
        this.commentService = new CommentService();
    }

    private DeleteResponseCommentDTO makeDTO(HttpServletRequest request) {
        return DeleteResponseCommentDTO.builder()
                .id(Integer.valueOf(request.getParameter("parentId")))
                .postId(Integer.valueOf(request.getParameter("postId")))
                .build();
    }

    @Override
    public String doGet(HttpServletRequest request, HttpServletResponse response) {
        DeleteResponseCommentDTO dto = makeDTO(request);

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
