package com.Dao;

import com.DBConnection.DBConnection;
import com.Entity.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {

    private final DBConnection dbConnection = new DBConnection();
    private static final String SELECT_USER_BY_USER_ID="SELECT user_id, user_name, img_url FROM \"user\" where user_id = ?";
    private static final String UPDATE_USER_BY_USER_ID="UPDATE \"user\" SET user_name=?, img_url=? where user_id = ?";
    private static final String INSERT_USER="INSERT INTO \"user\" (user_id, user_name, img_url) VALUES (?, ?, ?)";

    private static final String DELETE_USER="DELETE FROM \"user\" where user_id=?";
    public User selectUserByUserId(String id){
        Connection connection = dbConnection.getConnection();
        ResultSet resultSet;
        User user=new User();

        if(connection!=null) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_USER_ID)) {
                preparedStatement.setString(1,id);
                resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    user.setId(resultSet.getString("user_id"));
                    user.setName(resultSet.getString("user_name"));
                    user.setImgUrl(resultSet.getString("img_url"));
                }
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return user;
    }

    public void updateUserByUserId(String id, String name, String imgUrl){
        Connection connection = dbConnection.getConnection();

        if(connection!=null) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USER_BY_USER_ID)) {
                preparedStatement.setString(1,name);
                preparedStatement.setString(2,imgUrl);
                preparedStatement.setString(3,id);
                preparedStatement.executeUpdate();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void insertUser(String id, String name, String imgUrl){
        Connection connection = dbConnection.getConnection();

        if(connection!=null) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USER)) {
                preparedStatement.setString(1,id);
                preparedStatement.setString(2,name);
                preparedStatement.setString(3,imgUrl);
                preparedStatement.executeUpdate();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void deleteUser(String id){
        Connection connection = dbConnection.getConnection();

        if(connection!=null) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USER)) {
                preparedStatement.setString(1,id);
                preparedStatement.executeUpdate();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
