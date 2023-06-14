package com.Dao;

import com.Entity.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserDaoTest {

    protected final UserDao userDao=new UserDao();
    @Before
    public void setUp() throws Exception {
        User user=userDao.selectUserByUserId("test");
        if(!user.getId().equals("test")) userDao.insertUser("test","test","");
        else userDao.updateUserByUserId("test","test","");
    }

    @After
    public void tearDown() throws Exception {
        userDao.deleteUser("test");
    }

    @Test
    public void selectUserByUserId() {
        User user=userDao.selectUserByUserId("test");
        assertEquals("user",user.getId());
    }

    @Test
    public void updateUserByUserId() {
        userDao.updateUserByUserId("test","test2","");
        User user=userDao.selectUserByUserId("test");
        assertEquals("test2",user.getName());
    }

    @Test
    public void insertUser() {
        userDao.insertUser("test2","test2","");
        User user=userDao.selectUserByUserId("test2");
        assertEquals("test2",user.getId());
        userDao.deleteUser("test2");
    }

    @Test
    public void deleteUser() {
        userDao.deleteUser("test");
        User user=userDao.selectUserByUserId("test");
        assertNotEquals("test",user.getId());
    }
}