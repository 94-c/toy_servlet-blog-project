package com.blog.mapper;

import com.blog.data.dto.LikeDto;
import com.blog.data.entity.Like;

import javax.servlet.http.HttpServletRequest;

public class LikeMapper {

    public static LikeDto mapToCreateLikeDto(HttpServletRequest request) {
        return LikeDto.builder()
                .userId(Integer.valueOf(request.getParameter("userId")))
                .postId(Integer.valueOf(request.getParameter("postId")))
                .build();
    }
}
