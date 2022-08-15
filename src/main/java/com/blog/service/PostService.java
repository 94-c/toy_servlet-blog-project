package com.blog.service;

import com.blog.dao.PostDAO;
import com.blog.dto.PostDTO;
import com.blog.entity.Post;
import com.blog.entity.User;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class PostService {

    private final PostDAO postDAO = new PostDAO();

    private void addPostField(Post post, PostDTO dto) {
        User user = new User();
        user.setId(dto.getUserId());

        post.setTitle(dto.getTitle());
        post.setBody(dto.getBody());
        post.setUser(user);

    }

    public List<Post> findAllPost() {
        return postDAO.findAllCreateQuery();
    }


    public Post createPost(PostDTO dto) {
        Post newPost = new Post();
        addPostField(newPost, dto);
        postDAO.create(newPost);

        return newPost;
    }

    public boolean findByPostId(Integer id) {
        Post post = postDAO.find(Post.class, id);
        if (post == null) {
            return false;
        }
        return true;
    }

    public Post updatePost(PostDTO dto) throws Exception {
        Post post = postDAO.find(Post.class, dto.getId());
        if (post == null) {
            throw new Exception();
        }
        try {
            addPostField(post, dto);
            postDAO.update(post);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return post;
    }

    public boolean deletePost(PostDTO dto) {
        Post post = postDAO.find(Post.class, dto.getId());
        if (post == null) {
            return false;
        }
        try {
            addPostField(post, dto);
            postDAO.deleteUpdate(post);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

}
