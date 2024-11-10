package com.flipfit.business.interfaces;

import com.flipfit.bean.FlipFitSlots;
import com.flipfit.dao.FlipFitSlotDAOImpl;

public interface IFlipFitSlots {
    public boolean updateAvailability(FlipFitSlots flipFitSlots);
    public void getSlotDetails();
}
