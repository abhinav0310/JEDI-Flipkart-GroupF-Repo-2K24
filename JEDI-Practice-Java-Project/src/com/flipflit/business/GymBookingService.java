package com.flipflit.business;

import com.flipflit.bean.GymBookings;

import java.util.Date;
import java.util.List;

public interface GymBookingService {
    public void makeBooking(int userId, int slotId, int centreId, boolean isAvailable);
    public void cancelBooking(int bookingId, int userId);
}
