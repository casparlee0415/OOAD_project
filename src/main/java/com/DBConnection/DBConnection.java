package com.DBConnection;

import java.sql.*;
import java.util.Properties;

public class DBConnection {
    private final String url = "jdbc:sqlite:DB/scooter.DB";


    public Connection getConnection(){
        Connection conn=null;
        try{
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection(url);

        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
        return conn;
    }
}
