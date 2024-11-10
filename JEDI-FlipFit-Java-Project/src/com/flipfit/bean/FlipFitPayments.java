package com.flipfit.bean;

/**
 * payment details
 */

public class FlipFitPayments {
    private int userID;
    private int paymentType;
    private String paymentInfo;

    public int getBookingID() {
        return bookingID;
    }

    public void setBookingID(int bookingID) {
        this.bookingID = bookingID;
    }

    private int bookingID;

    private boolean transactionStatus=false;

    public void setTransactionStatus(boolean transactionStatus){this.transactionStatus=transactionStatus;}

    public boolean getTransactionStatus(){ return transactionStatus;}

    public String getPaymentInfo() {
        return paymentInfo;
    }

    public void setPaymentInfo(String paymentInfo) {
        this.paymentInfo = paymentInfo;
    }

    public int getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(int paymentType) {
        this.paymentType = paymentType;
    }


    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }
}
