package com.blog.controller.comment;

import com.blog.controller.Controller;
import com.blog.dto.comment.CreateRequestCommentDTO;
import com.blog.entity.Comment;
import com.blog.service.CommentService;
import com.blog.util.UserIpUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CreateProcCommentController implements Controller {

    private static final String METHOD = "POST";

    @Override
    public String getMethod() {
        return CreateProcCommentController.METHOD;
    }

    private CreateRequestCommentDTO makeDTO(HttpServletRequest request) {
        return CreateRequestCommentDTO.builder()
                .userId(Integer.valueOf(request.getParameter("userId")))
                .postId(Integer.valueOf(request.getParameter("postId")))
                .userIp(UserIpUtil.userIp())
                .body(request.getParameter("body"))
                .cDepth(0)
                .cGroup(0)
                .build();

    }

    @Override
    public String process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        CreateRequestCommentDTO dto = makeDTO(request);
        CommentService commentService = new CommentService();

        Comment result = commentService.createComment(dto);

        if (result == null) {
            request.setAttribute("message", "댓글 등록이 실패하었습니다.");
            request.setAttribute("target", "/post/edit.do?id="+dto.getPostId());
            return "/WEB-INF/common/redirect.jsp";
        }
        request.setAttribute("message", "댓글이 등록 되었습니다.");
        request.setAttribute("target", "/post/edit.do?id="+dto.getPostId());
        return "/WEB-INF/common/redirect.jsp";
    }
}
