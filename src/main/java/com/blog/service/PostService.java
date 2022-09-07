package com.blog.service;

import com.blog.dao.CommentDAO;
import com.blog.dao.PostDAO;
import com.blog.dao.TagDAO;
import com.blog.dto.post.CreateRequestPostDTO;
import com.blog.dto.post.EditRequestPostDTO;
import com.blog.dto.post.EditResponsePostEditDto;
import com.blog.dto.tag.CreateRequestTagDTO;
import com.blog.entity.Comment;
import com.blog.entity.Post;
import com.blog.entity.Tag;
import com.blog.log.Log;
import com.blog.util.ExceptionUtil;
import lombok.RequiredArgsConstructor;
import org.apache.log4j.Level;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class PostService {

    private final PostDAO postDAO = new PostDAO();
    private final CommentDAO commentDAO = new CommentDAO();


    public List<Post> findAllPost() {
        return postDAO.findAllPostList();
    }


    public Post createPost(CreateRequestPostDTO dto) throws ExceptionUtil {
        Post newPost = dto.ToEntity();
        Post result = postDAO.create(newPost);
        if (result == null) {
            throw new ExceptionUtil("Create Post Error", Level.ERROR);
        }
        return newPost;
    }

    public EditResponsePostEditDto findByPostId(Integer id) throws ExceptionUtil {
        Post findById = postDAO.find(id);
        if (findById == null) {
            throw new ExceptionUtil("findByPostId Error", Level.ERROR);
        }
        List<Comment> comment = commentDAO.findAllCommentByPostId(id);

        if (comment.size() > 0) {
            Integer commentId = comment.get(0).getId();
            if (commentId != null){
                List<Comment> parentComment = commentDAO.findAllParentCommentList(commentId);
                return EditResponsePostEditDto.builder()
                        .post(findById)
                        .commentList(comment)
                        .parentCommentList(parentComment)
                        .build();
            }
        }
        return EditResponsePostEditDto.builder()
                .post(findById)
                .commentList(comment)
                .build();
    }

    public Post updatePost(EditRequestPostDTO dto) throws ExceptionUtil {
        Post findById = postDAO.find(dto.getId());
        if (findById == null) {
            throw new ExceptionUtil("findByPostId Error", Level.ERROR);
        }
        Post updatePostDto = dto.ToEntity(findById);
        Post updatePost = postDAO.update(updatePostDto);
        if (updatePost == null) {
            throw new ExceptionUtil("updatePost Error", Level.ERROR);
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
