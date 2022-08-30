package com.blog.dto.comment.parenteComment;

import com.blog.entity.Comment;
import com.blog.entity.Post;
import com.blog.entity.User;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CreateRequestParentCommentDTO {

    private final String body;
    private final String userIp;
    private final Integer parentsId;
    private final Integer userId;

    private final Integer postId;

    public Comment ToParentCommentEntity() {
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
}
