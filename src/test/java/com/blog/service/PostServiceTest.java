package com.blog.service;

import com.blog.dto.PostDTO;
import com.blog.entity.Post;
import com.blog.entity.User;
import org.junit.Test;

import javax.servlet.http.HttpServletRequest;

import static org.easymock.EasyMock.createMock;
import static org.junit.Assert.*;

public class PostServiceTest {

    HttpServletRequest request = createMock(HttpServletRequest.class);


    private final PostService postService = new PostService(request);


    @Test
    void successfulCreatePost() {
        PostDTO dto = new PostDTO();
        // TODO
        dto.setTitle("TEST");

        Post post = postService.createPost(dto);

        assertNotNull(post);
        assertEquals(post.getTitle(), dto.getTitle());
    }

    @Test
    void failedCreatePost() {
        PostDTO dto = new PostDTO();
        Post post = postService.createPost(dto);

        assertNull(post);
    }

    @Test
    void createPost() {
        User user = new User();
        user.setId(96);
        Post post = new Post();
        post.setTitle("테스트");
        post.setBody("가나다라마바사");
        post.setUser(user);

        try {
            PostDTO dto = new PostDTO();
            dto.setTitle(post.getTitle());
            dto.setBody(post.getBody());
            dto.setUserId(post.getUser().getId());

            Post result = postService.createPost(dto);

            assertEquals(post, result);
        } catch (NullPointerException e) {
            e.printStackTrace();
            System.out.println("NullPointerException");
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Exception");
        }
    }

    @Test
    void updatePost() {
        User user = new User();
        user.setId(96);

        Post post = new Post();
        post.setId(16);
        post.setTitle("테스트");
        post.setBody("가나다라마바사");
        post.setUser(user);

        try {
            PostDTO dto = new PostDTO();
            dto.setTitle(post.getTitle());
            dto.setBody(post.getBody());
            dto.setUserId(post.getUser().getId());

            Post result = postService.updatePost(dto);

            assertEquals(post, result);
        } catch (NullPointerException e) {
            e.printStackTrace();
            System.out.println("NullPointerException");
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Exception");
        }
    }
}