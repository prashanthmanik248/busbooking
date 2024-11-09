package com.blackdots.busbooking.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import com.blackdots.busbooking.model.User;


public class SignupRepository {


    public boolean signUpwithObject(User user ){
        
        try {
            String url = "jdbc:mysql://localhost:3306/mydb";
            String dbUsername = "root";
            String dbPassword = "Bbekky9h26@";
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection = DriverManager.getConnection(url, dbUsername, dbPassword);

            String query = "insert into  users (name,username,password,gender,mobile,email)   values (?, ?, ?, ?, ?, ?) ";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1,user.getName());
            statement.setString(2,user.getUsername());
            statement.setString(3,user.getPassword());
            statement.setString(4,user.getGender());
            statement.setString(5,user.getMobile());
            statement.setString(6,user.getEmail());
            int rows = statement.executeUpdate();
            return rows > 0;
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }


    

   
}
