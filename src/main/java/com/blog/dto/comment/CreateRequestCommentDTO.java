package com.blog.dto.comment;

import com.blog.entity.Comment;
import com.blog.entity.Post;
import com.blog.entity.User;
import com.blog.util.UserIpUtil;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CreateRequestCommentDTO {

    private final Integer userId;
    private final Integer postId;
    private final String body;
    private final String userIp;
    private final Integer cDepth;
    private final Integer cGroup;
    private final Integer deleteState;

    public Comment ToEntity() {
        User user = new User();
        user.setId(userId);

        Post post = new Post();
        post.setId(postId);

        Comment comment = new Comment();
        comment.setUser(user);
        comment.setPost(post);
        comment.setUserIp(userIp);
        comment.setCDepth(cDepth);
        comment.setCGroup(cGroup);

        return comment;
    }
}
