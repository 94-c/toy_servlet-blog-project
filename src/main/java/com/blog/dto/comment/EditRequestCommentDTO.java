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
public class EditRequestCommentDTO {

    private final Integer id;
    private final Integer userId;
    private final Integer postId;
    private final String body;
    private final String userIp;


    public Comment toEntity(Comment comment) {
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
