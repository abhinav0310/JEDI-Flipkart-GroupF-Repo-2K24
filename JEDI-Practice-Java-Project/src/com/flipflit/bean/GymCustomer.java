package com.flipflit.bean;

import java.util.List;

public class GymCustomer extends GymUser{


    private int paymentId;
    private int paymentAmount;
    private PaymentType paymentType;

    public GymCustomer(int userId, String firstName, String lastName, String userEmailId, String password, String phoneNo, int age, Role role, Address address, List<GymBookings> bookingList) {
        super(userId, firstName, lastName, userEmailId, password, phoneNo, age, role, address, bookingList);
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
    }

    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    public int getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(int paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

}
