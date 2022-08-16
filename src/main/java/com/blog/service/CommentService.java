package com.blog.service;

import com.blog.dao.CommentDAO;
import com.blog.dto.CommentDTO;
import com.blog.entity.Comment;
import com.blog.entity.Post;
import com.blog.entity.User;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class CommentService {

    private static final CommentDAO commentDAO = new CommentDAO();

    private void addCommentField(Comment comment, CommentDTO dto) {
        User user = new User();
        user.setId(dto.getUserId());

        Post post = new Post();
        post.setId(dto.getPostId());

        comment.setId(dto.getId());
        comment.setBody(dto.getBody());
        comment.setParentsId(dto.getParentsCommentId());
        comment.setUser(user);
        comment.setPost(post);

    }

    public List<Comment> findAllCommentByPostId(Integer postId) {
        return commentDAO.findAllCommentByPostId(postId);
    }

    public Comment createComment(CommentDTO dto) {
        Comment newComment = new Comment();
        addCommentField(newComment, dto);
        commentDAO.create(newComment);
        return newComment;
    }

    public Comment findByCommentId(Integer commentId) {
        return commentDAO.find(commentId);
    }

    public Comment updateComment(CommentDTO dto) throws Exception{
        Comment comment = commentDAO.find(dto.getId());
        if (comment == null) {
            throw new Exception();
        }
        addCommentField(comment, dto);
        commentDAO.update(comment);
        return comment;
    }

    public Comment deleteComment(CommentDTO dto) throws Exception {
        Comment comment = commentDAO.find(dto.getId());
        if (comment == null) {
            throw new Exception();
        }
        comment.setDeleteState(1);
        addCommentField(comment, dto);
        commentDAO.deleteUpdate(comment);
        return comment;
    }

}
