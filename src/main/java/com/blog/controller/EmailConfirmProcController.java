package com.blog.controller;

import com.blog.dto.EmailTokensDTO;
import com.blog.service.EmailTokensService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class EmailConfirmProcController implements Controller {

    private static final String METHOD = "POST";

    @Override
    public String getMethod() {
        return EmailConfirmProcController.METHOD;
    }

    @Override
    public String process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        return "/WEB-INF/common/emailConfirm.jsp";
    }
}
