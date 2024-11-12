package com.flipfit.dao;

import com.flipfit.bean.GymBooking;
import com.flipfit.bean.GymCustomer;
import com.flipfit.bean.GymPayment;
import com.flipfit.exceptions.DataEntryFailedException;
import com.flipfit.exceptions.InvalidCredentialsException;
import com.flipfit.exceptions.ResourceNotFoundException;
import com.flipfit.exceptions.UnauthorisedAccessException;

import java.util.*;

public interface GymCustomerDAO {

    // Method to create a new customer profile

    /**
     *
     * @param customer to be updated
     * @return to be updated
     * @throws InvalidCredentialsException to be updated
     * @throws DataEntryFailedException to be updated
     */
    public boolean createProfile(GymCustomer customer) throws InvalidCredentialsException, DataEntryFailedException;

    // Method to edit an existing customer profile

    /**
     *
     * @param customer to be updated
     * @return to be updated
     * @throws DataEntryFailedException to be updated
     */
    public boolean editProfile(GymCustomer customer) throws DataEntryFailedException;

    // Method to view all bookings made by a customer

    /**
     *
     * @param customerId to be updated
     * @return to be updated
     * @throws ResourceNotFoundException to be updated
     */
    public List<GymBooking> viewBookings(int customerId) throws ResourceNotFoundException;

    // Method to create a new booking for a customer

    /**
     *
     * @param customerID to be updated
     * @param slotID to be updated
     * @param centerId to be updated
     * @param date to be updated
     * @return to be updated
     * @throws ResourceNotFoundException to be updated
     */
    public int createBooking(int customerID, int slotID, int centerId, Date date) throws ResourceNotFoundException;

    // Method to cancel an existing booking made by a customer

    /**
     *
     * @param customerId to be updated
     * @param bookingID to be updated
     * @return to be updated
     * @throws InvalidCredentialsException to be updated
     * @throws UnauthorisedAccessException to be updated
     */
    public boolean cancelBooking(int customerId, int bookingID) throws InvalidCredentialsException, UnauthorisedAccessException;

    // Method to process a payment for a booking

    /**
     *
     * @param paymentData to be updated
     * @return to be updated
     * @throws DataEntryFailedException to be updated
     */
    public int makepayment(GymPayment paymentData) throws DataEntryFailedException;

    // Method to update customer password

    /**
     *
     * @param email to be updated
     * @param password to be updated
     * @param role to be updated
     * @return to be updated
     * @throws InvalidCredentialsException to be updated
     */
    public boolean updatepwd(String email, String password, String role) throws InvalidCredentialsException;
}
