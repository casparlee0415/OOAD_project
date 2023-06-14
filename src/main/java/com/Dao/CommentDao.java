package com.Dao;

import com.DBConnection.DBConnection;
import com.Entity.*;
import java.sql.*;
import java.util.*;
import java.util.Date;

public class CommentDao {
    private final DBConnection dbConnection = new DBConnection();

    private final ScooterDao scooterDao=new ScooterDao();

    private final UserDao userDao=new UserDao();

    private static final String SELECT_COMMENT_BY_SCOOTER_ID="SELECT * from \"comment\" where scooter_id = ? Order By datetime(timestamp) DESC";
    private static final String INSERT_COMMENT="INSERT INTO \"comment\" (score, discription, timestamp, scooter_id, user_id) "+
                                                    "VALUES (?,?,?,?,?)";
    private static final String UPDATE_COMMENT="UPDATE \"comment\" SET score=?,discription=? where comment_id=?";

    private static final String DELETE_COMMENT="DELETE FROM \"comment\" where comment_id = ?";
    public List<Comment> selectCommentByScooterId(int scooterId){
        Connection connection = dbConnection.getConnection();
        ResultSet resultSet;
        List<Comment> list = new ArrayList<>();

        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_COMMENT_BY_SCOOTER_ID)){
            preparedStatement.setInt(1,scooterId);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Comment comment=new Comment();
                Scooter scooter=new Scooter();
                User user=new User();
                comment.setId(resultSet.getInt("comment_id"));
                comment.setScore(resultSet.getInt("score"));
                comment.setDescription(resultSet.getString("discription"));
                comment.setTimestamp(new Date(resultSet.getString("timestamp")));
                scooter=scooterDao.selectScooterByScooterId(resultSet.getInt("scooter_id"));
                user=userDao.selectUserByUserId(resultSet.getString("user_id"));
                comment.setScooter(scooter);
                comment.setUser(user);
                list.add(comment);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    public void insertComment(int score,String discription,String timestamp, int scooterId,String userId){
        Connection connection = dbConnection.getConnection();

        if(connection!=null) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_COMMENT)) {
                preparedStatement.setInt(1,score);
                preparedStatement.setString(2,discription);
                preparedStatement.setString(3,timestamp);
                preparedStatement.setInt(4,scooterId);
                preparedStatement.setString(5,userId);
                preparedStatement.executeUpdate();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void updateCommentByCommentId(int commentId,int score,String discription){
        Connection connection = dbConnection.getConnection();

        if(connection!=null) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_COMMENT)) {
                preparedStatement.setInt(1,score);
                preparedStatement.setString(2,discription);
                preparedStatement.setInt(3,commentId);
                preparedStatement.executeUpdate();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void deleteCommentByCommentId(int commentId) {
        Connection connection = dbConnection.getConnection();
        if (connection != null) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(DELETE_COMMENT)) {
                preparedStatement.setInt(1, commentId);
                preparedStatement.executeUpdate();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
