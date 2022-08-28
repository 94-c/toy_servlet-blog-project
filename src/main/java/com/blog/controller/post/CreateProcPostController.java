package com.blog.controller.post;

import com.blog.controller.Controller;
import com.blog.dto.post.CreateRequestPostDTO;
import com.blog.entity.Post;
import com.blog.service.PostService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CreateProcPostController implements Controller {

    private static final String METHOD = "POST";

    @Override
    public String getMethod() {
        return CreateProcPostController.METHOD;
    }

    private CreateRequestPostDTO makeDTO(HttpServletRequest request) {

        return CreateRequestPostDTO.builder()
                .title(request.getParameter("title"))
                .body(request.getParameter("body"))
                .userId(Integer.valueOf(request.getParameter("userId")))
                .build();

    }

    @Override
    public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {

        CreateRequestPostDTO dto = makeDTO(request);

        PostService postService = new PostService();

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
