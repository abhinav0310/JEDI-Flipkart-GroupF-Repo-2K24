package com.flipfit.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection
{

    public static Connection connect() throws SQLException {
        try{
            Class.forName("com.mysql.jdbc.Driver");

            Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/flipfir_schema","root","Xuki6pai!@#%");

            con.close();

        }catch(Exception e){ System.out.println(e);}
        return null;
    }
}
