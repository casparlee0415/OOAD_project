package com.Servlet.User;

import com.Service.UserService;
import jakarta.servlet.http.*;
import jakarta.servlet.ServletException;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import com.Entity.*;


public class LogoutServlet extends HttpServlet {
    private static final String INDEX_PAGE_URL = "WEB-INF/jsp/index.jsp";
    private UserService userService=new UserService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException{
        req.getSession().setAttribute("user",null);
        resp.sendRedirect(req.getContextPath()+"/index");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException{
        String targetUrl=req.getParameter("targetUrl");

        req.getSession().setAttribute("user",null);

        resp.sendRedirect(req.getContextPath()+targetUrl);
    }
}

