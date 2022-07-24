package com.blog.service;

import com.blog.dao.PostDAO;
import com.blog.dto.PostDTO;
import com.blog.entity.Post;
import com.blog.entity.User;
import lombok.RequiredArgsConstructor;

import javax.servlet.http.HttpServletRequest;

@RequiredArgsConstructor
public class PostService {

    private final HttpServletRequest request;
    private static final PostDAO postDAO = new PostDAO();

    private void postField(Post post, PostDTO dto) {
        User user = new User();
        user.setId(dto.getUserId());

        post.setId(dto.getId());
        post.setTitle(dto.getTitle());
        post.setBody(dto.getBody());
        post.setUser(user);

    }

    public Post createPost(PostDTO dto) {
        Post post = new Post();
        try {
            postField(post, dto);
            postDAO.create(post);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return post;
    }
}
