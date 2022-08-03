package com.blog.service;

import com.blog.dao.CommentDAO;
import com.blog.dto.CommentDTO;
import com.blog.dto.PostDTO;
import com.blog.entity.Comment;
import com.blog.entity.Post;
import com.blog.entity.User;
import com.blog.util.UserIpUtil;
import org.junit.Test;

import java.util.Date;
import java.util.List;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.*;

public class CommentServiceTest {

    private static final CommentDAO commentDAO = new CommentDAO();

    @Test
    public void findAllCommentByPostId() {
        Integer postId = 12;
        List<Comment> commentList = commentDAO.findAllCommentByPostId(postId);

        assertThat(commentList, equalTo(commentList));
        System.out.println(commentList.toString());
        System.out.println(equalTo(commentList).toString());
    }

    @Test
    public void createComment() {
        Comment comment = new Comment();
        try {
            CommentDTO dto = new CommentDTO();
            dto.setBody("123456");
            dto.setUserIp(UserIpUtil.userIp());
            dto.setUserId(52);
            dto.setPostId(12);

            User user = new User();
            user.setId(dto.getUserId());

            Post post = new Post();
            post.setId(dto.getPostId());

            comment.setPost(post);
            comment.setBody(dto.getBody());
            comment.setUser(user);
            comment.setUserIp(dto.getUserIp());

            Comment result = commentDAO.create(comment);

            assertEquals(comment, result);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void findByCommentId() {
        Integer id = 11;
        try {
            CommentDTO dto = new CommentDTO();
            dto.setId(id);

            Comment result = commentDAO.find(id);
            assertNotNull(result);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void updateComment() {
        Integer id = 11;
        Comment comment = commentDAO.find(id);
        if (comment == null) {
            return;
        }
        try{
            CommentDTO dto = new CommentDTO();
            dto.setId(comment.getId());
            dto.setBody("수정 완료");
            dto.setUserIp(UserIpUtil.userIp());

            comment.setId(dto.getId());
            comment.setBody(dto.getBody());
            comment.setUserIp(dto.getUserIp());

            Comment result = commentDAO.update(comment);

            assertEquals(comment, result);
            System.out.println(result.toString());
            System.out.println(comment.hashCode());
            System.out.println(result.hashCode());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void deleteComment() {
        Integer id = 11;
        Comment comment = commentDAO.find(id);
        if (comment == null) {
            return;
        }
        try {
            CommentDTO dto = new CommentDTO();
            dto.setId(comment.getId());

            comment.setId(dto.getId());
            comment.setDeleteState(1);

            Comment result = commentDAO.deleteUpdate(comment);

            assertEquals(comment, result);

            System.out.println(result.toString());
            System.out.println(comment.hashCode());
            System.out.println(result.hashCode());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}