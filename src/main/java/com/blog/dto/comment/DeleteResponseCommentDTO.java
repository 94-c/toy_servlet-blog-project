package com.blog.dto.comment;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class DeleteResponseCommentDTO {

    private final Integer id;
    private final Integer postId;

}
