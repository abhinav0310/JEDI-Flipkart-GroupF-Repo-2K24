package com.flipfit.bean;

/**
 * to be updated
 */
public class GymAdmin {
    private int adminId;  // Stores the admin ID
    private String adminName;  // Stores the admin's name
    private String adminEmailAddress;  // Stores the admin's email address
    private int phone;  // Stores the admin's phone number
    private String password;  // Stores the admin's password



    /**
     *
     * @return
     */
    public int getAdminPhone() {
        return phone;  // Return the admin's phone number
    }



    /**
     *
     * @param phone
     */
    public void setAdminPhone(int phone) {
        this.phone = phone;  // Set the admin's phone number
    }

    /**
     *
     * @return
     */
    public String getPassword() {
        return password;  // Return the admin's password
    }

    // Setter method for password

    /**
     *
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;  // Set the admin's password
    }

    // Getter method for adminId

    /**
     *
     * @return to be updated
     */
    public int getAdminId() {
        return adminId;  // Return the admin ID
    }

    // Setter method for adminId

    /**
     * Sets the ID of the administrator.
     *
     * This method assigns the provided admin ID to the instance's adminId field.
     * It is used to update the administrator's identifier for this particular object.
     *
     * @param adminId The unique identifier of the administrator.
     */
    public void setAdminId(int adminId) {
        this.adminId = adminId;  // Set the admin ID
    }

    // Getter method for adminName

    /**
     *
     * @return adminID
     */
    public String getAdminName() {
        return adminName;  // Return the admin's name
    }

    // Setter method for adminName

    /**
     *
     * @param adminName get adminID
     */
    public void setAdminName(String adminName) {
        this.adminName = adminName;  // Set the admin's name
    }

    // Getter method for adminEmailAddress

    /**
     *
     * @return adminEmail Address
     */
    public String getAdminEmailAddress() {
        return adminEmailAddress;  // Return the admin's email address
    }

    // Setter method for adminEmailAddress

    /**
     *
     * @param adminEmailAddress to be updated
     */
    public void setAdminEmailAddress(String adminEmailAddress) {
        this.adminEmailAddress = adminEmailAddress;  // Set the admin's email address
    }
}
