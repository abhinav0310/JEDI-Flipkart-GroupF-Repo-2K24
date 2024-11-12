package com.flipfit.bean;

/**
 *
 */
public class GymCenter {
    // centerId: Unique identifier for the gym center
    // ownerId: The ID of the owner of the gym center
    // gymName: Name of the gym center
    // gymLocation: Location of the gym center
    // numOfSlots: Number of available slots in the gym center
    private int centerId;  // Unique ID for the gym center
    private int ownerId;  // ID of the gym center owner
    private String gymName;  // Name of the gym center
    private String gymLocation;  // Location of the gym center
    private int numOfSlots;  // Number of slots in the gym center

    // Getter method for centerId

    /**
     *
     * @return to be updated
     */
    public int getId() {
        return centerId;  // Return the centerId
    }

    // Setter method for centerId

    /**
     *
     * @param id to be updated
     */
    public void setId(int id) {
        this.centerId = centerId;  // Set the centerId
    }

    // Getter method for gymName
    public String getGymName() {
        return gymName;  // Return the gymName
    }

    // Setter method for gymName

    /**
     *
     * @param gymName to be updated
     */
    public void setGymName(String gymName) {
        this.gymName = gymName;  // Set the gymName
    }

    // Getter method for gymLocation

    /**
     *
     * @return to be updated
     */
    public String getGymLocation() {
        return gymLocation;  // Return the gymLocation
    }

    // Setter method for gymLocation

    /**
     *
     * @param gymLocation to be updated
     */
    public void setGymLocation(String gymLocation) {
        this.gymLocation = gymLocation;  // Set the gymLocation
    }

    // Getter method for numOfSlots

    /**
     *
     * @return to be updated
     */
    public int getNumOfSlots() {
        return numOfSlots;  // Return the number of slots
    }

    // Setter method for numOfSlots

    /**
     *
     * @param numOfSlots to be updated
     */
    public void setNumOfSlots(int numOfSlots) {
        this.numOfSlots = numOfSlots;  // Set the number of slots
    }

    // Getter method for ownerId

    /**
     *
     * @return to be updated
     */
    public int getOwnerId() {
        return ownerId;  // Return the ownerId
    }

    // Setter method for ownerId

    /**
     *
     * @param ownerId to be updated
     */
    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;  // Set the ownerId
    }

    // Getter method for centerId

    /**
     *
     * @return to be updated
     */
    public int getCenterId() {
        return centerId;  // Return the centerId
    }

    // Constructor to initialize all fields of the GymCenter object

    /**
     *
     * @param centerId to be updated
     * @param ownerId to be updated
     * @param gymName to be updated
     * @param gymLocation to be updated
     * @param numOfSlots to be updated
     */
    public GymCenter(int centerId, int ownerId, String gymName, String gymLocation, int numOfSlots) {
        this.centerId = centerId;  // Set centerId
        this.ownerId = ownerId;  // Set ownerId
        this.gymName = gymName;  // Set gymName
        this.gymLocation = gymLocation;  // Set gymLocation
        this.numOfSlots = numOfSlots;  // Set numOfSlots
    }
}
