package com.blog.service;

import com.blog.dao.PostDAO;
import com.blog.dto.PostDTO;
import com.blog.entity.Post;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

public class PostServiceTest {

    private static final PostDAO postDAO = new PostDAO();

    @Test
    public void findAllPost() {
        List<Post> postList = postDAO.findAllCreateQuery();

        assertThat(postList, equalTo(postList));
        System.out.println(postList.get(0));
        System.out.println(postList.get(1));
    }

    @Test
    public void createPost() {
    }

    @Test
    public void findByPostId() {
    }

    @Test
    public void updatePost() {
    }

    @Test
    public void deletePost() {
    }
}