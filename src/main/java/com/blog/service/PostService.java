package com.blog.service;

import com.blog.dao.PostDAO;
import com.blog.dto.PostDTO;
import com.blog.entity.Post;
import com.blog.entity.User;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class PostService {

    private final HttpServletRequest request;
    private final PostDAO postDAO = new PostDAO();

    public PostService(HttpServletRequest request) {
        this.request = request;
    }

    private void postField(Post post, PostDTO dto) {
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


    public Post createPost(PostDTO dto) throws Exception{
        Post post = new Post();
        try {
            postField(post, dto);
            postDAO.create(post);
            return post;
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception();
        }
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
            postField(post, dto);
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
            postField(post, dto);
            postDAO.deleteUpdate(post);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

}
