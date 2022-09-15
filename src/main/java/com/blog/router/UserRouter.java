package com.blog.router;

import com.blog.controller.Controller;
import com.blog.controller.EditUserController;
import com.blog.controller.CreateUserController;

import java.util.Map;

public class UserRouter {
    public UserRouter(Map<String, Controller> routers) {
        // 회원 가입
        routers.put("/join.do", new CreateUserController());

        // 사용자 수정
        routers.put("/user/edit.do", new EditUserController());
    }
}
