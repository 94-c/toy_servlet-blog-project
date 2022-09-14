package com.blog.dto.post;

import com.blog.entity.Post;
import com.blog.entity.User;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class EditRequestPostDTO {

    private final Integer id;

    private final String title;
    private final String body;
    private final Integer userId;

    public Post toEntity(Post post) {
        User user = new User();
        user.setId(userId);
        
        post.setTitle(title);
        post.setBody(body);
        post.setUser(user);

        return post;
    }
}
