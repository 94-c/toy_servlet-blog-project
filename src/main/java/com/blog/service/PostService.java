package com.blog.service;

import com.blog.dao.PostDAO;
import com.blog.dto.PostDTO;
import com.blog.dto.post.CreatePostDTO;
import com.blog.entity.Post;
import com.blog.entity.User;
import com.blog.util.ExceptionUtil;

import java.util.List;
import java.util.Optional;

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


    public Post createPost(CreatePostDTO dto) {
        Post newPost = new Post();
        addPostField(newPost, dto);
        postDAO.create(newPost);
        return newPost;
    }

    public Optional<Post> createOptionalPost(PostDTO dto) {
        Post newPost = new Post();
        addPostField(newPost, dto);
        postDAO.create(newPost);
        return Optional.of(newPost);
    }

    public Post findByPostId(Integer id) {
        return postDAO.find(Post.class, id);
    }

    public Post updatePost(PostDTO dto) throws Exception {
        Post post = postDAO.find(Post.class, dto.getId());
        if (post == null) {
            throw new ExceptionUtil("updatePost Error");
        }
        addPostField(post, dto);
        postDAO.update(post);
        return post;
    }

    public Optional<Post> updateOptionalPost(PostDTO dto) throws Exception {
        Post post = postDAO.find(Post.class, dto.getId());
        if (post == null) {
            throw new ExceptionUtil("Error Update Post");
        }
        addPostField(post, dto);
        postDAO.update(post);
        return Optional.of(post);
    }

    public boolean deletePost(PostDTO dto) {
        Post post = postDAO.find(dto.getId());
        if (post == null) {
            return false;
        }
        try {
            addPostField(post, dto);
            postDAO.deleteUpdate(post);
        } catch (ExceptionUtil e) {
            throw new ExceptionUtil("Error delete Post");
        }
        return true;
    }

}
