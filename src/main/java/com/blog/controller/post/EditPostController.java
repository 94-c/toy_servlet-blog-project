package com.blog.controller.post;

import com.blog.controller.Controller;
import com.blog.service.CommentService;
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
        CommentService commentService = new CommentService(request);

        boolean result = postService.findByPostId(id);

        if (result) {
            request.setAttribute("posts", result);
            commentService.findAllCommentByPostId(id);
            return "/WEB-INF/views/post.jsp";
        }

        request.setAttribute("message", "등록 된 게시글이 없습니다.");
        request.setAttribute("target", "/main.do");
        return "/WEB-INF/common/redirect.jsp";
    }
}
