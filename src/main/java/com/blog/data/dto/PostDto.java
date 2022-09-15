package com.blog.data.dto;

import com.blog.data.entity.Post;
import com.blog.data.entity.User;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class PostDto {

    private final Integer id;
    private final String title;
    private final String body;
    private final Integer userId;

    public Post toCreateEntity() {
        User user = new User();
        user.setId(userId);

        Post post = new Post();
        post.setTitle(title);
        post.setBody(body);
        post.setUser(user);

        return post;
    }

    public Post toEditEntity(Post post) {
        User user = new User();
        user.setId(userId);

        post.setTitle(title);
        post.setBody(body);
        post.setUser(user);

        return post;
    }
}
