package com.blog.controller;

import com.blog.data.dto.LikeDto;
import com.blog.data.entity.Like;
import com.blog.mapper.LikeMapper;
import com.blog.service.LikeService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CreateLikeController implements Controller{

    private final LikeService likeService;

    public CreateLikeController() {
        this.likeService = new LikeService();
    }

    @Override
    public String doGet(HttpServletRequest request, HttpServletResponse response) {
        return null;
    }

    @Override
    public String doPost(HttpServletRequest request, HttpServletResponse response) {
        LikeDto dto = LikeMapper.mapToCreateLikeDto(request);

        Like newLike = likeService.createLike(dto);

        request.setAttribute("target", "/post/edit.do?id=" + dto.getPostId());
        return "/WEB-INF/common/redirect.jsp";
    }
}
