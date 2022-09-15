package com.blog.mapper;

import com.blog.data.dto.EmailConfirmDto;

import javax.servlet.http.HttpServletRequest;

public class EmailConfirmMapper {

    public static EmailConfirmDto mapToEmailConfirmDto(HttpServletRequest request) {
        return EmailConfirmDto.builder()
                .token(request.getParameter("token"))
                .userId(Integer.valueOf(request.getParameter("userId")))
                .build();
    }



}
