package com.blog.dto.comment;

import com.blog.data.entity.Comment;
import com.blog.data.entity.Post;
import com.blog.data.entity.User;
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

    public Comment toEntity() {
        User user = new User();
        user.setId(userId);

        Post post = new Post();
        post.setId(postId);

        Comment comment = new Comment();
        comment.setUser(user);
        comment.setPost(post);
        comment.setUserIp(userIp);
        comment.setBody(body);

        return comment;
    }
}
