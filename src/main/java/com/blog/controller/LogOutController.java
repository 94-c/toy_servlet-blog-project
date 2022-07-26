package com.blog.controller;

import com.blog.dto.LoginDTO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LogOutController implements Controller{

    private static final String METHOD = "GET";

    @Override
    public String getMethod() {
        return LogOutController.METHOD;
    }

    @Override
    public String process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        try{
            session.invalidate();
            request.setAttribute("message", "로그아웃이 완료되었습니다.");
            request.setAttribute("target", "/main.do");
            return "/WEB-INF/common/redirect.jsp";
        }catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("message", "로그아웃이 실패하였습니다.");
            request.setAttribute("target", "/main.do");
            return "/WEB-INF/common/redirect.jsp";
        }
    }
}
