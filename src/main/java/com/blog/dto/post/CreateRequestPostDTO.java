package com.blog.dto.post;

import com.blog.entity.Post;
import com.blog.entity.PostTag;
import com.blog.entity.Tag;
import com.blog.entity.User;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CreateRequestPostDTO {

    private final String title;
    private final String body;
    private final Integer userId;

    private final String tagName;

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
