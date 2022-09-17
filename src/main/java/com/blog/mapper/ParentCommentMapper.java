package com.blog.mapper;

import com.blog.data.dto.ParentCommentDto;

import javax.servlet.http.HttpServletRequest;

public class ParentCommentMapper {
    public static ParentCommentDto mapToDeleteParentCommentDto(HttpServletRequest request) {
        return ParentCommentDto.builder()
                .id(Integer.valueOf(request.getParameter("parentId")))
                .postId(Integer.valueOf(request.getParameter("postId")))
                .build();
    }
}
