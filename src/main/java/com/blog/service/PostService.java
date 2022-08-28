package com.blog.service;

import com.blog.dao.CommentDAO;
import com.blog.dao.PostDAO;
import com.blog.dto.PostDTO;
import com.blog.dto.post.CreateRequestPostDTO;
import com.blog.dto.post.EditRequestPostDTO;
import com.blog.entity.Comment;
import com.blog.entity.Post;
import com.blog.entity.User;
import com.blog.service.mapper.PostEditDTO;
import com.blog.util.ExceptionUtil;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;
@RequiredArgsConstructor
public class PostService {

    private final PostDAO postDAO = new PostDAO();
    private final CommentDAO commentDAO = new CommentDAO();
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


    public Post createPost(CreateRequestPostDTO dto) throws Exception {
        Post newPost = dto.ToEntity();
        Post result = postDAO.create(newPost);
        if (result == null) {
            throw new ExceptionUtil("Create Error");
        }
        return newPost;
    }

    public Optional<Post> createOptionalPost(PostDTO dto) {
        Post newPost = new Post();
        addPostField(newPost, dto);
        postDAO.create(newPost);
        return Optional.of(newPost);
    }

    public PostEditDTO findByPostId(Integer id) {
        Post findById = postDAO.find(id);
        if (findById == null) {
            throw new ExceptionUtil("findByPostId Error");
        }
        List<Comment> comment = commentDAO.findAllCommentByPostId(id);

        return PostEditDTO.builder()
                .post(findById)
                .commentList(comment)
                .build();

    }


    public Post updatePost(EditRequestPostDTO dto) throws Exception {
        Post findById = postDAO.find(dto.getId());
        if (findById == null) {
            throw new ExceptionUtil("findByPostId Error");
        }
        Post updatePost = postDAO.update(findById);
        if (updatePost == null) {
            throw new ExceptionUtil("updatePost Error");
        }
        return findById;
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
