package com.blog.dao;

import com.blog.entity.Comment;
import com.blog.entity.Post;
import com.blog.entity.User;
import com.blog.util.UserIpUtil;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class CommentDAOTest {

    private final UserDAO userDAO = new UserDAO();
    private final CommentDAO commentDAO = new CommentDAO();

    @Test
    public void createCommentSuccess() {
        User user = new User();
        user.setId(96);

        Post post = new Post();
        post.setId(22);

        Comment comment = new Comment();
        comment.setUser(user);
        comment.setBody("댓글 테스트 중");
        comment.setUserIp(UserIpUtil.userIp());
        comment.setPost(post);

        Comment result = commentDAO.create(comment);

        assertEquals(Comment.class, result.getClass());
    }

    @Test
    public void updateCommentSuccess() {
        Post post = new Post();
        post.setId(14);

        User user = new User();
        user.setId(96);

        Comment comment = new Comment();
        comment.setId(20);
        comment.setBody("댓글 수정 중");
        comment.setUserIp(UserIpUtil.userIp());
        comment.setUser(user);
        comment.setPost(post);

        Comment result = commentDAO.update(comment);

        assertEquals(result, comment);
    }


    @Test
    public void findCommentSuccess() {
        Integer id = 20;
        Comment result = commentDAO.find(id);

        assertNotNull(result);
    }

    @Test(expected = AssertionError.class)
    public void findCommentFail() {
        Integer id = 1;
        Comment result = commentDAO.find(id);

        assertNotNull(result);
    }

    @Test
    public void deleteUpdateSuccess() {

        Comment comment = new Comment();
        comment.setId(20);
        comment.setDeleteState(1);

        Comment result = commentDAO.deleteUpdate(comment);

        assertEquals(result, comment);
    }

    @Test
    public void findAllCommentByPostIdSuccess() {

        Integer postId = 22;

        List<Comment> result = commentDAO.findAllCommentByPostId(postId);

        assertNotNull(result);

        System.out.println(result.isEmpty());
    }

    @Test
    public void findAllCommentByPostIdFail() {

        Integer postId = 1;

        List<Comment> result = commentDAO.findAllCommentByPostId(postId);

        assertTrue(result.isEmpty());

        System.out.println(result.isEmpty());
    }
}