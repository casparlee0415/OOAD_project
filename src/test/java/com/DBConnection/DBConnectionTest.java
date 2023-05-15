package com.DBConnection;

import org.junit.*;
import static org.junit.Assert.*;

import java.sql.Connection;
public class DBConnectionTest{

    private DBConnection dbConnection;
    @Before
    public void setUp() throws Exception{
        dbConnection = new DBConnection();
    }

    @After
    public void tearDown() throws Exception{

    }
    @Test
    public void testGetConnection() {
        Connection conn = dbConnection.getConnection();
        assertNotNull(conn);
    }

}
