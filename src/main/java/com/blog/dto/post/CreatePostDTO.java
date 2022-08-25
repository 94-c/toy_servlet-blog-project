package com.blog.dto.post;

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

}
