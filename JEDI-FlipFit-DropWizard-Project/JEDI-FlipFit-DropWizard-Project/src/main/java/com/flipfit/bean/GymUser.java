package com.flipfit.bean;

public class GymUser {
    // Fields representing the details of a gym user
    private int userId;          // Unique ID for the user
    private String userName;     // Name of the user
    private int userPhone;       // Phone number of the user
    private int userLocation;    // Location of the user (could represent a code or area ID)
    private int userPassword;    // User's password (currently stored as an integer, which might need revisiting for security)

    // Getter for the user ID

    /**
     *
     * @return to be updated
     *
     */
    public int getUserId() {
        return userId;  // Returns the unique ID of the user
    }

    // Setter for the user ID

    /**
     *
     * @param userId to be updated
     */
    public void setUserId(int userId) {
        this.userId = userId;  // Sets the user ID
    }

    // Getter for the user name

    /**
     *
     * @return to be updated
     */
    public String getUserName() {
        return userName;  // Returns the name of the user
    }

    // Setter for the user name

    /**
     *
     * @param userName to be updated
     */
    public void setUserName(String userName) {
        this.userName = userName;  // Sets the name of the user
    }

    // Getter for the user phone number

    /**
     *
     * @return to be updated
     */
    public int getUserPhone() {
        return userPhone;  // Returns the phone number of the user
    }

    // Setter for the user phone number

    /**
     *
     * @param userPhone to be updated
     */
    public void setUserPhone(int userPhone) {
        this.userPhone = userPhone;  // Sets the phone number of the user
    }

    // Getter for the user location

    /**
     *
     * @return to be updated
     */
    public int getUserLocation() {
        return userLocation;  // Returns the location of the user
    }

    // Setter for the user location

    /**
     *
     * @param userLocation to be updated
     */
    public void setUserLocation(int userLocation) {
        this.userLocation = userLocation;  // Sets the location of the user
    }

    // Getter for the user password

    /**
     *
     * @return to be updated
     */
    public int getUserPassword() {
        return userPassword;  // Returns the user's password
    }

    // Setter for the user password

    /**
     *
     * @param userPassword to be updated
     */
    public void setUserPassword(int userPassword) {
        this.userPassword = userPassword;  // Sets the user's password
    }
}
