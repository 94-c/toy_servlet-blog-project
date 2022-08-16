package com.blog.service;

import com.blog.dto.PostDTO;
import com.blog.entity.Post;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class PostServiceTest {

    private final PostService postService = new PostService();

    @Test
    public void postList() {
        List<Post> postList = postService.findAllPost();

        assertNotNull(postList);
        System.out.println(Arrays.toString(postList.toArray()));
    }

    @Test
    public void createSuccessPost() {
        PostDTO dto = new PostDTO();
        dto.setTitle("테스트 코드 작성");
        dto.setBody("테스트 코드 작성");
        dto.setUserId(1);

        Post post = postService.createPost(dto);

        assertNotEquals(dto, post);
        assertEquals(Post.class, post.getClass());

    }

    @Test(expected = Exception.class)
    public void createFailPost() {
        PostDTO dto = new PostDTO();
        dto.setTitle("테스트 코드 작성");
        dto.setBody("테스트 코드 작성");
        dto.setUserId(22);

        Post post = postService.createPost(dto);
        assertNotEquals(dto, post);
        assertEquals(Post.class, post.getClass());

    }

    @Test
    public void findByPostIdSuccess() {
        PostDTO dto = new PostDTO();
        dto.setId(1);
        Post result = postService.findByPostId(dto.getId());
        assertNotEquals(result, dto);
    }

    @Test(expected = Exception.class)
    public void findByPostIdFail() {
        PostDTO dto = new PostDTO();
        dto.setId(99);
        Post result = postService.findByPostId(dto.getId());
        assertNotEquals(result, dto);
    }


    @Test
    public void updateSuccessPost() throws Exception {
        PostDTO dto = new PostDTO();
        dto.setId(1);
        dto.setTitle("테스트 코드 업데이트 작성");
        dto.setBody("테스트 코드 작성");
        dto.setUserId(1);

        Post post = postService.updatePost(dto);

        assertNotEquals(dto, post);
        assertEquals(Post.class, post.getClass());

    }

    @Test(expected = Exception.class)
    public void updateFailPost() throws Exception {
        PostDTO dto = new PostDTO();
        dto.setId(99);
        dto.setTitle("테스트 코드 업데이트 작성");
        dto.setBody("테스트 코드 작성");
        dto.setUserId(2);

        Post post = postService.updatePost(dto);

        assertNotEquals(dto, post);
        assertEquals(Post.class, post.getClass());

    }

}