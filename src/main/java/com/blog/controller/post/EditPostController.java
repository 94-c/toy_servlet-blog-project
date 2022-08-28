package com.blog.controller.post;

import com.blog.controller.Controller;
import com.blog.entity.Comment;
import com.blog.entity.Post;
import com.blog.service.CommentService;
import com.blog.service.PostService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

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
        CommentService commentService = new CommentService();

        Post result = postService.findByPostId(id);

        //TODO 컨트롤러 하나당 하나의 서비스, 게시글하고 코멘트리스트 합친 서비스를 만들어야 한다.
        if (result == null) {
            request.setAttribute("message", "등록 된 게시글이 없습니다.");
            request.setAttribute("target", "/main.do");
            return "/WEB-INF/common/redirect.jsp";
        }
        request.setAttribute("posts", result);
        request.setAttribute("commentList", result);

        return "/WEB-INF/views/post.jsp";

    }
}
