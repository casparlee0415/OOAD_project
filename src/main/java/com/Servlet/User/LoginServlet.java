package com.Servlet.User;

import com.Service.UserService;
import jakarta.servlet.http.*;
import jakarta.servlet.ServletException;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import com.Entity.*;


public class LoginServlet extends HttpServlet {
    private static final String INDEX_PAGE_URL = "WEB-INF/jsp/index.jsp";
    private UserService userService=new UserService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException{
        resp.sendRedirect(req.getContextPath()+"/index");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException{
        String targetUrl=req.getParameter("targetUrl");
        String id=req.getParameter("id");
        String name=req.getParameter("name");
        String imgUrl=req.getParameter("imgUrl");
        User user=userService.insertOrGetUserById(id,name,imgUrl);

        req.getSession().setAttribute("user", user);

        resp.sendRedirect(req.getContextPath()+targetUrl);
    }
}
