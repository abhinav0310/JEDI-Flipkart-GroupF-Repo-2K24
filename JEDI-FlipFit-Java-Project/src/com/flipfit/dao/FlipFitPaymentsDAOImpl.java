package com.flipfit.dao;

import com.flipfit.bean.FlipFitPayments;
import com.flipfit.constant.DBConstants;
import com.flipfit.dao.interfaces.IFlipFitPaymentsDAO;

import java.sql.SQLException;
import java.util.Random;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class FlipFitPaymentsDAOImpl implements IFlipFitPaymentsDAO {
    Random rand = new Random();

    /**
     * Set Payment Info
     *
     * @param FFP
     */
    @Override
    public FlipFitPayments setPaymentInfo(FlipFitPayments FFP) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    DBConstants.DB_URL,DBConstants.USER,DBConstants.PASSWORD);

            PreparedStatement stmt = con.prepareStatement("REPLACE INTO Payments (userID, paymentType, paymentInfo, bookingID) VALUES (?, ?, ?, ?)");


            // Generate random integers in range 0 to 999
            stmt.setInt(1, FFP.getUserID());
            stmt.setInt(2, FFP.getPaymentType());
            stmt.setString(3, FFP.getPaymentInfo());
            stmt.setInt(4, FFP.getBookingID());

            int i = stmt.executeUpdate();
            if(i==0){
                throw new SQLException("Creating payment failed. No rows affected");
            }
            FFP.setTransactionStatus(true);

            con.close();
        } catch(SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
        return FFP;
    }

    /**
     * Delete Payment Info
     *
     * @param FFP
     */
    @Override
    public void deletePaymentInfo(FlipFitPayments FFP) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    DBConstants.DB_URL,DBConstants.USER,DBConstants.PASSWORD);

            PreparedStatement stmt = con.prepareStatement("DELETE FROM Payments WHERE userID=(?)");

            stmt.setInt(1, FFP.getUserID());

            int i = stmt.executeUpdate();
            System.out.println( i + " payment info deleted");

            con.close();
        } catch(Exception e){
            System.out.println(e);
        }
    }

}
