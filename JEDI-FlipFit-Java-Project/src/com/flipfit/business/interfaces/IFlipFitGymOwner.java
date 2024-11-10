package com.flipfit.business.interfaces;

//import com.flipfit.exceptions.InvalidChoiceException;
import com.flipfit.bean.*;

import java.util.List;

public interface IFlipFitGymOwner {
    public FlipFitGymCentre addCentre(FlipFitGymCentre flipFitGymCentre);
    public List<FlipFitGymCentre> viewCentres(FlipFitGymOwner flipFitGymOwner);
//    public  List<FlipFitUser> viewFlipFitCustomers(FlipFitGymCentre flipFitGymCentre);
    public List<FlipFitPayments> viewPayments();
    public FlipFitGymOwner editDetails(FlipFitGymOwner flipFitGymOwner);
    public FlipFitGymOwner registerOwner(FlipFitGymOwner owner);
    public FlipFitUser login(FlipFitUser user);

    FlipFitSlots addSlot(FlipFitSlots flipFitSlot);
}
