package com.blog.dto.post;

import com.blog.entity.Post;
import com.blog.entity.User;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class EditResponsePostDTO {

    private final Integer id;

    public Post ToEntity() {
        Post post = new Post();
        post.setId(id);

        return post;
    }
}
