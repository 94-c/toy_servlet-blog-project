package com.blog.controller.post;

import com.blog.controller.Controller;
import com.blog.responseDto.EditResponsePostEditDto;
import com.blog.service.PostService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class EditPostController implements Controller {

    private static final String METHOD = "GET";

    @Override
    public String getMethod() {
        return EditPostController.METHOD;
    }

    @Override
    public String process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Integer id = Integer.valueOf(request.getParameter("id"));

        PostService postService = new PostService();

        EditResponsePostEditDto result = postService.findByPostId(id);

        if (result == null) {
            request.setAttribute("message", "등록 된 게시글이 없습니다.");
            request.setAttribute("target", "/main.do");
            return "/WEB-INF/common/redirect.jsp";
        }
        request.setAttribute("posts", result.getPost());
        request.setAttribute("commentList", result.getCommentList());
        request.setAttribute("parentComment", result.getParentCommentList());

        return "/WEB-INF/views/post.jsp";

    }
}
