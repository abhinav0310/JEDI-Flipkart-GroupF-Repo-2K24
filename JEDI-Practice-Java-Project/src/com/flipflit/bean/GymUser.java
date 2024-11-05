package com.flipflit.bean;

import java.util.List;

public class GymUser {

    private int userId;
    private String firstName;
    private String lastName;
    private String userEmailId;
    private String password;
    private String phoneNo;
    private int age;
    private Role role;
    private Address address;
    List<GymBookings> bookingList;

    public GymUser(int userId, String firstName, String lastName, String userEmailId, String password, String phoneNo, int age, Role role, Address address, List<GymBookings> bookingList) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userEmailId = userEmailId;
        this.password = password;
        this.phoneNo = phoneNo;
        this.age = age;
        this.role = role;
        this.address = address;
        this.bookingList = bookingList;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserEmailId() {
        return userEmailId;
    }

    public void setUserEmailId(String userEmailId) {
        this.userEmailId = userEmailId;
    }

    public List<GymBookings> getBookingList() {
        return bookingList;
    }

    public void setBookingList(List<GymBookings> bookingList) {
        this.bookingList = bookingList;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
