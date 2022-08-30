package com.blog.service;

import com.blog.dto.post.CreateRequestPostDTO;
import com.blog.dto.post.EditRequestPostDTO;
import com.blog.entity.Post;
import com.blog.service.mapper.PostEditMapper;
import com.blog.util.ExceptionUtil;
import org.junit.Test;

import javax.persistence.Id;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

public class PostServiceTest {

    private final PostService postService = new PostService();

    @Test
    public void findAllPostList() {

        List<Post> list = postService.findAllPost();
        list.forEach(p -> System.out.println("포스트 타이틀 : " + p.getTitle()));

        assertTrue(list.size() > 0);
    }

    @Test
    public void createPost() {

        CreateRequestPostDTO newPostDto = CreateRequestPostDTO.builder()
                .title("테스트 코드 작성 중")
                .body("테스트 코드")
                .userId(59)
                .build();

        Post newPost = postService.createPost(newPostDto);

        assertTrue(newPost != null && newPost.getId() > 0);

    }

    @Test
    public void findByPostIdSuccess() {

        Integer postId  = 67;

        PostEditMapper findByPostId = postService.findByPostId(postId);

        assertNotNull(findByPostId);

    }

    @Test(expected = ExceptionUtil.class)
    public void findByPostIdFail() {

        Integer postId  = 99;

        PostEditMapper findByPostId = postService.findByPostId(postId);

        assertNotNull(findByPostId);

    }

    @Test
    public void updatePostSuccess() {

        EditRequestPostDTO edtPostDto = EditRequestPostDTO.builder()
                .id(67)
                .title("테스트 코드 작성 중")
                .body("테스트 코드")
                .userId(59)
                .build();

        PostEditMapper findByPostId = postService.findByPostId(edtPostDto.getId());
        if (findByPostId == null) {
            throw new ExceptionUtil("Error");
        }
        Post editPost = postService.updatePost(edtPostDto);

        assertEquals(findByPostId.getPost().getId(), editPost.getId());
        assertTrue(editPost.getId() > 0);

        System.out.println(editPost.toString());
    }

    @Test(expected = ExceptionUtil.class)
    public void updatePostFail() {

        EditRequestPostDTO edtPostDto = EditRequestPostDTO.builder()
                .id(99)
                .title("테스트 코드 작성 중")
                .body("테스트 코드")
                .userId(59)
                .build();

        PostEditMapper findByPostId = postService.findByPostId(edtPostDto.getId());
        if (findByPostId == null) {
            throw new ExceptionUtil("Error");
        }
        Post editPost = postService.updatePost(edtPostDto);

        assertEquals(findByPostId.getPost().getId(), editPost.getId());
        assertTrue(editPost.getId() > 0);

        System.out.println(editPost.toString());
    }

}