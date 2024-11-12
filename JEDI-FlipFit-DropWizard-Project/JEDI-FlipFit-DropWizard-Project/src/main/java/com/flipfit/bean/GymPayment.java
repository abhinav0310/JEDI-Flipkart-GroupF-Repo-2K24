package com.flipfit.bean;

public class GymPayment {
    // Properties of the GymPayment class with their respective getters and setters

    // Unique payment ID
    private int paymentID;
    // Booking ID associated with the payment
    private int bookingID;
    // Payment mode (e.g., credit card, cash, etc.)
    private String mode;
    // Amount paid for the booking
    private int amount;

    // Getter method for bookingID

    /**
     *
     * @return to be updated
     */
    public int getBookingID() {
        return bookingID;  // Return the bookingID
    }

    // Setter method for bookingID

    /**
     *
     * @param bookingID to be updated
     */
    public void setBookingID(int bookingID) {
        this.bookingID = bookingID;  // Set the bookingID
    }

    // Getter method for mode

    /**
     *
     * @return to be updated
     */
    public String getMode() {
        return mode;  // Return the payment mode
    }

    // Setter method for mode

    /**
     *
     * @param mode to be updated
     */
    public void setMode(String mode) {
        this.mode = mode;  // Set the payment mode
    }

    // Getter method for amount

    /**
     *
     * @return to be updated
     */
    public int getAmount() {
        return amount;  // Return the amount paid
    }

    // Setter method for amount

    /**
     *
     * @param amount to be updated
     */
    public void setAmount(int amount) {
        this.amount = amount;  // Set the amount paid
    }

    // Constructor to initialize GymPayment with bookingID and mode

    /**
     *
     * @param bookingID to be updated
     * @param mode to be updated
     */
    public GymPayment(int bookingID, String mode) {
        this.bookingID = bookingID;  // Set the bookingID
        this.mode = mode;  // Set the payment mode
    }
}
