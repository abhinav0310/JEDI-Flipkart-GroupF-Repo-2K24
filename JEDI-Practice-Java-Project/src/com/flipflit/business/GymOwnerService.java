package com.flipflit.business;

import java.time.LocalDateTime;
import java.util.List;

public interface GymOwnerService {
    public void addCenter(String address, int ownerID,int capacity);
    public void viewCenter(int centerID);
    public void updateCenter(int centerID, String address);
    public void removeCenter(int centerID);
    public void addSlot(int centerID, LocalDateTime slotTime);
    public void removeSlot(int slotID);
    public void updateSlot(int slotID);
    public void viewCustomers(int centerID);
    public void viewPayments(int centerID);
}
