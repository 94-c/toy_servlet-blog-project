package com.blog.controller.comment.parentComment;

import com.blog.controller.Controller;
import com.blog.data.entity.Comment;
import com.blog.dto.comment.parenteComment.EditRequestParentCommentDTO;
import com.blog.mapper.EditRequestDto;
import com.blog.service.CommentService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EditParentCommentController implements Controller {
    private final CommentService commentService;

    public EditParentCommentController() {
        this.commentService = new CommentService();
    }

    @Override
    public String doGet(HttpServletRequest request, HttpServletResponse response) {
        Integer parentId = Integer.valueOf(request.getParameter("parentId"));

        CommentService commentService = new CommentService();

        Comment parentComment = commentService.findByCommentId(parentId);

        if (parentComment == null) {
            request.setAttribute("message", "대댓글 정보를 못 찾았습니다.");
            request.setAttribute("target", "javascript:history.back()");
        }
        request.setAttribute("parentComment", parentComment);
        return "/WEB-INF/views/parentComment.jsp";
    }

    @Override
    public String doPost(HttpServletRequest request, HttpServletResponse response) {
        EditRequestParentCommentDTO dto = new EditRequestDto().toParentDto(request);
        Comment result = commentService.updateParentComment(dto);

        if (result == null) {
            request.setAttribute("message", "대댓글 수정이 실패하었습니다.");
            return "/WEB-INF/common/redirect.jsp";
        }
        request.setAttribute("message", "대댓글이 수정 되었습니다.");
        return "/WEB-INF/common/redirect.jsp";
    }
}
