package com.blog.service;

import com.blog.entity.Comment;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class CommentServiceTest {

    private final CommentService commentService = new CommentService();

    @Test(expected = Exception.class)
    public void findAllCommentByPostId() {
        Integer postId = 1;

        List<Comment> commentList = commentService.findAllCommentByPostId(postId);

        assertNotNull(commentList);
        System.out.println(Arrays.toString(commentList.toArray()));
    }

    @Test
    public void createCommentSuccess() {
        Integer postId = 1;
        Integer userId = 89;

        CommentDTO dto = new CommentDTO();
        dto.setPostId(postId);
        dto.setUserId(userId);
        dto.setBody("코멘트 테스트 중");

        Comment result = commentService.createComment(dto);

        assertNotEquals(result, dto);
    }

    @Test
    public void findByCommentIdSuccess() {
        CommentDTO dto = new CommentDTO();
        dto.setId(18);

        Comment result = commentService.findByCommentId(dto.getId());

        assertEquals(result.getId(), dto.getId());
    }

    @Test(expected = NullPointerException.class)
    public void findByCommentIdFail() {
        CommentDTO dto = new CommentDTO();
        dto.setId(1);

        Comment result = commentService.findByCommentId(dto.getId());

        assertEquals(result.getId(), dto.getId());
    }

    @Test
    @DisplayName("댓글 수정 가능")
    public void updateCommentSuccess() throws Exception {
        CommentDTO dto = new CommentDTO();
        dto.setId(18);
        dto.setBody("코멘트 수정 테스트");
        dto.setPostId(14);
        dto.setUserId(96);

        Comment result = commentService.updateComment(dto);

        assertNotEquals(dto, result);
        assertEquals(Comment.class, result.getClass());
        assertEquals(dto.getId(), result.getId());
        System.out.println(dto.getId());
        System.out.println(result.getId());
    }

    @Test(expected = Exception.class)
    @DisplayName("게시글이 없어서 댓글을 수정 할 수 없을 때")
    public void updateCommentFail() throws Exception {
        CommentDTO dto = new CommentDTO();
        dto.setId(1);
        dto.setBody("코멘트 수정 테스트");
        dto.setPostId(99);
        dto.setUserId(96);

        Comment result = commentService.updateComment(dto);

        assertNotEquals(dto, result);
        assertEquals(Comment.class, result.getClass());
        assertEquals(dto.getId(), result.getId());
        System.out.println(dto.getId());
        System.out.println(result.getId());
    }

    @Test
    public void deleteCommentSuccess() throws Exception {
        CommentDTO dto = new CommentDTO();
        dto.setId(18);
        dto.setBody("코멘트 수정 테스트");
        dto.setPostId(14);
        dto.setUserId(96);

        Comment result = commentService.deleteComment(dto);

        assertNotEquals(dto,result);
    }

    @Test(expected = Exception.class)
    public void deleteCommentFail() throws Exception {
        CommentDTO dto = new CommentDTO();
        dto.setId(1);
        dto.setBody("코멘트 수정 테스트");
        dto.setPostId(14);
        dto.setUserId(96);

        Comment result = commentService.deleteComment(dto);

        assertNotEquals(dto,result);
    }
}