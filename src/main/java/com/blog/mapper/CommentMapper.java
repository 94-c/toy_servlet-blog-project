package com.blog.mapper;

import com.blog.data.dto.CommentDto;
import com.blog.data.dto.ParentCommentDto;

import javax.servlet.http.HttpServletRequest;

public class CommentMapper {

    public static CommentDto mapToDeleteParentCommentDto(HttpServletRequest request) {
        return CommentDto.builder()
                .id(Integer.valueOf(request.getParameter("parentId")))
                .postId(Integer.valueOf(request.getParameter("postId")))
                .build();
    }
}
