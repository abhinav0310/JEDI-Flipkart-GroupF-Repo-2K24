package com.flipfit.business;

import com.flipfit.bean.FlipFitSlots;
import com.flipfit.business.interfaces.IFlipFitSlots;
import com.flipfit.dao.*;
import com.flipfit.dao.interfaces.IFlipFitGymOwnerDAO;
import com.flipfit.dao.interfaces.IFlipFitSlotDAO;

public class FlipFitSlotsBusiness implements IFlipFitSlots {


    public boolean updateAvailability(FlipFitSlots flipFitSlots) {
        System.out.println("Updating Slot Availability");
        FlipFitSlotDAOImpl flipFitSlotDAO = new FlipFitSlotDAOImpl();
        flipFitSlotDAO.changeSlot(flipFitSlots);
        return true;
    }

    public void getSlotDetails() {
        System.out.println("Getting Slot Details");
        FlipFitSlotDAOImpl flipFitSlotDAO = new FlipFitSlotDAOImpl();
    }
}

