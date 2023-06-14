package com.Servlet.Comment;

import com.Entity.Comment;
import com.Entity.User;
import com.Service.CommentService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AddCommentServlet extends HttpServlet {
    private final CommentService commentService=new CommentService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        int score=Integer.valueOf(req.getParameter("score").toString());
        String discription=req.getParameter("discription").toString();
        String timestamp=formatter.format(new Date());
        System.out.println(timestamp);
        int scooterId=Integer.valueOf(req.getParameter("scooterId").toString());
        String userId=((User)req.getSession().getAttribute("user")).getId();

        commentService.insertComment(score,discription,timestamp,scooterId,userId);

        resp.sendRedirect(req.getContextPath()+"/scooter?scooterId="+req.getParameter("scooterId").toString()+"#comment0");
    }
}
