package com.blog.dao;

import com.blog.entity.Comment;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommentDAO extends JpaDAO<Comment> {

    @Override
    public Comment create(Comment comment) {
        comment.setDeleteState(0);
        comment.setCreatedAt(new Date());
        return super.create(comment);
    }

    @Override
    public Comment update(Comment comment) {
        comment.setUpdatedAt(new Date());
        return super.update(comment);
    }

    public Comment find(Integer id) {
        return super.find(Comment.class, id);
    }

    //삭제 버튼 시, delete_state = 1로 변경
    public Comment deleteUpdate(Comment comment) {
        comment.setDeleteState(1);
        return super.update(comment);
    }

    public List<Comment> findAllCommentByPostId(Integer postId) {
        return super.findWithNamedQuery("Comment.findAll", "postId", postId);
    }

    public List<Comment> findAllParentCommentList(Integer commentId) {
        return super.findWithNamedQuery("Comment.findByParentComment", "commentId", commentId);
    }

}
