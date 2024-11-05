package com.flipflit.business;

public interface GymUserService {
    public void signIn(String email, String password);
    public void signUp(String email, String password, String name, String address, String phone);
    public void viewProfile(int userID);
    public void updateProfile(int userID, String email, String password, String name, String address, String phone);
    public void viewAvailableSlots(int centerID);
    public void viewCenters();
}
