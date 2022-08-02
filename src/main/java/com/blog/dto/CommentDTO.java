package com.blog.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class CommentDTO {

    private Integer id;
    private Integer userId;
    private Integer postId;
    private String body;
    private String userIp;
    private Integer parentsCommentId;
    private Integer deleteState;

}
