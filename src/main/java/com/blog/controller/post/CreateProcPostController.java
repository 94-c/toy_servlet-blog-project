package com.blog.controller.post;

import com.blog.controller.Controller;
import com.blog.dto.post.CreateRequestPostDTO;
import com.blog.entity.Post;
import com.blog.log.Log;
import com.blog.request.post.CreatePostRequest;
import com.blog.service.PostService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CreateProcPostController implements Controller {
    private static final String METHOD = "POST";
    private final PostService postService;

    public CreateProcPostController() {
        this.postService = new PostService();
    }

    @Override
    public String getMethod() {
        return CreateProcPostController.METHOD;
    }

    @Override
    public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
        CreateRequestPostDTO dto = new CreatePostRequest().toDto(request);
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
