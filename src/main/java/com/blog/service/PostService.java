package com.blog.service;

import com.blog.dao.PostDAO;
import com.blog.dto.PostDTO;
import com.blog.entity.Post;
import com.blog.entity.User;
import lombok.RequiredArgsConstructor;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

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

    public void findAllPost(){
        List<Post> postList = postDAO.findAllCreateQuery();
        request.setAttribute("postList", postList);
    }

    public boolean createPost(PostDTO dto) {
        Post post = new Post();
        try {
            postField(post, dto);
            postDAO.create(post);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean findByPostId(Integer id) {
        Post post = postDAO.find(Post.class, id);
        if (post != null) {
            return true;
        }
        return false;
    }

    public boolean updatePost(PostDTO dto) {
        Post post = postDAO.find(Post.class, dto.getId());
        if (post == null) {
            return false;
        }
        try {
            postField(post, dto);
            postDAO.update(post);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }
}
