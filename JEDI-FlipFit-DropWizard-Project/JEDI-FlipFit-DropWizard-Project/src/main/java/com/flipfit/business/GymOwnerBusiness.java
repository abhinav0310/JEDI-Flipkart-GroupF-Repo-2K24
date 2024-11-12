package com.flipfit.business;

import com.flipfit.bean.GymCenter;
import com.flipfit.bean.GymOwner;
import com.flipfit.bean.GymSlots;

import java.time.LocalTime;

public interface GymOwnerBusiness {

    // Registers a new gym center for the specified owner

    /**
     *
     * @param ownerId to be updated
     * @param centerName to be updated
     * @param location to be updated
     * @param slots to be updated
     * @return to be updated
     */
    public boolean registerCenter(int ownerId, String centerName, String location, int slots);

    // Adds a new slot to an existing gym center

    /**
     *
     * @param centerId to be updated
     * @param slot to be updated
     * @return to be updated
     */
    public boolean addnewSlot(int centerId, GymSlots slot);

    // Deletes an existing slot from a gym center based on start time

    /**
     *
     * @param centerId to be updated
     * @param startTime to be updated
     * @return to be updated
     */
    public boolean deleteSlot(int centerId, LocalTime startTime);

    // Deletes a gym center

    /**
     *
     * @param centerId to be updated
     * @return to be updated
     */
    public boolean deleteCenter(int centerId);

    // Allows the gym owner to edit their profile details

    /**
     *
     * @param owner to be updated
     * @return to be updated
     */
    public boolean editProfile(GymOwner owner);

    // Allows the gym owner to create a new profile

    /**
     *
     * @param owner to be updated
     * @return to be updated
     */
    public boolean createProfile(GymOwner owner);

    // Updates the password for the gym owner

    /**
     *
     * @param email to be updated
     * @param password to be updated
     * @param role to be updated
     * @return to be updated
     */
    public boolean updatepwd(String email, String password, String role);

}
