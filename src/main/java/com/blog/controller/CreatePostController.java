package com.blog.controller;

import com.blog.controller.Controller;
import com.blog.data.entity.Post;
import com.blog.dto.post.CreateRequestPostDTO;
import com.blog.requestDto.CreateRequestDto;
import com.blog.service.PostService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CreatePostController implements Controller {
    private final PostService postService;

    public CreatePostController() {
        this.postService = new PostService();
    }
    @Override
    public String doGet(HttpServletRequest request, HttpServletResponse response) {
        return "/WEB-INF/views/post.jsp";
    }

    @Override
    public String doPost(HttpServletRequest request, HttpServletResponse response) {
        CreateRequestPostDTO dto = new CreateRequestDto().toPostDto(request);
        Post result = postService.createPost(dto);

        if (result == null) {
            request.setAttribute("message", "게시글이 작성 실패하였습니다.");
            request.setAttribute("target", "/main.do");
            return "/WEB-INF/common/redirect.jsp";
        }

        request.setAttribute("message", "게시글이 작성이 되었습니다.");
        request.setAttribute("target", "/main.do");
        return "/WEB-INF/common/redirect.jsp";

    }
}
