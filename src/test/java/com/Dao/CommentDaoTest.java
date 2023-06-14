package com.Dao;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import com.Entity.*;
import java.util.*;
import java.util.stream.*;
import static org.junit.Assert.*;

public class CommentDaoTest {

    protected final UserDao userDao=new UserDao();
    protected final CommentDao commentDao=new CommentDao();
    @Before
    public void setUp() throws Exception {
        if(!userDao.selectUserByUserId("test").getId().equals("test")) userDao.insertUser("test","test","");
        commentDao.insertComment(1,"234","1234",14,"test");
    }

    @After
    public void tearDown() throws Exception {
        List<Comment> commentList=commentDao.selectCommentByScooterId(14).stream()
                .filter(i->i.getUser().getId().equals("test")).collect(Collectors.toList());;
        commentList.forEach(i->commentDao.deleteCommentByCommentId(i.getId()));
        userDao.deleteUser("test");

    }

    @Test
    public void selectCommentByScooterId() {
        List<Comment> commentList=commentDao.selectCommentByScooterId(14);
        assertTrue(commentList.stream().filter(i->i.getDescription().equals("234")).count()>0);
    }

    @Test
    public void insertComment() {
        commentDao.insertComment(1,"2345","1234",14,"test");
        List<Comment> commentList=commentDao.selectCommentByScooterId(14).stream()
                .filter(i->i.getUser().getId().equals("test")).collect(Collectors.toList());
        assertTrue(commentList.stream().filter(i->i.getDescription().equals("2345")).count()>0);
    }

    @Test
    public void updateCommentByCommentId() {
        List<Comment> commentList=commentDao.selectCommentByScooterId(14).stream()
                .filter(i->i.getUser().getId().equals("test")).collect(Collectors.toList());;
        int commentId=commentList.get(0).getId();
        commentDao.updateCommentByCommentId(commentId,5,"666");
        commentList=commentDao.selectCommentByScooterId(14);
        assertTrue(commentList.stream().filter(i->i.getDescription().equals("666")).count()>0);
    }

    @Test
    public void deleteCommentByCommentId(){
        List<Comment> commentList=commentDao.selectCommentByScooterId(14).stream()
                .filter(i->i.getUser().getId().equals("test")).collect(Collectors.toList());
        int commentId=commentList.get(0).getId();
        Comment comment=commentList.get(0);
        commentDao.deleteCommentByCommentId(commentId);
        commentList=commentDao.selectCommentByScooterId(14);
        assertTrue(!commentList.contains(comment));
    }
}