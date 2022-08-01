package com.blog.service;

import com.blog.dao.PostDAO;
import com.blog.dto.PostDTO;
import com.blog.entity.Post;
import com.blog.entity.User;
import com.blog.util.HibernateUtil;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.Date;
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
        Post post = new Post();
        try {
            PostDTO dto = new PostDTO();
            dto.setTitle("오케이");
            dto.setBody("오케이");

            User user = new User();
            user.setId(18);

            post.setTitle(dto.getTitle());
            post.setBody(dto.getBody());
            post.setUser(user);
            post.setCreatedAt(new Date());

            Post result = postDAO.create(post);

            assertEquals(post, result);

            System.out.println(result.toString());
            System.out.println(post.hashCode());
            System.out.println(result.hashCode());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void findByPostId() {
        Integer id = 6;
        try {
            PostDTO dto = new PostDTO();
            dto.setId(id);

            Post result = postDAO.find(Post.class, dto.getId());
            assertNotNull(result);

            System.out.println(result.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void updatePost() {
        Integer postId = 6;
        Post post = postDAO.find(Post.class, postId);
        if (post == null) {
            return;
        }
        try {
            PostDTO dto = new PostDTO();
            dto.setId(post.getId());
            dto.setTitle("수정완료");
            dto.setBody("오케이");

            User user = new User();
            user.setId(18);

            post.setId(dto.getId());
            post.setTitle(dto.getTitle());
            post.setBody(dto.getBody());
            post.setUser(user);
            post.setUpdatedAt(new Date());

            Post result = postDAO.update(post);

            assertEquals(post, result);

            System.out.println(result.toString());
            System.out.println(post.hashCode());
            System.out.println(result.hashCode());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void deletePost() {
        Integer postId = 6;
        Post post = postDAO.find(Post.class, postId);
        if (post == null) {
            return;
        }
        try {
            PostDTO dto = new PostDTO();
            dto.setId(post.getId());

            post.setId(dto.getId());
            post.setDeletedAt(new Date());

            Post result = postDAO.update(post);

            assertEquals(post, result);

            System.out.println(result.toString());
            System.out.println(post.hashCode());
            System.out.println(result.hashCode());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}