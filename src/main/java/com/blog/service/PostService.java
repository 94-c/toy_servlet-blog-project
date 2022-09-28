package com.blog.service;

import com.blog.data.dao.*;
import com.blog.data.dto.PostDto;
import com.blog.data.entity.Like;
import com.blog.data.entity.Tag;
import com.blog.data.entity.Comment;
import com.blog.data.entity.Post;
import com.blog.service.exception.PostServiceException;
import lombok.RequiredArgsConstructor;
import org.apache.log4j.Level;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class PostService {

    private final PostDAO postDAO = new PostDAO();
    private final CommentDAO commentDAO = new CommentDAO();
    private final LikeDAO likeDAO = new LikeDAO();

    public List<Post> findAllPost() {
        return postDAO.findAllPostList();
    }


    public Post createPost(PostDto dto) throws PostServiceException {
        Post post = dto.toCreateEntity();
        Post newPost = postDAO.create(post);
        if (newPost == null) {
            throw new PostServiceException("Create Post Error", Level.ERROR);
        }
        return newPost;
    }


    public PostDto findByPostId(Integer id) throws PostServiceException {
        Post findById = postDAO.find(id);
        if (findById == null) {
            throw new PostServiceException("findByPostId Error", Level.ERROR);
        }

        List<Comment> mergeComments = new ArrayList<>();
        List<Comment> comments = commentDAO.findAllCommentByPostId(id);
        comments.forEach(comment -> {
            mergeComments.add(comment);
            // find child comment and add comments
            List<Comment> childComment = commentDAO.findAllParentCommentList(comment.getId());
            if (childComment.size() > 0) {
                mergeComments.addAll(childComment);
            }
        });
        long likeCount = likeDAO.count(findById.getId());

        return PostDto.builder()
                .post(findById)
                .commentList(mergeComments)
                .postByLike(likeCount)
                .build();
    }

    public Post updatePost(PostDto dto) throws PostServiceException {
        Post findById = postDAO.find(dto.getId());
        if (findById == null) {
            throw new PostServiceException("findByPostId Error", Level.ERROR);
        }
        Post updatePostDto = dto.toEditEntity(findById);
        Post updatePost = postDAO.update(updatePostDto);
        if (updatePost == null) {
            throw new PostServiceException("updatePost Error", Level.ERROR);
        }
        return updatePost;
    }


    /*public boolean deletePost(PostDTO dto) {
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
    }*/

}
