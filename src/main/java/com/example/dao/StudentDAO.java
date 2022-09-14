package com.example.dao;

import com.example.data.Student;
import com.example.util.DbConnection;

import java.sql.*;

@SuppressWarnings("ALL")
public class StudentDAO {
    private int preparedStatment;

    public static int insertIntoStudent(Student student) throws SQLException, ClassNotFoundException {
        int rows = 0;
        //connection
        Connection connection = DbConnection.getConnection();

        String sql = "Insert into class_student (name,rollNo,email, a1,s1) values(?,?,?,?,?,?,?)";
        // ? is placeholder, it has an index, starting form 1
        PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        //set the values for placeholders
        //setter provided by prepared statement, using the type of data and index
        preparedStatement.setString(1, student.getName());
        preparedStatement.setInt(2, Student.getRollNo());
        preparedStatement.setString(3, student.getEmail());
        preparedStatement.setString(4, student.getAddress());
        preparedStatement.setString(5, student.getStandard().getStandard());
        rows = preparedStatement.executeUpdate();
        int generatedId = 0;
        if (rows == 1) {
            //get generated id
            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                generatedId = generatedKeys.getInt(1);
            }
        }
        return generatedId;
    }

    public int checkAndGetAddressId(Student student) throws SQLException, ClassNotFoundException {
        int StudentId = 0;
        Connection connection = DbConnection.getConnection();
        String sql = "Select Student_id (name,rollNo,email,address_id,class_id) values (?,?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setString(1, Student.getName());
        preparedStatement.setInt(2, Student.getRollNo());
        preparedStatement.setString(3, Student.getEmail());
        int classId = new StandardDAO().checkAndGetClassId(student.getStandard());
        preparedStatement.setInt(5, classId);
        int addressId = new StandardDAO().checkAndGetAddressId(student.getAddress());
        preparedStatement.setInt(4, addressId);
        int rows = preparedStatment;
        if (rows == 1) {
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                StudentId = resultSet.getInt(1);
            }
          
        }
        return StudentId;
    }
}
