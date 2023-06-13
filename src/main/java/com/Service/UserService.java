package com.Service;

import com.Dao.UserDao;
import com.Entity.User;

import java.sql.SQLException;

public class UserService {
    private UserDao userDao=new UserDao();

    public User insertOrGetUserById(String id, String name, String imgUrl){
        User user=userDao.selectUserByUserId(id);
        if(!user.getId().equals(id)){
            userDao.insertUser(id, name, imgUrl);
        }
        else if(!user.getName().equals(name)||!user.getImgUrl().equals(imgUrl)){
            userDao.updateUserByUserId(id,name,imgUrl);
        }
        else return user;

        user=userDao.selectUserByUserId(id);

        return user;
    }
}
