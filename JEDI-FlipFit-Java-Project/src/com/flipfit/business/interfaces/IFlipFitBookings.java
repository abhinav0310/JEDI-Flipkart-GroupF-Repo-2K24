package com.flipfit.business.interfaces;

import com.flipfit.bean.FlipFitBooking;

public interface IFlipFitBookings{
    public FlipFitBooking makeBooking(int userID, int centreID, int startTime);
    public boolean deleteBooking(int bookingId);
}