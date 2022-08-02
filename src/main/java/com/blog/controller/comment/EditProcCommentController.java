package com.blog.controller.comment;

import com.blog.controller.Controller;
import com.blog.dto.CommentDTO;
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

    private CommentDTO makeDTO(HttpServletRequest request) {
        CommentDTO dto = new CommentDTO();

        dto.setId(Integer.valueOf(request.getParameter("commentId")));
        dto.setUserId(Integer.valueOf(request.getParameter("userId")));
        dto.setPostId(Integer.valueOf(request.getParameter("postId")));
        dto.setBody(request.getParameter("body"));

        return dto;
    }

    @Override
    public String process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        CommentDTO dto = makeDTO(request);
        CommentService commentService = new CommentService(request);

        boolean result = commentService.updateComment(dto);

        if (result) {
            request.setAttribute("message", "댓글 변경이 완료되었습니다.");
            request.setAttribute("target", "/post/edit.do?id=" + dto.getPostId());
            return "/WEB-INF/common/redirect.jsp";
        }
        request.setAttribute("message", "댓글 변경이 실패하였습니다.");
        request.setAttribute("target", "/post/edit.do?id=" + dto.getPostId());
        return "/WEB-INF/common/redirect.jsp";
    }
}
