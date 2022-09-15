package com.blog.router;

import com.blog.controller.Controller;
import com.blog.controller.CreateCommentController;
import com.blog.controller.DeleteCommentController;
import com.blog.controller.EditCommentController;

import java.util.Map;

public class CommentRouter {
    public CommentRouter(Map<String, Controller> routers) {
        // 댓글 작성
        routers.put("/comment/create.do", new CreateCommentController());
        // 댓글 수정
        routers.put("/comment/edit.do", new EditCommentController());
        // 댓글 삭제
        routers.put("/comment/delete.do", new DeleteCommentController());
    }
}
