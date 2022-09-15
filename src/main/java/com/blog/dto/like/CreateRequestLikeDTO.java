package com.blog.dto.like;

import com.blog.data.entity.Like;
import com.blog.data.entity.Post;
import com.blog.data.entity.User;
import lombok.*;

@Getter
@Setter
@Builder
public class CreateRequestLikeDTO {

    private final Integer userId;
    private final Integer postId;
    private final Integer type;

    public Like toEntity() {
        User user = new User();
        user.setId(userId);

        Post post = new Post();
        post.setId(postId);

        Like like = new Like();
        like.setUser(user);
        like.setPost(post);
        like.setType(type);

        return like;
    }

}
