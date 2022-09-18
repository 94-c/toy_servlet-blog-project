package com.blog.router;

import com.blog.controller.Controller;
import com.blog.controller.CreateParentCommentController;
import com.blog.controller.DeleteParentCommentController;
import com.blog.controller.EditParentCommentController;

import java.util.Map;

public class ParentCommentRouter {
    public ParentCommentRouter(Map<String, Controller> routers) {
        // 대댓글 작성
        routers.put("/parentComment/create.do", new CreateParentCommentController());

        // 대댓글 수정
        routers.put("/parentComment/edit.do", new EditParentCommentController());

        // 대댓글 삭제
        routers.put("/parentComment/delete.do", new DeleteParentCommentController());


    }
}
