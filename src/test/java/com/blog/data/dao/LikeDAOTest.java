package com.blog.data.dao;

import com.blog.data.entity.Like;
import com.blog.data.entity.Post;
import com.blog.data.entity.User;
import org.junit.Test;

import static org.junit.Assert.*;

public class LikeDAOTest {

    private final LikeDAO likeDAO = new LikeDAO();

    @Test
    public void createLike() {
        Post post = new Post();
        post.setId(75);

        User user = new User();
        user.setId(96);

        Like like = new Like();
        like.setUser(user);
        like.setPost(post);
        like.setType("g");

        Like newLike = likeDAO.create(like);

        assertEquals(like, newLike);
        assertTrue(newLike != null && newLike.getId() > 0);
    }

}