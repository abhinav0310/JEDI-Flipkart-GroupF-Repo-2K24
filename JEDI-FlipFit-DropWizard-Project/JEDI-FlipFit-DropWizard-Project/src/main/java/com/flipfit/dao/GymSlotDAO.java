package com.flipfit.dao;

import java.util.Date;

public interface GymSlotDAO {
    /**
     *
     * @param slotId to be updated
     * @param date to be updated
     * @param TotalSeats to be updated
     * @return to be updated
     */
    public int getNumAvailableSeats(int slotId, Date date, int TotalSeats);
}
