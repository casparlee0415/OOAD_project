package com.Dao;

import com.DBConnection.DBConnection;
import com.Entity.Brand;

import java.sql.*;
import java.util.*;
public class BrandDao {
    private final DBConnection dbConnection = new DBConnection();
    private static final String SELECT_ALL_BRAND="SELECT brand_id, brand_name FROM \"brand\" ORDER BY brand_id";

    private static final String SELECT_BRAND_BY_BRAND_ID="SELECT brand_id, brand_name FROM \"brand\" where brand_id = ?";


    public List<Brand> show(){
        Connection connection = dbConnection.getConnection();
        ResultSet resultSet;
        List<Brand> list = new ArrayList<>();
        if(connection!=null) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_BRAND)) {
                resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    Brand brand = new Brand();
                    brand.setId(resultSet.getInt("brand_id"));
                    brand.setName(resultSet.getString("brand_name"));
                    list.add(brand);
                }
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return list;
    }

    public Brand selectBrandByBrandId(int brandId){
        Connection connection = dbConnection.getConnection();
        ResultSet resultSet;
        Brand brand = new Brand();
        if(connection!=null) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BRAND_BY_BRAND_ID)) {
                preparedStatement.setInt(1,brandId);
                resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    brand.setId(resultSet.getInt("brand_id"));
                    brand.setName(resultSet.getString("brand_name"));
                }
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return brand;
    }

}
