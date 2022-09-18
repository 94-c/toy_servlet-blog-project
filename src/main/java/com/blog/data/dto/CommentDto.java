package com.blog.data.dto;

import com.blog.data.entity.Comment;
import com.blog.data.entity.Post;
import com.blog.data.entity.User;
import com.blog.util.UserIpUtil;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CommentDto {
    private final Integer id;
    private final Integer userId;
    private final Integer postId;
    private final String body;
    private final String userIp;

    private final Integer parentsId;

    public Comment toCreateEntity() {
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

    public Comment toEditEntity(Comment comment) {
        User user = new User();
        user.setId(userId);

        Post post = new Post();
        post.setId(postId);

        comment.setId(id);
        comment.setUser(user);
        comment.setPost(post);
        comment.setUserIp(UserIpUtil.userIp());

        return comment;
    }



}
