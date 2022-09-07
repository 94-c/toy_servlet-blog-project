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
import org.apache.log4j.Level;

@RequiredArgsConstructor
public class CommentService {

    private static final CommentDAO commentDAO = new CommentDAO();

    public Comment createComment(CreateRequestCommentDTO dto) throws CommentServiceException {
        Comment newComment = dto.ToEntity();
        Comment result = commentDAO.create(newComment);
        if (result == null) {
            throw new CommentServiceException("createComment Error", Level.ERROR);
        }
        return newComment;
    }

    public Comment findByCommentId(Integer commentId) throws CommentServiceException {
        Comment findByCommentId = commentDAO.find(commentId);
        if (findByCommentId == null) {
            throw new CommentServiceException("findComment Error", Level.ERROR);
        }
        return commentDAO.find(commentId);
    }

    public Comment updateComment(EditRequestCommentDTO dto) throws CommentServiceException {
        Comment comment = commentDAO.find(dto.getId());
        if (comment == null) {
            throw new CommentServiceException("updateComment Error", Level.ERROR);
        }
        Comment updateCommentDto = dto.ToEntity(comment);
        return commentDAO.update(updateCommentDto);
    }

    public Comment deleteComment(DeleteResponseCommentDTO dto) throws CommentServiceException {
        Comment comment = commentDAO.find(dto.getId());
        if (comment == null) {
            throw new CommentServiceException("findComment Error", Level.ERROR);
        }
        commentDAO.deleteUpdate(comment);
        return comment;
    }


    public Comment createParentComment(CreateRequestParentCommentDTO dto) throws CommentServiceException {
        Comment newParentComment = dto.ToParentCommentEntity();
        Comment result = commentDAO.create(newParentComment);
        if (result == null) {
            throw new CommentServiceException("createParent Error", Level.ERROR);
        }
        return result;
    }

    public Comment updateParentComment(EditRequestParentCommentDTO dto) throws CommentServiceException {
        Comment parentComment = commentDAO.find(dto.getId());
        if (parentComment == null) {
            throw new CommentServiceException("updateParent Error", Level.ERROR);
        }
        Comment updateParentCommentDto = dto.ToParentCommentEntity(parentComment);
        return commentDAO.update(updateParentCommentDto);
    }

}
