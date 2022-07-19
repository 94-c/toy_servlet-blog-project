package com.blog.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class emailConfirmController implements Controller{

    private static final String METHOD = "GET";

    @Override
    public String getMethod() {
        return emailConfirmController.METHOD;
    }

    @Override
    public String process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        return "/WEB-INF/common/emailConfirm.jsp";
    }
}
