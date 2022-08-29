package com.blog.controller.comment;

import com.blog.controller.Controller;
import com.blog.entity.Comment;
import com.blog.service.CommentService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteProcCommentController implements Controller {

    private static final String METHOD = "GET";

    @Override
    public String getMethod() {
        return DeleteProcCommentController.METHOD;
    }

    private CommentDTO makeDTO(HttpServletRequest request) {
        CommentDTO dto = new CommentDTO();

        dto.setId(Integer.valueOf(request.getParameter("commentId")));
        dto.setPostId(Integer.valueOf(request.getParameter("postId")));

        return dto;
    }

    @Override
    public String process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        CommentDTO dto = makeDTO(request);
        CommentService commentService = new CommentService();

        Comment result = null;

        try {
            result = commentService.deleteComment(dto);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        if (result == null) {
            request.setAttribute("message", "댓글 삭제가 실패하었습니다.");
            request.setAttribute("target", "/post/edit.do?id="+dto.getPostId());
            return "/WEB-INF/common/redirect.jsp";
        }
        request.setAttribute("message", "댓글 삭제가 성공하었습니다.");
        request.setAttribute("target", "/post/edit.do?id="+dto.getPostId());
        return "/WEB-INF/common/redirect.jsp";

    }
}
