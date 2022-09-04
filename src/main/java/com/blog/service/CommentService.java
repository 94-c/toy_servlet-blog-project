package com.blog.service;

import com.blog.dao.CommentDAO;
import com.blog.dto.comment.CreateRequestCommentDTO;
import com.blog.dto.comment.DeleteResponseCommentDTO;
import com.blog.dto.comment.EditRequestCommentDTO;
import com.blog.dto.comment.parenteComment.CreateRequestParentCommentDTO;
import com.blog.dto.comment.parenteComment.EditRequestParentCommentDTO;
import com.blog.entity.Comment;
import com.blog.service.exception.CommentServiceException;
import com.blog.service.exception.ServiceException;
import com.blog.util.ExceptionUtil;
import lombok.RequiredArgsConstructor;

import java.util.logging.Level;

@RequiredArgsConstructor
public class CommentService {

    private static final CommentDAO commentDAO = new CommentDAO();

    public Comment createComment(CreateRequestCommentDTO dto) throws ExceptionUtil {
        Comment newComment = dto.ToEntity();
        Comment result = commentDAO.create(newComment);
        if (result == null) {
            throw new ServiceException("Create Comment Error");
        }
        return newComment;
    }

    public Comment findByCommentId(Integer commentId) throws ExceptionUtil {
        Comment findByCommentId = commentDAO.find(commentId);
        if (findByCommentId == null) {
            throw new ExceptionUtil("findByCommentId Error");
        }
        return commentDAO.find(commentId);
    }

    public Comment updateComment(EditRequestCommentDTO dto) throws ExceptionUtil {
        Comment comment = commentDAO.find(dto.getId());
        if (comment == null) {
            throw new CommentServiceException("updateComment Error", Level.WARNING);
        }
        Comment updateCommentDto = dto.ToEntity(comment);
        return commentDAO.update(updateCommentDto);
    }

    public Comment deleteComment(DeleteResponseCommentDTO dto) throws ExceptionUtil {
        Comment comment = commentDAO.find(dto.getId());
        if (comment == null) {
            throw new ExceptionUtil("findByComment Error");
        }
        commentDAO.deleteUpdate(comment);
        return comment;
    }


    public Comment createParentComment(CreateRequestParentCommentDTO dto) throws ExceptionUtil {
        Comment newParentComment = dto.ToParentCommentEntity();
        Comment result = commentDAO.create(newParentComment);
        if (result == null) {
            throw new ExceptionUtil("Create ParentComment Error");
        }
        return result;
    }

    public Comment updateParentComment(EditRequestParentCommentDTO dto) throws ExceptionUtil {
        Comment parentComment = commentDAO.find(dto.getId());
        if (parentComment == null) {
            throw new ExceptionUtil("updateParentComment Error");
        }
        Comment updateParentCommentDto = dto.ToParentCommentEntity();
        Comment updateParentComment = commentDAO.update(updateParentCommentDto);
        return updateParentComment;
    }

}
