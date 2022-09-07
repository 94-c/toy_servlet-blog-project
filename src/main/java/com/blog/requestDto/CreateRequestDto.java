package com.blog.requestDto;

import com.blog.dto.LoginRequestDTO;
import com.blog.dto.comment.CreateRequestCommentDTO;
import com.blog.dto.comment.parenteComment.CreateRequestParentCommentDTO;
import com.blog.dto.email.EmailConfirmRequestDTO;
import com.blog.dto.post.CreateRequestPostDTO;
import com.blog.dto.user.CreateRequestUserDTO;
import com.blog.util.Md5Util;
import com.blog.util.UserIpUtil;

import javax.servlet.http.HttpServletRequest;

public class CreateRequestDto {

    public EmailConfirmRequestDTO toEmailConfirmDto(HttpServletRequest request) {
        return EmailConfirmRequestDTO.builder()
                .token(request.getParameter("token"))
                .userId(Integer.valueOf(request.getParameter("userId")))
                .build();
    }

    public CreateRequestPostDTO toPostDto(HttpServletRequest request) {
        return CreateRequestPostDTO.builder()
                .title(request.getParameter("title"))
                .body(request.getParameter("body"))
                .userId(Integer.valueOf(request.getParameter("userId")))
                .build();
    }

    public CreateRequestCommentDTO toCommentDto(HttpServletRequest request) {
        return CreateRequestCommentDTO.builder()
                .userId(Integer.valueOf(request.getParameter("userId")))
                .postId(Integer.valueOf(request.getParameter("postId")))
                .userIp(UserIpUtil.userIp())
                .body(request.getParameter("body"))
                .build();

    }

    public CreateRequestParentCommentDTO toParentCommentDto(HttpServletRequest request) {
        return CreateRequestParentCommentDTO.builder()
                .userId(Integer.valueOf(request.getParameter("userId")))
                .body(request.getParameter("parentBody"))
                .userIp(UserIpUtil.userIp())
                .parentsId(Integer.valueOf(request.getParameter("commentId")))
                .postId(Integer.valueOf(request.getParameter("postId")))
                .build();
    }

    public CreateRequestUserDTO toUserDto(HttpServletRequest request) {
        return CreateRequestUserDTO.builder()
                .email(request.getParameter("email"))
                .password(request.getParameter("password"))
                .name(request.getParameter("name"))
                .build();
    }

    public LoginRequestDTO toLoginDto(HttpServletRequest request) {
        return LoginRequestDTO.builder()
                .email(request.getParameter("email"))
                .password(Md5Util.md5(request.getParameter("password")))
                .build();
    }

}
