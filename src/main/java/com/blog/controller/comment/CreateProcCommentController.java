package com.blog.controller.comment;

import com.blog.controller.Controller;
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

    private CommentDTO makeDTO(HttpServletRequest request) {
        CommentDTO dto = new CommentDTO();

        dto.setUserId(Integer.valueOf(request.getParameter("userId")));
        dto.setPostId(Integer.valueOf(request.getParameter("postId")));
        dto.setUserIp(UserIpUtil.userIp());
        dto.setBody(request.getParameter("body"));

        return dto;

    }

    @Override
    public String process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        CommentDTO dto = makeDTO(request);
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
