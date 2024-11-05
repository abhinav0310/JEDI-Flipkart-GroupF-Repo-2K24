package com.flipflit.bean;

import java.util.List;

public class GymAdmin extends GymUser{

    public GymAdmin(int userId, String firstName, String lastName, String userEmailId, String password, String phoneNo, int age, Role role, Address address, List<GymBookings> bookingList) {
        super(userId, firstName, lastName, userEmailId, password, phoneNo, age, role, address, bookingList);
    }

    public String adminEmailId;
    public int userId;
    private String password;



    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAdminEmailId() {
        return adminEmailId;
    }

    public void setAdminEmailId(String adminEmailId) {
        this.adminEmailId = adminEmailId;
    }

    public int getAdminId() {
        return userId;
    }

    public void setAdminId(int adminId) {
        this.userId = adminId;
    }
}
