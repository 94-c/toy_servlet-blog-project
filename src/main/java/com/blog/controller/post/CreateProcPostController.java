package com.blog.controller.post;

import com.blog.controller.Controller;
import com.blog.dto.PostDTO;
import com.blog.dto.post.CreatePostDTO;
import com.blog.entity.Post;
import com.blog.service.PostService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

public class CreateProcPostController implements Controller {

    private static final String METHOD = "POST";

    @Override
    public String getMethod() {
        return CreateProcPostController.METHOD;
    }

    private CreatePostDTO makeDTO(HttpServletRequest request) {

        return CreatePostDTO.builder()
                .title(request.getParameter("title"))
                .body(request.getParameter("body"))
                .userId(Integer.valueOf(request.getParameter("userId")))
                .build();

    }

    @Override
    public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {

        CreatePostDTO dto = makeDTO(request);

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
