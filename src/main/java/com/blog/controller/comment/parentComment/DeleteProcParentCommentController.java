package com.blog.controller.comment.parentComment;

import com.blog.controller.Controller;
import com.blog.dto.comment.DeleteResponseCommentDTO;
import com.blog.entity.Comment;
import com.blog.service.CommentService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteProcParentCommentController implements Controller {

    private static final String METHOD = "GET";

    @Override
    public String getMethod() {
        return DeleteProcParentCommentController.METHOD;
    }

    private DeleteResponseCommentDTO makeDTO(HttpServletRequest request) {
        return DeleteResponseCommentDTO.builder()
                .id(Integer.valueOf(request.getParameter("parentId")))
                .postId(Integer.valueOf(request.getParameter("postId")))
                .build();
    }

    @Override
    public String process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        DeleteResponseCommentDTO dto = makeDTO(request);
        CommentService commentService = new CommentService();

        try {
            commentService.deleteComment(dto);
            request.setAttribute("message", "대댓글 삭제가 성공하었습니다.");
            request.setAttribute("target", "/post/edit.do?id="+dto.getPostId());
            return "/WEB-INF/common/redirect.jsp";
        }catch (Exception e) {
            request.setAttribute("message", "대댓글 삭제가 실패하었습니다.");
            request.setAttribute("target", "/post/edit.do?id="+dto.getPostId());
            return "/WEB-INF/common/redirect.jsp";
        }
    }
}
