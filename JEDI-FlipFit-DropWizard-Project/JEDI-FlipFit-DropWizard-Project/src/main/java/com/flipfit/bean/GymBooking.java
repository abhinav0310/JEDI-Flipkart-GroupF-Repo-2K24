package com.flipfit.bean;

import java.time.LocalTime;
import java.util.Date;

/**
 * to be updated
 */
public class GymBooking {
    // BookingId: Unique identifier for the booking
    // CenterName: Name of the gym center where the booking is made
    // CenterLocation: Location of the gym center
    // StartTime: The start time of the booking
    // EndTime: The end time of the booking
    // BookingDate: The date the booking was made
    private int bookingId;  // Unique booking identifier
    private String centerName;  // Name of the gym center
    private String centerLocation;  // Location of the gym center
    private LocalTime startTime;  // Start time of the booking
    private LocalTime endTime;  // End time of the booking
    private Date bookingDate;  // Date the booking was made

    // Constructor to initialize all fields of the GymBooking object

    /**
     *
     * @param bookingId to be updated
     * @param centerName to be updated
     * @param centerLocation to be updated
     * @param startTime to be updated
     * @param endTime to be updated
     * @param bookingDate to be updated
     */
    public GymBooking(int bookingId, String centerName, String centerLocation, LocalTime startTime, LocalTime endTime, Date bookingDate) {
        this.bookingId = bookingId;  // Set bookingId
        this.centerName = centerName;  // Set centerName
        this.centerLocation = centerLocation;  // Set centerLocation
        this.startTime = startTime;  // Set startTime
        this.endTime = endTime;  // Set endTime
        this.bookingDate = bookingDate;  // Set bookingDate
    }

    // Getter method for bookingId

    /**
     *
     * @return bookingId
     */
    public int getBookingId() {
        return bookingId;  // Return the bookingId
    }

    // Setter method for bookingId

    /**
     *
     * @param bookingId to be updated
     */
    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;  // Set the bookingId
    }

    // Getter method for centerName

    /**
     *
     * @return to be updated
     */
    public String getCenterName() {
        return centerName;  // Return the centerName
    }

    // Setter method for centerName

    /**
     *
     * @param centerName to be updated
     */
    public void setCenterName(String centerName) {
        this.centerName = centerName;  // Set the centerName
    }

    // Getter method for centerLocation

    /**
     *
     * @return to be updated
     */
    public String getCenterLocation() {
        return centerLocation;  // Return the centerLocation
    }

    // Setter method for centerLocation

    /**
     *
     * @param centerLocation to be updated
     */
    public void setCenterLocation(String centerLocation) {
        this.centerLocation = centerLocation;  // Set the centerLocation
    }

    // Getter method for startTime

    /**
     *
     * @return to be updated
     */
    public LocalTime getStartTime() {
        return startTime;  // Return the startTime
    }

    // Setter method for startTime

    /**
     *
     * @param startTime to be updated
     */
    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;  // Set the startTime
    }

    // Getter method for endTime

    /**
     *
     * @return to be updated
     */
    public LocalTime getEndTime() {
        return endTime;  // Return the endTime
    }

    // Setter method for endTime

    /**
     *
     * @param endTime to be updated
     */
    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;  // Set the endTime
    }

    // Getter method for bookingDate

    /**
     *
     * @return to be updated
     */
    public Date getBookingDate() {
        return bookingDate;  // Return the bookingDate
    }

    // Setter method for bookingDate

    /**
     *
     * @param bookingDate to be updated
     */
    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;  // Set the bookingDate
    }
}
