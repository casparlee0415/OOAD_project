package com.Dao;

import com.DBConnection.DBConnection;
import com.Entity.*;
import com.Entity.Scooter;

import java.sql.*;
import java.util.*;

public class ScooterDao {
    private final DBConnection dbConnection = new DBConnection();
    private static final String SELECT_SCOOTER_BY_BRAND_ID = "SELECT s.scooter_id, s.scooter_name, s.price, b.brand_id, b.brand_name FROM \"scooter\" As s " +
                                                            "INNER JOIN \"brand\" As b ON s.brand_id=b.brand_id " +
                                                            "where b.brand_id = ? ORDER BY s.scooter_name";

    private static final String ALL_SCOOTER_ATTRIBUTE = "s.scooter_id, s.scooter_name, s.scooter_type, s.price, s.engine_type, " +
                                                        "s.transmission, s.displacement, s.performance ";
    private static final String SELECT_SCOOTER_BY_SCOOTER_ID = "SELECT " + ALL_SCOOTER_ATTRIBUTE + ",b.brand_id, b.brand_name FROM \"scooter\" As s "+
                                                            "INNER JOIN \"brand\" As b ON s.brand_id=b.brand_id " +
                                                            "where s.scooter_id = ?";

    private static final String SELECT_SCOOTER_BY_BRAND_ID_WHERE_NOT_EQUAL_SCOOTER_ID = "SELECT s.scooter_id, s.scooter_name, s.price, b.brand_id, b.brand_name " +
                                                            "FROM \"scooter\" As s " +
                                                            "INNER JOIN \"brand\" As b ON s.brand_id=b.brand_id " +
                                                            "where b.brand_id = ? AND s.scooter_id <> ? ORDER BY s.price ASC " +
                                                            "LIMIT 3";
    public List<Scooter> selectScooterByBrandId(int brandId){
        Connection connection = dbConnection.getConnection();
        ResultSet resultSet;
        List<Scooter> list = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_SCOOTER_BY_BRAND_ID))
        {
            preparedStatement.setInt(1,brandId);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                Scooter scooter = new Scooter();
                Brand brand = new Brand();

                scooter.setId(resultSet.getInt("scooter_id"));
                scooter.setName(resultSet.getString("scooter_name"));
                scooter.setPrice(resultSet.getDouble("price"));
                brand.setId(resultSet.getInt("brand_id"));
                brand.setName(resultSet.getString("brand_name"));
                scooter.setBrand(brand);

                list.add(scooter);
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<Scooter> selectScooterByBrandIdWhereNotEqualScooterId(int brandId,int scooterId){
        Connection connection = dbConnection.getConnection();
        ResultSet resultSet;
        List<Scooter> list = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection
                .prepareStatement(SELECT_SCOOTER_BY_BRAND_ID_WHERE_NOT_EQUAL_SCOOTER_ID)){
            preparedStatement.setInt(1,brandId);
            preparedStatement.setInt(2,scooterId);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                Scooter scooter = new Scooter();
                Brand brand=new Brand();
                scooter.setId(resultSet.getInt("scooter_id"));
                scooter.setName(resultSet.getString("scooter_name"));
                scooter.setPrice(resultSet.getDouble("price"));
                brand.setId(resultSet.getInt("brand_id"));
                brand.setName(resultSet.getString("brand_name"));
                scooter.setBrand(brand);

                list.add(scooter);
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public Scooter selectScooterByScooterId(int scooterId){
        Connection connection = dbConnection.getConnection();
        ResultSet resultSet;
        Scooter scooter=new Scooter();
        Brand brand=new Brand();
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_SCOOTER_BY_SCOOTER_ID)){
            preparedStatement.setInt(1,scooterId);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                scooter.setId(resultSet.getInt("scooter_id"));
                scooter.setName(resultSet.getString("scooter_name"));
                scooter.setType(resultSet.getString("scooter_type"));
                scooter.setPrice(resultSet.getDouble("price"));
                scooter.setEngine(resultSet.getString("engine_type"));
                scooter.setTransmission(resultSet.getString("transmission"));
                scooter.setDisplacement(resultSet.getString("displacement"));
                scooter.setPerformance(resultSet.getString("performance"));
                brand.setId(resultSet.getInt("brand_id"));
                brand.setName(resultSet.getString("brand_name"));
                scooter.setBrand(brand);
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return scooter;
    }
}
