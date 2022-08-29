package com.blog.controller.post;

import com.blog.controller.Controller;
import com.blog.service.PostService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteProcPostController implements Controller {

    private static final String METHOD = "GET";

    @Override
    public String getMethod() {
        return DeleteProcPostController.METHOD;
    }

    private PostDTO makeDTO (HttpServletRequest request) {
        PostDTO postDTO = new PostDTO();
        postDTO.setId(Integer.valueOf(request.getParameter("id")));

        return postDTO;
    }

    @Override
    public String process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PostDTO dto = makeDTO(request);
        PostService postService = new PostService();

        boolean result = postService.deletePost(dto);

        if (result) {
            request.setAttribute("message", "게시글 삭제가 완료되었습니다.");
            request.setAttribute("target", "/main.do");
            return "/WEB-INF/common/redirect.jsp";
        }

        request.setAttribute("message", "게시글 삭제가 실패하였습니다.");
        request.setAttribute("target", "/main.do");
        return "/WEB-INF/common/redirect.jsp";

    }
}
