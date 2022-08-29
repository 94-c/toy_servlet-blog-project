package com.blog.controller.comment;

import com.blog.controller.Controller;
import com.blog.dto.comment.EditRequestCommentDTO;
import com.blog.entity.Comment;
import com.blog.service.CommentService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class EditProcCommentController implements Controller {

    private static final String METHOD = "POST";

    @Override
    public String getMethod() {
        return EditProcCommentController.METHOD;
    }

    private EditRequestCommentDTO makeDTO(HttpServletRequest request) {
        return EditRequestCommentDTO.builder()
                .id(Integer.valueOf(request.getParameter("commentId")))
                .userId(Integer.valueOf(request.getParameter("userId")))
                .postId(Integer.valueOf(request.getParameter("postId")))
                .body(request.getParameter("body"))
                .build();
    }

    @Override
    public String process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        EditRequestCommentDTO dto = makeDTO(request);
        CommentService commentService = new CommentService();

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
