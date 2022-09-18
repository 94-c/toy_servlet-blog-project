package com.blog.service;

import com.blog.data.dto.CommentDto;
import com.blog.data.dto.ParentCommentDto;
import com.blog.data.entity.Comment;
import com.blog.service.exception.PostServiceException;
import com.blog.util.UserIpUtil;
import org.junit.Test;

import static org.junit.Assert.*;

public class CommentServiceTest {

    private final CommentService commentService = new CommentService();

    @Test
    public void createCommentSuccess() {
        CommentDto newCommentDto = CommentDto.builder()
                .body("테스트 코멘트 작성 중")
                .postId(14)
                .userId(96)
                .userIp(UserIpUtil.userIp())
                .build();

        Comment newComment = commentService.createComment(newCommentDto);

        assertTrue(newComment != null && newComment.getId() > 0);
    }

    @Test
    public void createParentCommentSuccess() {
        ParentCommentDto newParentCommentDto = ParentCommentDto.builder()
                .body("테스트 코멘트 작성 중")
                .postId(14)
                .userId(96)
                .userIp(UserIpUtil.userIp())
                .parentsId(50)
                .build();

        Comment newParentComment = commentService.createParentComment(newParentCommentDto);

        assertTrue(newParentComment != null && newParentComment.getId() > 0);
    }

    @Test
    public void findByCommentIdSuccess() {

        Integer commentId = 50;

        Comment findByCommentId = commentService.findByCommentId(commentId);

        assertNotNull(findByCommentId);
    }

    @Test(expected = PostServiceException.class)
    public void findByCommentIdFail() {

        Integer commentId = 99;

        Comment findByCommentId = commentService.findByCommentId(commentId);

        assertNotNull(findByCommentId);
    }

    @Test
    public void updateCommentSuccess() {
        CommentDto editCommentDto = CommentDto.builder()
                .id(50)
                .body("테스트 코드 재작성중")
                .userId(96)
                .postId(14)
                .userIp(UserIpUtil.userIp())
                .build();

        Comment editComment = commentService.updateComment(editCommentDto);

        assertTrue(editComment.getId() > 0);
        assertEquals(editComment.getClass(), Comment.class);

        System.out.println(editComment.toString());
    }

    @Test(expected = PostServiceException.class)
    public void updateCommentFail() {
        CommentDto editCommentDto = CommentDto.builder()
                .id(1000)
                .body("테스트 코드 재작성중")
                .userId(96)
                .postId(1000)
                .userIp(UserIpUtil.userIp())
                .build();

        Comment editComment = commentService.updateComment(editCommentDto);

        assertTrue(editComment.getId() > 0);
        assertEquals(editComment.getClass(), Comment.class);

        System.out.println(editComment.toString());
    }


    @Test
    public void updateParentCommentSuccess() {
       ParentCommentDto editCommentDto = ParentCommentDto.builder()
                .id(51)
                .body("테스트 코드 재작성중")
                .userId(96)
                .postId(14)
                .parentsId(50)
                .userIp(UserIpUtil.userIp())
                .build();

        Comment editComment = commentService.updateParentComment(editCommentDto);

        assertTrue(editComment.getId() > 0);
        assertEquals(editComment.getClass(), Comment.class);

        System.out.println(editComment.toString());
    }

    @Test(expected = PostServiceException.class)
    public void updateParentCommentFail() {
        ParentCommentDto editCommentDto = ParentCommentDto.builder()
                .id(10051)
                .body("테스트 코드 재작성중")
                .userId(96)
                .postId(14)
                .parentsId(50)
                .userIp(UserIpUtil.userIp())
                .build();

        Comment editComment = commentService.updateParentComment(editCommentDto);

        assertTrue(editComment.getId() > 0);
        assertEquals(editComment.getClass(), Comment.class);

        System.out.println(editComment.toString());
    }

}