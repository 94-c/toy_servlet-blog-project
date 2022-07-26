package com.blog.controller.post;

import com.blog.controller.Controller;
import com.blog.service.PostService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class PostListController implements Controller {

    private static final String METHOD = "GET";

    @Override
    public String getMethod() {
        return PostListController.METHOD;
    }

    @Override
    public String process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PostService postService = new PostService(request);

        postService.findAllPost();

        return "/WEB-INF/views/list.jsp";
    }
}
