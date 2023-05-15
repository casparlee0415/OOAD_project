package com.Servlet;

import jakarta.servlet.http.*;
import jakarta.servlet.ServletException;
import java.io.IOException;


public class LoginServlet extends HttpServlet {
    private static final String INDEX_PAGE_URL = "WEB-INF/jsp/index.jsp";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException{
        System.out.println(req.getHeader("Referer"));
        resp.sendRedirect(req.getHeader("Referer"));

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException{
        System.out.println(req.getHeader("Referer"));
        resp.sendRedirect("./scooter?id=14");

    }
}
