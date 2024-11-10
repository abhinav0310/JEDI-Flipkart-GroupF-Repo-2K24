package com.flipfit.business.interfaces;

import com.flipfit.bean.FlipFitGymCentre;
import com.flipfit.bean.FlipFitSlots;

import java.util.List;

public interface IFlipFitGymCentre {
    public FlipFitGymCentre updateGymCentre(FlipFitGymCentre flipFitGymCentre);
    public boolean deleteGymCentre(int centreId);
    public List<FlipFitSlots> viewAvailableSlots(int centreId);
}
