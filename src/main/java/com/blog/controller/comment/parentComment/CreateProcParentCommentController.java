package com.blog.controller.comment.parentComment;

import com.blog.controller.Controller;
import com.blog.dto.comment.parenteComment.CreateRequestParentCommentDTO;
import com.blog.entity.Comment;
import com.blog.service.CommentService;
import com.blog.util.UserIpUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CreateProcParentCommentController implements Controller {

    private static final String METHOD = "POST";

    @Override
    public String getMethod() {
        return CreateProcParentCommentController.METHOD;
    }

    private CreateRequestParentCommentDTO makeDTO(HttpServletRequest request) {
        return CreateRequestParentCommentDTO.builder()
                .userId(Integer.valueOf(request.getParameter("userId")))
                .body(request.getParameter("parentBody"))
                .userIp(UserIpUtil.userIp())
                .cDepth(1)
                .cGroup(Integer.valueOf(request.getParameter("commentId")))
                .build();
    }

    @Override
    public String process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        CreateRequestParentCommentDTO dto = makeDTO(request);

        CommentService commentService = new CommentService();

        Comment result = commentService.createParentComment(dto);

        if (result == null) {
            request.setAttribute("message", "대댓글 등록이 실패하었습니다.");
            return "/WEB-INF/common/redirect.jsp";
        }
        request.setAttribute("message", "대댓글이 등록 되었습니다.");
        return "/WEB-INF/common/redirect.jsp";
    }
}
