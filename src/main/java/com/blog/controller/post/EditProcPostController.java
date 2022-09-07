package com.blog.controller.post;

import com.blog.controller.Controller;
import com.blog.dto.post.EditRequestPostDTO;
import com.blog.entity.Post;
import com.blog.requestDto.EditRequestDto;
import com.blog.service.PostService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EditProcPostController implements Controller {
    private static final String METHOD = "POST";

    private final PostService postService;

    public EditProcPostController() {
        this.postService = new PostService();
    }

    @Override
    public String getMethod() {
        return EditProcPostController.METHOD;
    }


    @Override
    public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
        EditRequestPostDTO dto = new EditRequestDto().toPostDto(request);
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
