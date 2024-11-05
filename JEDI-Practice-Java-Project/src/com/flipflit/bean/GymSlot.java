package com.flipflit.bean;

import java.util.List;
import java.time.LocalDateTime;

public class GymSlot {
    private String slotId;
    private int centerId;
    private int noOfSeatsAvailable;
    private int waitlistCount;
    private LocalDateTime slotTime;
    List<GymUser> Users;

    public GymSlot(LocalDateTime slotTime, int noOfSeatsAvailable, int waitlistCount, List<GymUser> users, String slotId) {
        this.slotTime = slotTime;
        this.noOfSeatsAvailable = noOfSeatsAvailable;
        this.waitlistCount = waitlistCount;
        Users = users;
        this.slotId = slotId;
    }

    public String getSlotId() {
        return slotId;
    }

    public void setSlotId(String slotId) {
        this.slotId = slotId;
    }

    public int getCenterId() {
        return centerId;
    }

    public void setCenterId(int centerId) {
        this.centerId = centerId;
    }

    public LocalDateTime getStartTime() {
        return slotTime;
    }

    public void setStartTime(LocalDateTime slotTime) {
        this.slotTime = slotTime;
    }

    public int getNoOfSeatsAvailable() {
        return noOfSeatsAvailable;
    }

    public void setNoOfSeatsAvailable(int noOfSeatsAvailable) {
        this.noOfSeatsAvailable = noOfSeatsAvailable;
    }

    public int getWaitlistCount() {
        return waitlistCount;
    }

    public void setWaitlistCount(int waitlistCount) {
        this.waitlistCount = waitlistCount;
    }

    public List<GymUser> getUsers() {
        return Users;
    }

    public void setUsers(List<GymUser> users) {
        Users = users;
    }

}
