package com.blog.dao;

import com.blog.entity.Comment;
import com.blog.entity.Post;
import com.blog.entity.User;
import com.blog.util.ExceptionUtil;
import com.blog.util.UserIpUtil;
import org.junit.Test;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

public class CommentDAOTest {

    private final CommentDAO commentDAO = new CommentDAO();

    @Test
    public void findAllCommentList() {
        //Given
        Integer postId = 15;

        //When
        List<Comment> listComment = commentDAO.findAllCommentByPostId(postId);
        listComment.forEach(c -> System.out.println("postId : " + c.getPost().getId() + " body : " + c.getBody()));

        //Then
        assertTrue(listComment.size() > 0);

    }

    @Test
    public void createComment_success() {
        //Given
        User user = new User();
        user.setId(89);

        Post post = new Post();
        post.setId(15);

        Comment comment = new Comment();
        comment.setUser(user);
        comment.setPost(post);
        comment.setBody("졸립다.");
        comment.setUserIp(UserIpUtil.userIp());
        comment.setDeleteState(0);
        comment.setCreatedAt(new Date());

        //When
        Comment newComment = commentDAO.create(comment);

        //Then
        assertEquals(comment, newComment);
        assertTrue(newComment != null && newComment.getId() > 0);
        System.out.println(newComment.toString());
    }

    @Test
    public void findByCommentId_success() {
        //Given
        Integer commentId = 37;

        //When
        Comment findByCommentId = commentDAO.find(commentId);

        //Then
        assertEquals(findByCommentId.getId(), commentId);
        System.out.println(findByCommentId.toString());
    }

    @Test(expected = NullPointerException.class)
    public void findByCommentId_fail() {
        //Given
        Integer commentId = 99;
        //When
        Comment findByCommentId = commentDAO.find(commentId);
        //Then
        assertEquals(findByCommentId.getId(), commentId);
        System.out.println(findByCommentId.toString());
    }

    @Test
    public void updateComment_success() {
        //Given
        User user = new User();
        user.setId(89);

        Post post = new Post();
        post.setId(15);

        Comment comment = new Comment();
        comment.setId(37);
        comment.setUser(user);
        comment.setPost(post);
        comment.setBody("졸립다. (수정본)");
        comment.setUserIp(UserIpUtil.userIp());
        comment.setDeleteState(0);
        comment.setCreatedAt(new Date());


        //When
        Comment editComment = commentDAO.update(comment);

        //Then
        assertEquals(comment.getId(), editComment.getId());
        assertEquals(comment.getBody(), editComment.getBody());
        System.out.println(editComment.toString());
    }



    @Test
    public void deleteStatusUpdateComment_success() {
        Comment comment = new Comment();
        comment.setId(37);

        Comment deleteComment = commentDAO.deleteUpdate(comment);

        assertNotNull(deleteComment);
    }

    @Test
    public void deleteStatusUpdateComment_fail() {
        Comment comment = new Comment();
        comment.setId(99);

        Comment deleteComment = commentDAO.deleteUpdate(comment);

        assertNotNull(deleteComment);
    }

    @Test
    public void createParentComment_success() {
        //Given
        User user = new User();
        user.setId(89);

        Post post = new Post();
        post.setId(15);

        Comment comment = new Comment();
        comment.setUser(user);
        comment.setPost(post);
        comment.setBody("졸립다.");
        comment.setParentsId(15);
        comment.setUserIp(UserIpUtil.userIp());
        comment.setDeleteState(0);
        comment.setCreatedAt(new Date());

        Comment newParenComment = commentDAO.create(comment);

        assertEquals(comment, newParenComment);
        assertTrue(newParenComment != null && newParenComment.getId() > 0);
        System.out.println(newParenComment.toString());
    }


}