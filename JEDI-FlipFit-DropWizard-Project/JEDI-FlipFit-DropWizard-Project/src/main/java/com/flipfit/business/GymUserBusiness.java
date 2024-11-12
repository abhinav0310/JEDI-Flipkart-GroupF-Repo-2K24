package com.flipfit.business;

import com.flipfit.bean.GymAdmin;
import com.flipfit.bean.GymCustomer;
import com.flipfit.bean.GymOwner;

import java.util.List;

public interface GymUserBusiness {

    // Method to view a list of all customers in the system

    /**
     *
     * @return to be updated
     */
    public List<GymCustomer> viewAllCustomers();

    // Method to view a list of all gym owners in the system

    /**
     *
     * @return to be updated
     */
    public List<GymOwner> viewAllGymOwners();

    // Method to handle user login; returns an integer representing the user role (e.g., 1 for admin, 2 for customer, etc.)

    /**
     *
     * @param email to be updated
     * @param password to be updated
     * @param role to be updated
     * @return to be updated
     */
    public int login(String email, String password, String role);
}
