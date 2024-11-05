package com.flipflit.business;

import java.util.Date;

public interface GymCustomerService {

    public void bookSlot(int userID, Date date, int slotId, int centreId);
    public void cancelSlot (int slotId, int userId);
    public void showBookings(int userId);
    public void makePayments(int userId, int amount, int slotId);
    
}

