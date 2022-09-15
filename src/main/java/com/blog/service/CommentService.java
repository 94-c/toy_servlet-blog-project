package com.blog.service;

import com.blog.data.dao.CommentDAO;
import com.blog.dto.comment.CreateRequestCommentDTO;
import com.blog.dto.comment.DeleteResponseCommentDTO;
import com.blog.dto.comment.EditRequestCommentDTO;
import com.blog.dto.comment.parenteComment.CreateRequestParentCommentDTO;
import com.blog.dto.comment.parenteComment.EditRequestParentCommentDTO;
import com.blog.data.entity.Comment;
import com.blog.service.exception.CommentServiceException;
import lombok.RequiredArgsConstructor;
import org.apache.log4j.Level;

@RequiredArgsConstructor
public class CommentService {

    private static final CommentDAO commentDAO = new CommentDAO();

    public Comment createComment(CreateRequestCommentDTO dto) throws CommentServiceException {
        Comment comment = dto.toEntity();
        Comment newComment = commentDAO.create(comment);
        if (newComment == null) {
            throw new CommentServiceException("createComment Error", Level.ERROR);
        }
        return newComment;
    }

    public Comment findByCommentId(Integer commentId) throws CommentServiceException {
        Comment findByCommentId = commentDAO.find(commentId);
        if (findByCommentId == null) {
            throw new CommentServiceException("findComment Error", Level.ERROR);
        }
        return findByCommentId;
    }

    public Comment updateComment(EditRequestCommentDTO dto) throws CommentServiceException {
        Comment comment = commentDAO.find(dto.getId());
        if (comment == null) {
            throw new CommentServiceException("updateComment Error", Level.ERROR);
        }
        Comment updateCommentDto = dto.toEntity(comment);
        return commentDAO.update(updateCommentDto);
    }

    public void deleteComment(DeleteResponseCommentDTO dto) throws CommentServiceException {
        Comment comment = commentDAO.find(dto.getId());
        if (comment == null) {
            throw new CommentServiceException("findComment Error", Level.ERROR);
        }

        try {
            commentDAO.deleteUpdate(comment);
        } catch (Exception e) {
            throw new CommentServiceException("commend delete error", Level.ERROR);
        }
    }


    public Comment createParentComment(CreateRequestParentCommentDTO dto) throws CommentServiceException {
        Comment comment = dto.ToParentCommentEntity();
        Comment newComment = commentDAO.create(comment);
        if (newComment == null) {
            throw new CommentServiceException("createParent Error", Level.ERROR);
        }
        return newComment;
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
