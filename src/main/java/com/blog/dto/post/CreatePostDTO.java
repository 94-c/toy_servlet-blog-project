package com.blog.dto.post;

import com.blog.entity.Post;
import com.blog.entity.User;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CreatePostDTO {

    private final String title;
    private final String body;
    private final Integer userId;

    public Post ToEntity() {
        User user = new User();
        user.setId(userId);

        Post post = new Post();
        post.setTitle(title);
        post.setBody(body);
        post.setUser(user);

        return post;
    }
}
