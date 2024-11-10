package com.flipfit.dao;
import java.sql.*;
public class GetConnection {

    public static void main(String[] args){
        getConnection();

    }
    /**
     * getConnection
     * @return
     */
    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Flipfit_schema", "root", "Xuki6pai!@#%");
            return con;
        }
        catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
}


