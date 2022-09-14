package com.example.dao;

import com.example.data.Address;
import com.example.util.DbConnection;

import java.sql.*;

@SuppressWarnings("ALL")
public class AddressDAO {
    public int insertIntoAddress(Address addresss ) throws SQLException, ClassNotFoundException {
        int rows = 0;
        //connection
        Connection connection = DbConnection.getConnection();
        String sql = "Insert into address_tbl (FlatNo,buildingName,Steet,city,state,pincode,country)values(?,?,?,?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setString(1,addresss.getFlatNo());
        preparedStatement.setString(2,addresss.getBuildingName());
        preparedStatement.setString(3,addresss.getStreet());
        preparedStatement.setString(4,addresss.getCity());
        preparedStatement.setString(5,addresss.getState());
        preparedStatement.setString(6,addresss.getPinCode());
        preparedStatement.setString(7,addresss.getCountry());


        rows = preparedStatement.executeUpdate();
        int generatedId = 0;

        if(rows == 1) {
            //get generated id
            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                generatedId = generatedKeys.getInt(1);
            }
        }
        return generatedId;
    }

}
