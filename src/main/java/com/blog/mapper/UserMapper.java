package com.blog.mapper;

import com.blog.data.dto.UserDto;

import javax.servlet.http.HttpServletRequest;

public class UserMapper {

    public static UserDto mapToCreateUser(HttpServletRequest request) {
        return UserDto.builder()
                .email(request.getParameter("email"))
                .password(request.getParameter("password"))
                .build();
    }
}
