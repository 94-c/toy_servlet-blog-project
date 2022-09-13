package com.blog.controller.like;

import com.blog.controller.Controller;
import com.blog.dto.like.CreateRequestLikeDTO;
import com.blog.requestDto.CreateRequestDto;
import com.blog.service.LikeService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CreateProcLikeController implements Controller {
    private static final String METHOD = "POST";

    private final LikeService likeService;

    public CreateProcLikeController() {
        this.likeService = new LikeService();
    }

    @Override
    public String getMethod() {
        return CreateProcLikeController.METHOD;
    }

    @Override
    public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
        CreateRequestLikeDTO dto = new CreateRequestDto().toLikeDto(request);

        try {
            likeService.createLike(dto);
            request.setAttribute("message", "게시물을 좋아요");
            return "/WEB-INF/common/redirect.jsp";
        }catch (Exception e) {
            e.printStackTrace();
            return "/WEB-INF/common/redirect.jsp";
        }

    }
}
