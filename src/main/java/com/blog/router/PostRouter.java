package com.blog.router;

import com.blog.controller.Controller;
import com.blog.controller.CreatePostController;
import com.blog.controller.EditPostController;
import com.blog.controller.PostListController;

import java.util.Map;

public class PostRouter {
    public PostRouter(Map<String, Controller> routers) {

        //게시글 리스트
        routers.put("/main.do", new PostListController());

        // 게시글 작성
        routers.put("/post/create.do", new CreatePostController());

        routers.put("/post/edit.do", new EditPostController());
    }
}
