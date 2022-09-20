package com.blog.router;

import com.blog.controller.Controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("*.do")
public class WebRouter extends HttpServlet {
    private final Map<String, Controller> routers = new HashMap<>();

    @Override
    public void init() throws ServletException {
        new LoginRouter(routers);
        new EmailConfirmRouter(routers);
        new UserRouter(routers);
        new PostRouter(routers);
        new CommentRouter(routers);
        new ParentCommentRouter(routers);
        new LikeRouter(routers);
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = request.getRequestURI();
        String contextPath = request.getContextPath();
        String path = url.substring(contextPath.length());

        if (routers.containsKey(path)) {
            Controller controller = routers.get(path);

            String method = request.getMethod();
            if (method.equals("GET")) {
                render(request, response, controller.doGet(request, response));
            } else if (method.equals("POST")) {
                render(request, response, controller.doPost(request, response));
            } else {
                System.out.println("Not Access");
            }
        } else {
            System.out.println("Not Found");
        }
    }

    private void render(HttpServletRequest request, HttpServletResponse response, String viewFilePath) throws ServletException, IOException {
        if (viewFilePath == null) {
            System.out.println("viewPath Error");
            return;
        }
        request.getRequestDispatcher(viewFilePath).forward(request, response);
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
