package com.Servlet.Comment;

import com.Entity.User;
import com.Service.CommentService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class EditCommentServlet extends HttpServlet {
    private final CommentService commentService=new CommentService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        resp.sendRedirect(req.getContextPath()+"/index");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        int commentId=Integer.valueOf(req.getParameter("commentId").toString());
        int score=Integer.valueOf(req.getParameter("score").toString());
        String discription=req.getParameter("discription").toString();
        String commentNum=req.getParameter("commentNum").toString();
        commentService.updateCommentByCommentId(commentId,score,discription);

        resp.sendRedirect(req.getContextPath()+"/scooter?scooterId="+req.getParameter("scooterId").toString()+"#"+commentNum);
    }
}
