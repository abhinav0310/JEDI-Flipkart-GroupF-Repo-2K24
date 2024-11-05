package com.flipflit.bean;

import java.util.List;

public class GymOwner extends GymUser {

    public GymOwner(int userId, String firstName, String lastName, String userEmailId, String password, String phoneNo, int age, Role role, Address address, List<GymBookings> bookingList) {
        super(userId, firstName, lastName, userEmailId, password, phoneNo, age, role, address, bookingList);
    }

    private String panNumber;
    private List<String> gymCentreIDs;
    private int accountNo;
    private String IFSCCode;
    private boolean isApproved;

    public String getPanNumber() {
        return panNumber;
    }

    public void setPanNumber(String panNumber) {
        this.panNumber = panNumber;
    }

    public List<String> getGymCentreIDs() {
        return gymCentreIDs;
    }

    public void setGymCentreIDs(List<String> gymCentreIDs) {
        this.gymCentreIDs = gymCentreIDs;
    }

    public int getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(int accountNo) {
        this.accountNo = accountNo;
    }

    public String getIFSCCode() {
        return IFSCCode;
    }

    public void setIFSCCode(String IFSCCode) {
        this.IFSCCode = IFSCCode;
    }

    public boolean isApproved() {
        return isApproved;
    }

    public void setApproved(boolean approved) {
        isApproved = approved;
    }
}
