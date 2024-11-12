package com.flipfit.dao;

import com.flipfit.bean.GymCustomer;
import com.flipfit.bean.GymOwner;
import com.flipfit.bean.GymSlots;
import com.flipfit.exceptions.DataEntryFailedException;
import com.flipfit.exceptions.InvalidCredentialsException;
import com.flipfit.exceptions.ResourceAlreadyExistsException;
import java.time.LocalTime;

public interface GymOwnerDAO {

    // Creates a new gym owner profile

    /**
     *
     * @param gymOwner to be updated
     * @return to be updated
     * @throws InvalidCredentialsException to be updated
     * @throws DataEntryFailedException to be updated
     */
    public boolean createProfile(GymOwner gymOwner) throws InvalidCredentialsException, DataEntryFailedException;

    // Registers a new gym center for the owner

    /**
     *
     * @param ownerId to be updated
     * @param centerName to be updated
     * @param location to be updated
     * @param slots to be updated
     * @return to be updated
     * @throws DataEntryFailedException to be updated
     */
    public boolean registerCenter(int ownerId, String centerName, String location, int slots) throws DataEntryFailedException;

    // Adds new slots to an existing gym center

    /**
     *
     * @param centerID to be updated
     * @param slot to be updated
     * @return to be updated
     * @throws ResourceAlreadyExistsException to be updated
     * @throws DataEntryFailedException to be updated
     */
    public boolean addSlots(int centerID, GymSlots slot) throws ResourceAlreadyExistsException, DataEntryFailedException;

    // Deletes a specific gym slot from a gym center

    /**
     *
     * @param centerID to be updated
     * @param starttime to be updated
     * @return to be updated
     * @throws DataEntryFailedException to be updated
     */
    public boolean deleteSlot(int centerID, LocalTime starttime) throws DataEntryFailedException;

    // Deletes a gym center

    /**
     *
     * @param centerId to be updated
     * @return to be updated
     * @throws DataEntryFailedException to be updated
     */
    public boolean deleteCenter(int centerId) throws DataEntryFailedException;

    // Edits an existing gym owner profile

    /**
     *
     * @param gymOwner to be updated
     * @return to be updated
     * @throws DataEntryFailedException to be updated
     */
    public boolean editProfile(GymOwner gymOwner) throws DataEntryFailedException;

    // Updates the gym owner's password

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
