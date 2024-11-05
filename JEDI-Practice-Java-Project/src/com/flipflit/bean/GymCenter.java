package com.flipflit.bean;

import java.util.List;

public class GymCenter {

    private int gymId;
    private int gymOwnerId;
    private String gymName;
    private String gymAddress;
    private int capacity;
    List<GymSlot> slots;


    private int gymCenterFee;

    public GymCenter(int gymId, int gymOwnerId, String gymName, String gymAddress, int capacity, List<GymSlot> slots, int gymCenterFee) {
        this.gymId = gymId;
        this.gymOwnerId = gymOwnerId;
        this.gymName = gymName;
        this.gymAddress = gymAddress;
        this.capacity = capacity;
        this.slots = slots;
        this.gymCenterFee = gymCenterFee;
    }

    public int getGymId() {
        return gymId;
    }

    public void setGymId(int gymId) {
        this.gymId = gymId;
    }

    public int getGymOwnerId() {
        return gymOwnerId;
    }

    public void setGymOwnerId(int gymOwnerId) {
        this.gymOwnerId = gymOwnerId;
    }
    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getGymName() {
        return gymName;
    }

    public void setGymName(String gymName) {
        this.gymName = gymName;
    }

    public String getGymAddress() {
        return gymAddress;
    }

    public void setGymAddress(String gymAddress) {
        this.gymAddress = gymAddress;
    }

    public List<GymSlot> getSlots() {
        return slots;
    }

    public void setSlots(List<GymSlot> slots) {
        this.slots = slots;
    }

    public int getGymCenterFee() {
        return gymCenterFee;
    }

    public void setGymCenterFee(int gymCenterFee) {
        this.gymCenterFee = gymCenterFee;
    }

}
