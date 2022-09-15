package com.blog.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface Controller {
    String doGet(HttpServletRequest request, HttpServletResponse response);
    String doPost(HttpServletRequest request, HttpServletResponse response);

}
