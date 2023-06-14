package com.Servlet.Comment;

import com.Service.CommentService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class DeleteCommentServlet extends HttpServlet {
    private final CommentService commentService=new CommentService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        resp.sendRedirect(req.getContextPath()+"/index");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        int commentId=Integer.valueOf(req.getParameter("commentId").toString());
        String commentNum=req.getParameter("commentNum").toString();

        commentService.deleteCommentByCommentId(commentId);

        resp.sendRedirect(req.getContextPath()+"/scooter?scooterId="+req.getParameter("scooterId").toString()+"#"+commentNum);
    }
}
