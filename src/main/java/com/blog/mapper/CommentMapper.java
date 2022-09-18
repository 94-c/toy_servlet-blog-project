package com.blog.mapper;

import com.blog.data.dto.CommentDto;
import com.blog.data.dto.ParentCommentDto;
import com.blog.util.UserIpUtil;
import com.sun.deploy.net.HttpRequest;

import javax.servlet.http.HttpServletRequest;

public class CommentMapper {

    public static CommentDto mapToCreateCommentDto(HttpServletRequest request) {
        return CommentDto.builder()
                .userId(Integer.valueOf(request.getParameter("userId")))
                .postId(Integer.valueOf(request.getParameter("postId")))
                .userIp(request.getParameter("userIp"))
                .body(request.getParameter("body"))
                .build();
    }

    public static CommentDto mapToEditCommentDto(HttpServletRequest request) {
        return CommentDto.builder()
                .id(Integer.valueOf(request.getParameter("commentId")))
                .userId(Integer.valueOf(request.getParameter("userId")))
                .postId(Integer.valueOf(request.getParameter("postId")))
                .body(request.getParameter("body"))
                .build();
    }

    public static CommentDto mapToDeleteCommentDto(HttpServletRequest request) {
        return CommentDto.builder()
                .id(Integer.valueOf(request.getParameter("parentId")))
                .postId(Integer.valueOf(request.getParameter("postId")))
                .build();
    }
}
