package com.flipfit.dao.interfaces;

import com.flipfit.bean.*;

import java.util.List;

public interface IFlipFitAdminDAO {
    public boolean adminLogin(FlipFitAdmin flipFitAdmin);

    public List<FlipFitGymOwner> getPendingOwnerList();

    public List<FlipFitGymOwner> getApprovedOwnerList();

    public List<FlipFitGymCustomer> getUserList();

    public List<FlipFitGymCentre> getGymCentreUsingOwnerId(int ownerId);

    public boolean validateOwner(int ownerId);

    public boolean deleteOwner(int ownerId);

}