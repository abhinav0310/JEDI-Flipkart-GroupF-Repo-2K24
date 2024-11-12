package com.flipfit.bean;

public class GymOwnerRequest {
    // Properties of the GymOwnerRequest class with their respective getters and setters

    // Unique request ID
    private int requestId;
    // ID of the owner making the request
    private int ownerId;
    // Status of the request (e.g., pending, approved, rejected)
    private String status;
    // Name of the gym center requested
    private String centerName;
    // Location of the gym center requested
    private String centerLocation;
    // Number of slots requested for the gym center
    private int NumOfSlots;

    // Getter method for requestId

    /**
     *
     * @return to be updated
     */
    public int getRequestId() {
        return requestId;  // Return the requestId
    }

    // Setter method for requestId

    /**
     *
     * @param requestId to be updated
     */
    public void setRequestId(int requestId) {
        this.requestId = requestId;  // Set the requestId
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

    // Getter method for status

    /**
     *
     * @return to be updated
     */
    public String getStatus() {
        return status;  // Return the status
    }

    // Setter method for status

    /**
     *
     * @param status to be updated
     */
    public void setStatus(String status) {
        this.status = status;  // Set the status
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

    /**
     *
     * @param centerLocation to be updated
     */
    // Setter method for centerLocation
    public void setCenterLocation(String centerLocation) {
        this.centerLocation = centerLocation;  // Set the centerLocation
    }

    // Getter method for NumOfSlots

    /**
     *
     * @return to be updated
     */
    public int getNumOfSlots() {
        return NumOfSlots;  // Return the NumOfSlots
    }

    // Setter method for NumOfSlots

    /**
     *
     * @param numOfSlots to be updated
     */
    public void setNumOfSlots(int numOfSlots) {
        NumOfSlots = numOfSlots;  // Set the NumOfSlots
    }

    // Constructor to initialize GymOwnerRequest with requestId, ownerId, status, centerName, centerLocation, and NumOfSlots

    /**
     *
     * @param requestId to be updated
     * @param ownerId to be updated
     * @param status to be updated
     * @param centerName to be updated
     * @param centerLocation to be updated
     * @param numOfSlots to be updated
     */
    public GymOwnerRequest(int requestId, int ownerId, String status, String centerName, String centerLocation, int numOfSlots) {
        this.requestId = requestId;  // Set the requestId
        this.ownerId = ownerId;  // Set the ownerId
        this.status = status;  // Set the status
        this.centerName = centerName;  // Set the centerName
        this.centerLocation = centerLocation;  // Set the centerLocation
        NumOfSlots = numOfSlots;  // Set the NumOfSlots
    }
}
