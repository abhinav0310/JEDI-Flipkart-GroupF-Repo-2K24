package com.flipfit.utils;

import com.flipfit.exceptions.DBConnectionException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBConnection
{
    public static Connection connect() throws DBConnectionException {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            //String password = "Password123";//Enter your password here
            Connection con=DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/JEDI-FlipFit_schema","root","Xuki6pai!@#%");
            System.out.println("Database Connected");

            return con;
        }catch(Exception e){
            throw new DBConnectionException("Database Not Connected");
        }

    }
}