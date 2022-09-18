package com.blog.mapper;

import com.blog.data.dto.UserDto;
import com.blog.util.Md5Util;

import javax.servlet.http.HttpServletRequest;

public class UserMapper {

    public static UserDto mapToLogin(HttpServletRequest request) {
        return UserDto.builder()
                .email(request.getParameter("email"))
                .password(Md5Util.md5(request.getParameter("password")))
                .build();
    }
    public static UserDto mapToCreateUser(HttpServletRequest request) {
        return UserDto.builder()
                .email(request.getParameter("email"))
                .password(request.getParameter("password"))
                .build();
    }

    public static UserDto mapToEditUser(HttpServletRequest request) {
        return UserDto.builder()
                .id(Integer.valueOf(request.getParameter("id")))
                .email(request.getParameter("email"))
                .password(request.getParameter("password"))
                .build();
    }
}
