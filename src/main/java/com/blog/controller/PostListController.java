package com.blog.controller;

import com.blog.data.entity.Post;
import com.blog.service.PostService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class PostListController implements Controller {

    private final PostService postService;

    public PostListController() {
        this.postService = new PostService();
    }
    @Override
    public String doGet(HttpServletRequest request, HttpServletResponse response) {
        List<Post> postList = postService.findAllPost();

        request.setAttribute("postList", postList);

        return "/WEB-INF/views/main.jsp";
    }

    @Override
    public String doPost(HttpServletRequest request, HttpServletResponse response) {
        return null;
    }
}
