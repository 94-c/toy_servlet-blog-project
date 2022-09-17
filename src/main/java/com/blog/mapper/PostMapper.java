package com.blog.mapper;

import com.blog.data.dto.PostDto;
import com.blog.data.entity.Comment;
import com.blog.data.entity.Post;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class PostMapper {

    public static PostDto mapToCreatePostDto(HttpServletRequest request) {
        return PostDto.builder()
                .title(request.getParameter("title"))
                .body(request.getParameter("body"))
                .userId(Integer.valueOf(request.getParameter("userId")))
                .build();
    }

    public static PostDto mapToEditPostDto(HttpServletRequest request) {
        return PostDto.builder()
                .id(Integer.valueOf(request.getParameter("id")))
                .title(request.getParameter("title"))
                .body(request.getParameter("body"))
                .userId(Integer.valueOf(request.getParameter("userId")))
                .build();
    }


}
