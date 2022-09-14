package com.example.dao;

import com.example.data.Standard;
import com.example.data.Student;
import com.example.util.DbConnection;

import java.sql.*;

@SuppressWarnings("ALL")
public class StandardDAO {
    private Standard standard;

    // standard table name as class_tbl
    //insert
    public int insertIntoStandard(Standard s1) throws SQLException, ClassNotFoundException {
        int rows = 0;
        //connection
        Connection connection = DbConnection.getConnection();
        /*Statement statement = connection.createStatement();
        String sql = "INSERT INTO class_tbl VALUES("
                + standard.getStandard() +","+ standard.getSection()+")";*/
        // read about prepared statements
        String sql = "Insert into class_tbl (class_name, section) values(?,?)";
        // ? is placeholder, it has an index, starting form 1
        PreparedStatement preparedStatement = connection.prepareStatement
                (sql, Statement.RETURN_GENERATED_KEYS);
        //set the values for placeholders
        //setter provided by prepared statement, using the type of data and index
        preparedStatement.setString(1,Standard.getStandard());
        preparedStatement.setString(2,Standard.getSection());

        rows = preparedStatement.executeUpdate();
        int generatedId = 0;
        if(rows == 1){
            //get generated id
            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            if(generatedKeys.next()){
                generatedId = generatedKeys.getInt(1);
            }
        }
        return generatedId;
    }
    //update
    //delete
    //search
    public int checkAndGetAddressId(String address)throws SQLException,ClassNotFoundException {
        int classId = 0;
        Connection connection = DbConnection.getConnection();
        String sql = "Select class_id from class_tbl where  class_name=? and section=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, Standard.getStandard());
        preparedStatement.setString(2, Standard.getSection());
        ResultSet resultSet =  preparedStatement.executeQuery() ;

        if (resultSet.next()) {
            classId = resultSet.getInt(1);
        }
        return classId;

    }


    public int checkAndGetClassId(Standard standard) {
        return Integer.parseInt(null);
    }
}

