package com.blog.controller;

import com.blog.service.CommentService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteCommentController implements Controller {
    private final CommentService commentService;

    public DeleteCommentController() {
        this.commentService = new CommentService();
    }
    //TODO makeDTO를 Mapper로 합쳐야 한다.
    private DeleteResponseCommentDTO makeDTO(HttpServletRequest request) {
        return DeleteResponseCommentDTO.builder()
                .id(Integer.valueOf(request.getParameter("commentId")))
                .postId(Integer.valueOf(request.getParameter("postId")))
                .build();
    }

    @Override
    public String doGet(HttpServletRequest request, HttpServletResponse response) {
        DeleteResponseCommentDTO dto = makeDTO(request);
        CommentService commentService = new CommentService();

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
