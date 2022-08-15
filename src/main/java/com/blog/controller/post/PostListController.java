package com.blog.controller.post;

import com.blog.controller.Controller;
import com.blog.entity.Post;
import com.blog.service.PostService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class PostListController implements Controller {

    private static final String METHOD = "GET";

    @Override
    public String getMethod() {
        return PostListController.METHOD;
    }

    @Override
    public String process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PostService postService = new PostService();

        List<Post> postList = postService.findAllPost();

        request.setAttribute("postList", postList);

        return "/WEB-INF/views/main.jsp";
    }
}
