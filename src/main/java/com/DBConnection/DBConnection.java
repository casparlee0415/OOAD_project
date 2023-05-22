package com.DBConnection;

import java.io.File;
import java.sql.*;
import java.util.Properties;

public class DBConnection {

    private final String root=getParent(System.getProperty("catalina.home"));
    private final String url = "jdbc:sqlite:"+root+"DB/scooter.DB";

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

    private static String getParent(String url){
        if(url==null) return "";
        url=url.replace('\\','/');

        int endIndex=url.lastIndexOf('/')+1;
        url=url.substring(0,endIndex);


        return url;
    }
}
