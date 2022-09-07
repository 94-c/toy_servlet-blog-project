package com.blog.requestDto;

import com.blog.dto.comment.EditRequestCommentDTO;
import com.blog.dto.comment.parenteComment.EditRequestParentCommentDTO;
import com.blog.dto.post.EditRequestPostDTO;
import com.blog.dto.user.EditRequestUserDTO;
import com.blog.util.UserIpUtil;

import javax.servlet.http.HttpServletRequest;

public class EditRequestDto {

    public EditRequestUserDTO toUserDto(HttpServletRequest request) {
        return EditRequestUserDTO.builder()
                .id(Integer.valueOf(request.getParameter("id")))
                .email(request.getParameter("email"))
                .name(request.getParameter("name"))
                .password(request.getParameter("password"))
                .state(Integer.valueOf(request.getParameter("state")))
                .build();
    }


    public EditRequestPostDTO toPostDto(HttpServletRequest request) {
        return EditRequestPostDTO.builder()
                .id(Integer.valueOf(request.getParameter("id")))
                .userId(Integer.valueOf(request.getParameter("userId")))
                .title(request.getParameter("title"))
                .body(request.getParameter("body"))
                .build();
    }

    public EditRequestCommentDTO toCommentDto(HttpServletRequest request) {
        return EditRequestCommentDTO.builder()
                .id(Integer.valueOf(request.getParameter("commentId")))
                .userId(Integer.valueOf(request.getParameter("userId")))
                .postId(Integer.valueOf(request.getParameter("postId")))
                .body(request.getParameter("body"))
                .build();
    }

    public EditRequestParentCommentDTO toParentDto(HttpServletRequest request) {
        return EditRequestParentCommentDTO.builder()
                .id(Integer.valueOf(request.getParameter("id")))
                .userId(Integer.valueOf(request.getParameter("userId")))
                .body(request.getParameter("parentBody"))
                .userIp(UserIpUtil.userIp())
                .parentsId(Integer.valueOf(request.getParameter("commentId")))
                .postId(Integer.valueOf(request.getParameter("postId")))
                .build();
    }
}
