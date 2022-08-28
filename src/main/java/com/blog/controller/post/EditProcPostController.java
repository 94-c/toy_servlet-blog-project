package com.blog.controller.post;

import com.blog.controller.Controller;
import com.blog.dto.PostDTO;
import com.blog.dto.post.EditRequestPostDTO;
import com.blog.dto.post.EditResponsePostDTO;
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

    private EditRequestPostDTO makeDTO(HttpServletRequest request) {
        return EditRequestPostDTO.builder()
                .id(Integer.valueOf(request.getParameter("id")))
                .userId(Integer.valueOf(request.getParameter("userId")))
                .title(request.getParameter("title"))
                .body(request.getParameter("body"))
                .build();
    }

    @Override
    public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {

        EditRequestPostDTO dto = makeDTO(request);
        PostService postService = new PostService();

        Post result = postService.updatePost(dto);

        if (result == null) {
            request.setAttribute("message", "게시글 변경이 실패하였습니다.");
            request.setAttribute("target", "/post/edit.do=id" + dto.getId());
            return "/WEB-INF/common/redirect.jsp";
        }
        request.setAttribute("message", "게시글 변경이 완료되었습니다.");
        request.setAttribute("target", "/main.do");
        return "/WEB-INF/common/redirect.jsp";

    }
}
