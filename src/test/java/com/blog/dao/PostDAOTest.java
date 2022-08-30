package com.blog.dao;

import com.blog.entity.Post;
import com.blog.entity.User;
import com.blog.util.ExceptionUtil;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

public class PostDAOTest {

    private final PostDAO postDAO = new PostDAO();


    @Test
    public void findAllPostList() {
        List<Post> listPost = postDAO.findAllPostList();

        listPost.forEach(p -> System.out.println(p.getTitle() + " , "));

        assertTrue(listPost.size() > 0);
    }

    @Test
    @DisplayName("POST Create Success")
    public void createPost_success() {
        //Given
        User user = new User();
        user.setId(89);

        Post post = new Post();
        post.setUser(user);
        post.setTitle("테스트 재 작성 중");
        post.setBody("테스트 재 작성 중");
        post.setCreatedAt(new Date());

        //When
        Post newPost = postDAO.create(post);
        //Then
        assertEquals(post, newPost);
        assertTrue(newPost != null && newPost.getId() > 0);
    }

    @Test
    @DisplayName("POST Update Success")
    public void updatePost_success() {
        //Given
        User user = new User();
        user.setId(89);

        Post post = new Post();
        post.setId(56);
        post.setUser(user);
        post.setTitle("테스트 재 작성 중");
        post.setBody("테스트 재 작성 중");
        post.setUpdatedAt(new Date());

        //When
        Post editPost = postDAO.update(post);

        //Then
        assertEquals(post.getId(), editPost.getId());
        assertEquals(post.getTitle(), editPost.getTitle());
    }

    @Test
    @DisplayName("findByPostId Success")
    public void findByPostId_Success() {
        Integer postId = 56;

        Post findById = postDAO.find(postId);

        assertNotNull(findById);
        assertEquals(postId, findById.getId());
    }

    @Test(expected = NullPointerException.class)
    @DisplayName("findByPostId Fail")
    public void findByPostId_Fail() {
        Integer postId = 99;

        Post findById = postDAO.find(postId);

        assertEquals(findById.getId(), postId);

    }

    @Test
    public void deletePostId_Success() {
        Post post = new Post();
        post.setId(55);
        post.setDeletedAt(new Date());

        Post deletePost = postDAO.deleteUpdate(post);

        assertNotNull(deletePost);
    }


}