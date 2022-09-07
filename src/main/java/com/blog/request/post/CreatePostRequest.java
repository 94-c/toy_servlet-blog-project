package com.blog.request.post;

import com.blog.dto.post.CreateRequestPostDTO;

import javax.servlet.http.HttpServletRequest;

public class CreatePostRequest {

    public CreateRequestPostDTO toDto(HttpServletRequest request) {
        return CreateRequestPostDTO.builder()
                .title(request.getParameter("title"))
                .body(request.getParameter("body"))
                .userId(Integer.valueOf(request.getParameter("userId")))
                .build();
    }
}
