package com.flipfit.business;

import com.flipfit.bean.*;
import com.flipfit.business.interfaces.IFlipFitGymOwner;
import com.flipfit.dao.*;
import com.flipfit.dao.interfaces.IFlipFitGymOwnerDAO;
//import com.flipfit.exceptions.InvalidChoiceException;
import java.util.List;

public class FlipFitGymOwnerBusiness implements IFlipFitGymOwner {
    private final IFlipFitGymOwnerDAO flipFitGymOwnerDAO ;

    public FlipFitGymOwnerBusiness(FlipFitGymOwnerDAOImpl FFOwner){
        this.flipFitGymOwnerDAO= FFOwner;
    }

    public FlipFitGymCentre addCentre(FlipFitGymCentre flipFitGymCentre){
        return flipFitGymOwnerDAO.addCentre(flipFitGymCentre);
    }

    public FlipFitSlots addSlot(FlipFitSlots flipFitSlot){
        FlipFitSlotDAOImpl flipFitSlotDAOImpl = new FlipFitSlotDAOImpl();
        flipFitSlotDAOImpl.addSlot(flipFitSlot);
        return flipFitSlot;
    }

    public List<FlipFitGymCentre> viewCentres(FlipFitGymOwner flipFitGymOwner) {
        System.out.println("Centres listed:> ");
        return flipFitGymOwnerDAO.viewCentresByOwnerID(flipFitGymOwner);
    }

    public List<FlipFitPayments> viewPayments() {
        System.out.println("Payments listed:> ");
        return null;
    }
    public FlipFitGymOwner editDetails(FlipFitGymOwner owner) {
        return flipFitGymOwnerDAO.editDetails(owner);
    }
    public FlipFitGymOwner registerOwner(FlipFitGymOwner GymOwner) {

        FlipFitUser user = new FlipFitUser();
        user.setPassword(GymOwner.getPassword());
        user.setEmailID(GymOwner.getEmailID());
        user.setPhoneNumber(GymOwner.getPhoneNumber());
        user.setUserName(GymOwner.getUserName());
        user.setRoleID(1);
        GymOwner.setRole(1);

        user=flipFitGymOwnerDAO.addUser(user);
        return flipFitGymOwnerDAO.addGymOwner(GymOwner, user);
    }
    @Override
    public FlipFitUser login(FlipFitUser flipFitUser) {
        FlipFitUserDAOImpl userDAO = new FlipFitUserDAOImpl();
        flipFitUser.setRoleID(1);
        flipFitUser=userDAO.loginAsOwner(flipFitUser.getEmailID(), flipFitUser.getPassword());
        return flipFitUser;
    }
}
