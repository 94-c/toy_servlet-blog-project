package com.blog.controller.comment.parentComment;

import com.blog.controller.Controller;
import com.blog.dto.comment.parenteComment.CreateRequestParentCommentDTO;
import com.blog.dto.comment.parenteComment.EditRequestParentCommentDTO;
import com.blog.entity.Comment;
import com.blog.service.CommentService;
import com.blog.util.UserIpUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class EditProcParentCommentController implements Controller {

    private static final String METHOD = "POST";

    @Override
    public String getMethod() {
        return EditProcParentCommentController.METHOD;
    }

    private EditRequestParentCommentDTO makeDTO(HttpServletRequest request) {
        return EditRequestParentCommentDTO.builder()
                .id(Integer.valueOf(request.getParameter("id")))
                .userId(Integer.valueOf(request.getParameter("userId")))
                .body(request.getParameter("parentBody"))
                .userIp(UserIpUtil.userIp())
                .parentsId(Integer.valueOf(request.getParameter("commentId")))
                .postId(Integer.valueOf(request.getParameter("postId")))
                .build();
    }

    @Override
    public String process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        EditRequestParentCommentDTO dto = makeDTO(request);

        CommentService commentService = new CommentService();

        Comment result = commentService.updateParentComment(dto);

        if (result == null) {
            request.setAttribute("message", "대댓글 수정이 실패하었습니다.");
            request.setAttribute("target", "javascript:history.back()");
            return "/WEB-INF/common/redirect.jsp";
        }
        request.setAttribute("message", "대댓글이 수정 되었습니다.");
        request.setAttribute("target", "javascript:history.back()");
        return "/WEB-INF/common/redirect.jsp";
    }
}
