package com.flipfit.business;

import java.util.Date;

public interface GymSlotsBusiness {

    // Method to get the number of available seats for a specific slot and date.
    // @param slotId - The ID of the gym slot
    // @param date - The date for which the availability is being checked
    // @param TotalSeats - The total number of seats available in the slot
    // @return The number of available seats for the given slot and date

    /**
     *
     * @param slotId to be updated
     * @param date to be updated
     * @param TotalSeats to be updated
     * @return to be updated
     */
    public int getNumAvailableSeats(int slotId, Date date, int TotalSeats);

}
