package com.blog.service;

import com.blog.dao.CommentDAO;
import com.blog.dto.CommentDTO;
import com.blog.entity.Comment;
import com.blog.entity.Post;
import com.blog.entity.User;
import lombok.RequiredArgsConstructor;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RequiredArgsConstructor
public class CommentService {

    private final HttpServletRequest request;
    private static final CommentDAO commentDAO = new CommentDAO();

    private void commentField(Comment comment, CommentDTO dto) {
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

    public void findAllCommentByPostId(Integer postId){
        List<Comment> commentList = commentDAO.findAllCommentByPostId(postId);
        request.setAttribute("commentList", commentList);
    }

    public boolean createComment(CommentDTO dto) {
        Comment comment = new Comment();
        try {
            commentField(comment, dto);
            commentDAO.create(comment);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


}
