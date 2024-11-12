package com.flipfit.dao;

import com.flipfit.bean.GymCustomer;
import com.flipfit.bean.GymOwner;
import com.flipfit.exceptions.DBConnectionException;
import com.flipfit.exceptions.InvalidCredentialsException;
import com.flipfit.exceptions.ResourceNotFoundException;

import java.util.List;

public interface GymUserDAO {
    /**
     *
     * @return to be updated
     * @throws ResourceNotFoundException to be updated
     */
    public List<GymCustomer> viewAllCustomers() throws ResourceNotFoundException;

    /**
     *
     * @return to be updated
     * @throws ResourceNotFoundException to be updated
     */
    public List<GymOwner> viewAllGymOwners() throws ResourceNotFoundException;

    /**
     *
     * @param email to be updated
     * @param password to be updated
     * @param role to be updated
     * @return to be updated
     * @throws InvalidCredentialsException to be updated
     * @throws DBConnectionException to be updated
     */
    public int login(String email, String password, String role) throws InvalidCredentialsException, DBConnectionException;
}
