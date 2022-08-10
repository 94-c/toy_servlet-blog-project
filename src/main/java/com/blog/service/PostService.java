package com.blog.service;

import com.blog.dao.PostDAO;
import com.blog.dto.PostDTO;
import com.blog.entity.Post;
import com.blog.entity.User;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

public class PostService {

    private final HttpServletRequest request;
    private final PostDAO postDAO = new PostDAO();

    public PostService(HttpServletRequest request) {
        this.request = request;
    }

    private void addPostField(Post post, PostDTO dto) {
        User user = new User();
        user.setId(dto.getUserId());

        post.setId(dto.getId());
        post.setTitle(dto.getTitle());
        post.setBody(dto.getBody());
        post.setUser(user);

    }

    public void findAllPost() {
        List<Post> postList = postDAO.findAllCreateQuery();
        request.setAttribute("postList", postList);
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
        request.setAttribute("posts", post);
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
