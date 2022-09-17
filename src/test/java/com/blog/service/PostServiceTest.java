package com.blog.service;

import com.blog.dto.post.CreateRequestPostDTO;
import com.blog.dto.post.EditRequestPostDTO;
import com.blog.data.entity.Comment;
import com.blog.data.entity.Post;
import com.blog.service.exception.PostServiceException;
import org.apache.log4j.Level;
import org.junit.Test;

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

        EditResponsePostEditDto findByPostId = postService.findByPostId(postId);

        assertNotNull(findByPostId);

    }

    @Test(expected = PostServiceException.class)
    public void findByPostIdFail() {

        Integer postId  = 99;

        EditResponsePostEditDto findByPostId = postService.findByPostId(postId);

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

        EditResponsePostEditDto findByPostId = postService.findByPostId(edtPostDto.getId());
        if (findByPostId == null) {
            throw new PostServiceException("Error", Level.ERROR);
        }
        Post editPost = postService.updatePost(edtPostDto);

        assertEquals(findByPostId.getPost().getId(), editPost.getId());
        assertTrue(editPost.getId() > 0);

        System.out.println(editPost.toString());
    }

    @Test(expected = PostServiceException.class)
    public void updatePostFail() {

        EditRequestPostDTO edtPostDto = EditRequestPostDTO.builder()
                .id(99)
                .title("테스트 코드 작성 중")
                .body("테스트 코드")
                .userId(59)
                .build();

        EditResponsePostEditDto findByPostId = postService.findByPostId(edtPostDto.getId());
        if (findByPostId == null) {
            throw new PostServiceException("Error", Level.ERROR);
        }
        Post editPost = postService.updatePost(edtPostDto);

        assertEquals(findByPostId.getPost().getId(), editPost.getId());
        assertTrue(editPost.getId() > 0);

        System.out.println(editPost.toString());
    }

    @Test
    public void findByPostCommentList() {
        Integer postId  = 15;

        List<Comment> listComment = postService.findByPostId(postId).getCommentList();

        listComment.forEach(c -> System.out.println("게시글 아이디 : " + c.getPost().getId() + " 댓글 제목 : " + c.getBody()));

        assertTrue(listComment.size() > 0);
    }


}