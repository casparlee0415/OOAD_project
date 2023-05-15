package com.DBConnection;

import java.sql.*;
import java.util.Properties;

public class DBConnection {
    private final String url = "jdbc:postgresql://ec2-3-208-74-199.compute-1.amazonaws.com:5432/d2sfa76c0js49q";
    private final String schema = "scooter";
    private final String user = "ofdlxxlgolffqu";
    private final String password = "269d3baf2ee294506a6d7c17dc875ef985ad4e47439818e31e02dc4cab85881b";

    public Connection getConnection(){
        Connection conn=null;
        Properties info=new Properties();
        try{
            info.setProperty("user",user);
            info.setProperty("password",password);
            info.setProperty("sslmode","require");
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(url,info);
            conn.setSchema(schema);
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
