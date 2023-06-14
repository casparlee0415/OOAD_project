package com.Service;
import com.Dao.CommentDao;
import com.Entity.*;
import java.util.*;
import java.util.stream.Stream;

public class CommentService {
    private final CommentDao commentDao=new CommentDao();

    public List<Comment> selectCommentByScooterId(int scooterId){
        return commentDao.selectCommentByScooterId(scooterId);
    }
    public Double getAverageScore(int scooterId){
        double average=0;
        List<Comment> commentList=selectCommentByScooterId(scooterId);
        if(!commentList.isEmpty()) {
            average = commentList.stream()
                    .mapToDouble(item -> item.getScore().doubleValue()).average().getAsDouble();
            average = Double.valueOf(String.format("%.1f",average));
        }
        return average;
    }

    public void insertComment(int score,String discription,String timestamp, int scooterId,String userId)
    {
        commentDao.insertComment(score,discription,timestamp,scooterId,userId);
    }

    public void updateCommentByCommentId(int commentId,int score,String discription){
        commentDao.updateCommentByCommentId(commentId,score,discription);
    }

    public void deleteCommentByCommentId(int commentId){
        commentDao.deleteCommentByCommentId(commentId);
    }
}
