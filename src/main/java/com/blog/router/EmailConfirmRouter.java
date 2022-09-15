package com.blog.router;

import com.blog.controller.Controller;
import com.blog.controller.EmailConfirmController;

import java.util.Map;

public class EmailConfirmRouter {
    public EmailConfirmRouter(Map<String, Controller> routers) {
        routers.put("/emailConfirm.do", new EmailConfirmController());
    }
}
