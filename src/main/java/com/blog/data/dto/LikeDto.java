package com.blog.data.dto;

import com.blog.data.entity.Like;
import com.blog.data.entity.Post;
import com.blog.data.entity.User;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class LikeDto {

    private Integer id;
    private Integer postId;
    private Integer userId;
    private String type;

    public Like toCreateEntity() {
        Post post = new Post();
        post.setId(postId);

        User user = new User();
        user.setId(userId);

        Like like = new Like();
        like.setType(type);
        like.setPost(post);
        like.setUser(user);

        return like;
    }
}
