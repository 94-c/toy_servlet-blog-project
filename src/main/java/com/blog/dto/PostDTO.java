package com.blog.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class PostDTO {

    private Integer id;
    private String title;
    private String body;
    private Integer userId;

}
