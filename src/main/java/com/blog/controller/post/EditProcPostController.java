package com.blog.controller.post;

import com.blog.controller.Controller;
import com.blog.dto.PostDTO;
import com.blog.entity.Post;
import com.blog.service.PostService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

public class EditProcPostController implements Controller {

    private static final String METHOD = "POST";

    @Override
    public String getMethod() {
        return EditProcPostController.METHOD;
    }

    private PostDTO makeDTO(HttpServletRequest request) {
        PostDTO dto = new PostDTO();

        dto.setId(Integer.valueOf(request.getParameter("id")));
        dto.setUserId(Integer.valueOf(request.getParameter("userId")));
        dto.setTitle(request.getParameter("title"));
        dto.setBody(request.getParameter("body"));

        return dto;

    }

    @Override
    public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
        request.setCharacterEncoding("UTF-8");

        PostDTO dto = makeDTO(request);
        PostService postService = new PostService();

        Optional<Post> result = postService.updateOptionalPost(dto);

        if (result.isPresent()) {
            request.setAttribute("message", "게시글 변경이 완료되었습니다.");
            request.setAttribute("target", "/main.do");
            return "/WEB-INF/common/redirect.jsp";
        }
        request.setAttribute("message", "게시글 변경이 실패하였습니다.");
        request.setAttribute("target", "/post/edit.do=id" + dto.getId());
        return "/WEB-INF/common/redirect.jsp";
    }
}
