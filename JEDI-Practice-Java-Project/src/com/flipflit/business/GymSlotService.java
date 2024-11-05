package com.flipflit.business;

import com.flipflit.bean.GymSlot;

import java.util.List;

public interface GymSlotService {

    public void updateSlotInfo(int centerId, List<GymSlot> slots, String address, int ownerID);
    public void getSlotInfo(int centerId);
    public void bookSlot(int userID, int slotId, int centreId);
    public void cancelSlot(int slotId, int userId);

}
