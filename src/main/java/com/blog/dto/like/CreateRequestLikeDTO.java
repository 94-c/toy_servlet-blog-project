package com.blog.dto.like;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateRequestLikeDTO {

    private Integer userId;
    private Integer postId;

}
