package com.blog.controller;

import com.blog.controller.comment.*;
import com.blog.controller.comment.parentComment.*;
import com.blog.controller.post.*;
import com.blog.controller.user.EditProcUserController;
import com.blog.controller.user.EditUserController;
import com.blog.util.HibernateUtil;
import lombok.SneakyThrows;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("*.do")
public class FrontController extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private Map<String, Controller> router = new HashMap<>();

    public FrontController() {
        router.put("/login.do", new LoginController());
        router.put("/loginProc.do", new LoginProcController());
        router.put("/logOut.do", new LogOutController());
        router.put("/join.do", new JoinController());
        router.put("/joinProc.do", new JoinProcController());
        router.put("/emailConfirm.do", new EmailConfirmController());
        router.put("/emailConfirmProc.do", new EmailConfirmProcController());
        router.put("/post/create.do", new CreatePostController());
        router.put("/post/createProc.do", new CreateProcPostController());
        router.put("/post/edit.do", new EditPostController());
        router.put("/post/editProc.do", new EditProcPostController());
        router.put("/post/deleteProc.do", new DeleteProcPostController());

        router.put("/user/edit.do", new EditUserController());
        router.put("/user/editProc.do", new EditProcUserController());

        router.put("/comment/createProc.do", new CreateProcCommentController());
        router.put("/comment/edit.do", new EditCommentController());
        router.put("/comment/editProc.do", new EditProcCommentController());
        router.put("/comment/deleteProc.do", new DeleteProcCommentController());

        router.put("/parenComment/create.do", new CreateParentCommentController());
        router.put("/parenComment/createProc.do", new CreateProcParentCommentController());
        router.put("/parenComment/edit.do", new EditParentCommentController());
        router.put("/parenComment/editProc.do", new EditProcParentCommentController());
        router.put("/parenComment/deleteProc.do", new DeleteProcParentCommentController());

        router.put("/main.do", new PostListController());

    }



    @SneakyThrows
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String requestURI = request.getRequestURI();
        String contextPath = request.getContextPath();
        String path = requestURI.substring(contextPath.length());

        if (router.containsKey(path)) {
            Controller frontController = router.get(path);
            String method = request.getMethod();

            if (method.equals(frontController.getMethod())) {
                String viewPath = frontController.process(request, response);
                request.getRequestDispatcher(viewPath).forward(request, response);
            } else {
                System.out.println("403 Error");
                response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            }
        } else {
            System.out.println("404 Error");
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }
    }

    @Override
    public void destroy() {
        HibernateUtil.closeEntityManagerFactory();
    }
}
