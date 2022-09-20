package com.blog.router;

import com.blog.controller.Controller;
import com.blog.controller.CreateLikeController;

import java.util.Map;

public class LikeRouter {
    public LikeRouter(Map<String, Controller> routers) {
        routers.put("/like/create.do", new CreateLikeController());
    }
}
