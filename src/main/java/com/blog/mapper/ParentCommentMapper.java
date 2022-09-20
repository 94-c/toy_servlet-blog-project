package com.blog.mapper;

import com.blog.data.dto.CommentDto;
import com.blog.data.dto.ParentCommentDto;
import com.blog.util.UserIpUtil;

import javax.servlet.http.HttpServletRequest;

public class ParentCommentMapper {

    public static ParentCommentDto mapToCreateCommentDto(HttpServletRequest request) {
        return ParentCommentDto.builder()
                .userId(Integer.valueOf(request.getParameter("userId")))
                .body(request.getParameter("parentBody"))
                .userIp(UserIpUtil.userIp(request.getParameter("userIp")))
                .parentsId(Integer.valueOf(request.getParameter("commentId")))
                .postId(Integer.valueOf(request.getParameter("postId")))
                .build();
    }

    public static ParentCommentDto mapToEditCommentDto(HttpServletRequest request) {
        return ParentCommentDto.builder()
                .id(Integer.valueOf(request.getParameter("parentId")))
                .userId(Integer.valueOf(request.getParameter("userId")))
                .body(request.getParameter("parentBody"))
                .userIp(UserIpUtil.userIp(request.getParameter("userIp")))
                .parentsId(Integer.valueOf(request.getParameter("commentId")))
                .postId(Integer.valueOf(request.getParameter("postId")))
                .build();
    }

}
