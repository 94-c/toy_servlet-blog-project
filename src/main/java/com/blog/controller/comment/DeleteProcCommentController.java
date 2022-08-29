package com.blog.controller.comment;

import com.blog.controller.Controller;
import com.blog.dto.comment.DeleteResponseCommentDTO;
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

    private DeleteResponseCommentDTO makeDTO(HttpServletRequest request) {
        return DeleteResponseCommentDTO.builder()
                .id(Integer.valueOf(request.getParameter("commentId")))
                .postId(Integer.valueOf(request.getParameter("postId")))
                .build();
    }

    @Override
    public String process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        DeleteResponseCommentDTO dto = makeDTO(request);
        CommentService commentService = new CommentService();

        Comment result = commentService.deleteComment(dto);

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
