package com.flipflit.bean;

public class GymBookings {

    private int bookingId;
    private int userId;
    private GymSlot bookingSlot;

    public GymBookings(int bookingId, int userId, GymSlot bookingSlot) {
        this.bookingId = bookingId;
        this.userId = userId;
        this.bookingSlot = bookingSlot;
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public GymSlot getBookingSlot() {
        return bookingSlot;
    }

    public void setBookingSlot(GymSlot bookingSlot) {
        this.bookingSlot = bookingSlot;
    }
}
