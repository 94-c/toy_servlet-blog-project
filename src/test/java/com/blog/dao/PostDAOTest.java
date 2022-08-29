package com.blog.dao;

import com.blog.entity.Post;
import com.blog.entity.User;
import javafx.geometry.Pos;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class PostDAOTest {

    private final PostDAO postDAO = new PostDAO();
    private final UserDAO userDAO = new UserDAO();

    @Test
    public void createPostSuccess() {
        User user = new User();
        user.setId(1);

        Post post = new Post();
        post.setTitle("게시물 작성 진행 중");
        post.setBody("테스트 코드 작성");
        post.setUser(user);

        Post result = postDAO.create(post);

        assertEquals(post, result);
        assertEquals(Post.class, result.getClass());
    }


    @Test(expected = Exception.class)
    public void createPostFail() {
        User user = new User();
        user.setId(99);

        User userFindById = userDAO.find(user.getId());

        if (userFindById == null) {
            System.out.println("로그인 불가");
        }
        Post post = new Post();
        post.setTitle("게시물 작성 진행 중");
        post.setBody("테스트 코드 작성");
        post.setUser(user);

        Post result = postDAO.create(post);

        assertEquals(result, post);
    }

    @Test
    public void findByIdSuccess() {
        Integer id = 1;
        Post result = postDAO.find(id);

        assertEquals(result.getId(), id);
    }

    @Test(expected = Exception.class)
    public void findByIdFail() {
        Integer id = 100;
        Post result = postDAO.find(id);

        assertEquals(result.getId(), id);
    }

    @Test
    public void updatePostSuccess() {
        Post post = new Post();
        post.setId(1);
        post.setTitle("수정 중");
        post.setBody("수정 중");

        Post result = postDAO.update(post);
    }

    @Test
    public void updatePostFail() {
        User user = new User();
        user.setId(89);

        Post post = new Post();
        post.setId(1);
        post.setTitle("수정 중");
        post.setBody("수정 중");
        post.setUser(user);

        Post result = postDAO.update(post);

        assertNotEquals(result, post);
    }

    @Test
    public void findAllCreateQuery() {

        List<Post> findAllPostList = postDAO.findAllPostList();

        assertNotNull(findAllPostList);

        System.out.println(Arrays.toString(findAllPostList.toArray()));
    }

}