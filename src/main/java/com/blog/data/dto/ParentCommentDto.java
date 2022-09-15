package com.blog.data.dto;

import com.blog.data.entity.Comment;
import com.blog.data.entity.Post;
import com.blog.data.entity.User;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ParentCommentDto {

    private final Integer id;
    private final String body;
    private final String userIp;
    private final Integer parentsId;
    private final Integer userId;
    private final Integer postId;

    public Comment toParentCommentCreateEntity() {
        User user = new User();
        user.setId(userId);

        Post post = new Post();
        post.setId(postId);

        Comment parentComment = new Comment();
        parentComment.setPost(post);
        parentComment.setUser(user);
        parentComment.setBody(body);
        parentComment.setUserIp(userIp);
        parentComment.setParentsId(parentsId);

        return parentComment;
    }

    public Comment toParentCommentEditEntity(Comment parentComment) {
        User user = new User();
        user.setId(userId);

        Post post = new Post();
        post.setId(postId);

        parentComment.setId(id);
        parentComment.setPost(post);
        parentComment.setUser(user);
        parentComment.setBody(body);
        parentComment.setUserIp(userIp);
        if (parentsId != null) {
            parentComment.setParentsId(parentsId);
        }

        return parentComment;
    }
}
