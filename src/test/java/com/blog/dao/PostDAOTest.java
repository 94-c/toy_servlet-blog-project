package com.blog.dao;

import com.blog.dto.PostDTO;
import com.blog.dto.UserDTO;
import com.blog.entity.Post;
import com.blog.entity.User;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

public class PostDAOTest {

    private final PostDAO postDAO = new PostDAO();

    @Test
    public void create() {
        User user = new User();
        user.setId(96);

        Post post = new Post();
        post.setTitle("게시물 작성 진행 중");
        post.setBody("테스트 코드 작성");
        post.setUser(user);

        Post result = postDAO.create(post);

        assertEquals(Post.class, result);
    }

    @Test
    public void update() {
    }

    @Test
    public void findAllCreateQuery() {
    }

    @Test
    public void deleteUpdate() {
    }
}