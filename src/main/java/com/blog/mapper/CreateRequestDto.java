package com.blog.mapper;

import com.blog.data.dto.EmailConfirmDto;
import com.blog.util.Md5Util;
import com.blog.util.UserIpUtil;

import javax.servlet.http.HttpServletRequest;

public class CreateRequestDto {

    public EmailConfirmDto toEmailConfirmDto(HttpServletRequest request) {
        return EmailConfirmDto.builder()
                .token(request.getParameter("token"))
                .userId(Integer.valueOf(request.getParameter("userId")))
                .build();
    }



}
