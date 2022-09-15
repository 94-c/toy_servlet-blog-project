package com.blog.router;

import com.blog.controller.Controller;
import com.blog.controller.LogOutController;
import com.blog.controller.LoginController;

import java.util.HashMap;
import java.util.Map;

public class LoginRouter {
    public LoginRouter(Map<String, Controller> routers) {
        // 로그인
        routers.put("/login.do", new LoginController());

        // 로그아웃
        routers.put("/logOut.do", new LogOutController());
    }
}
