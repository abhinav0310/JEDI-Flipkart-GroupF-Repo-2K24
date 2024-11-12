package com.flipfit.bean;

public class GymOwner {
    // Properties of the GymOwner class with their respective getters and setters

    // Unique ID for the gym owner
    private int ownerId;
    // Name of the gym owner
    private String ownerName;
    // Email address of the gym owner
    private String ownerEmailAddress;
    // Phone number of the gym owner
    private String ownerPhone;
    // Address of the gym owner
    private String ownerAddress;
    // Password for owner authentication
    private String password;

    // Getter method for password

    /**
     *
     * @return to be updated
     */
    public String getPassword() {
        return password;  // Return the password
    }

    // Setter method for password

    /**
     *
     * @param password to be updated
     */
    public void setPassword(String password) {
        this.password = password;  // Set the password
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

    // Getter method for ownerName

    /**
     *
     * @return to be updated
     */
    public String getOwnerName() {
        return ownerName;  // Return the ownerName
    }

    // Setter method for ownerName

    /**
     *
     * @param ownerName to be updated
     */
    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;  // Set the ownerName
    }

    // Getter method for ownerEmailAddress
    public String getOwnerEmailAddress() {
        return ownerEmailAddress;  // Return the ownerEmailAddress
    }

    // Setter method for ownerEmailAddress

    /**
     *
     * @param ownerEmailAddress to be updated
     */
    public void setOwnerEmailAddress(String ownerEmailAddress) {
        this.ownerEmailAddress = ownerEmailAddress;  // Set the ownerEmailAddress
    }

    // Getter method for ownerPhone

    /**
     *
     * @return to be updated
     */
    public String getOwnerPhone() {
        return ownerPhone;  // Return the ownerPhone
    }

    // Setter method for ownerPhone

    /**
     *
     * @param ownerPhone to be updated
     */
    public void setOwnerPhone(String ownerPhone) {
        this.ownerPhone = ownerPhone;  // Set the ownerPhone
    }

    // Getter method for ownerAddress

    /**
     *
     * @return to be updated
     */
    public String getOwnerAddress() {
        return ownerAddress;  // Return the ownerAddress
    }

    // Setter method for ownerAddress

    /**
     *
     * @param ownerAddress to be updated
     */
    public void setOwnerAddress(String ownerAddress) {
        this.ownerAddress = ownerAddress;  // Set the ownerAddress
    }

    // Constructor to initialize GymOwner with name, email, phone, address, and password

    /**
     *
     * @param ownerName to be updated
     * @param ownerEmailAddress to be updated
     * @param ownerPhone to be updated
     * @param ownerAddress to be updated
     * @param password to be updated
     */

    public GymOwner(String ownerName, String ownerEmailAddress, String ownerPhone, String ownerAddress, String password) {
        this.ownerName = ownerName;  // Set the ownerName
        this.ownerEmailAddress = ownerEmailAddress;  // Set the ownerEmailAddress
        this.ownerPhone = ownerPhone;  // Set the ownerPhone
        this.ownerAddress = ownerAddress;  // Set the ownerAddress
        this.password = password;  // Set the password
    }

    // Constructor to initialize GymOwner with all fields including ownerId

    /**
     *
     * @param ownerId to be updated
     * @param ownerName to be updated
     * @param ownerEmailAddress to be updated
     * @param ownerPhone to be updated
     * @param ownerAddress to be updated
     * @param password to be updated
     */
    public GymOwner(int ownerId, String ownerName, String ownerEmailAddress, String ownerPhone, String ownerAddress, String password) {
        this.ownerId = ownerId;  // Set the ownerId
        this.ownerName = ownerName;  // Set the ownerName
        this.ownerEmailAddress = ownerEmailAddress;  // Set the ownerEmailAddress
        this.ownerPhone = ownerPhone;  // Set the ownerPhone
        this.ownerAddress = ownerAddress;  // Set the ownerAddress
        this.password = password;  // Set the password
    }
}
