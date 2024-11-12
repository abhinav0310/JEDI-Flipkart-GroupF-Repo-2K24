package com.flipfit.business;

import com.flipfit.bean.*;

import java.util.*;

public interface GymAdminBusiness {
    // Method to retrieve all the gym bookings
    // Returns a list of GymBooking objects

    /**
     *
     * @return to be updated
     */
    public List<GymBooking> viewBookings();

    // Method to approve a gym owner's registration
    // Takes requestId to identify the registration request and statuss to approve or reject the request
    // No return value

    /**
     *
     * @param requestId to be updated
     * @param statuss to be updated
     */
    public void approveOwnerRegistration(int requestId, String statuss);

    // Method to get all pending gym owner registration requests
    // Returns a list of GymOwnerRequest objects

    /**
     *
     * @return to be updated
     */
    public List<GymOwnerRequest> pendingRequests();

    // Method to view the gym centers managed by the admin
    // Returns a list of GymCenter objects

    /**
     *
     * @return to be updated
     */
    public List<GymCenter> viewCenter();

    // Method to update the admin's password
    // Takes email for identification, new password, and the role of the user (admin or other)
    // Returns true if the update is successful, false otherwise

    /**
     *
     * @param email to be updated
     * @param password to be updated
     * @param role to be updated
     * @return to be updated
     */
    public boolean updatepwd(String email, String password, String role);
}
