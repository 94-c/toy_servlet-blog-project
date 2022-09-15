package com.blog.controller;

import com.blog.controller.Controller;
import com.blog.data.entity.Post;
import com.blog.dto.post.EditRequestPostDTO;
import com.blog.requestDto.EditRequestDto;
import com.blog.responseDto.EditResponsePostEditDto;
import com.blog.service.PostService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class EditPostController implements Controller {

    private final PostService postService;

    public EditPostController() {
        this.postService = new PostService();
    }

    @Override
    public String doGet(HttpServletRequest request, HttpServletResponse response) {
        Integer id = Integer.valueOf(request.getParameter("id"));

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

    @Override
    public String doPost(HttpServletRequest request, HttpServletResponse response) {
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