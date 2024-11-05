package com.flipflit.business;

import com.flipflit.bean.Address;
import com.flipflit.bean.GymSlot;

import java.util.List;

public interface GymCenterService {
    public void updateCenterInfo(int centerId, List<GymSlot> slots, Address address, int ownerID);
    public void getCenterInfo(int centerId);
    public void viewAvailableSlots(int centerId);
}
