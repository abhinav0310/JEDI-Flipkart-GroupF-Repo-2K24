package com.flipflit.business;

import com.flipflit.bean.GymCenter;
import com.flipflit.bean.GymOwner;

import java.util.List;

public class GymAdminServiceImpl implements GymAdminService{

    @Override
    public void approveGymCenter(String gymCentreId, boolean isApproved) {

    }

    @Override
    public void approveGymOwner(String gymOwnerId, boolean isApproved) {

    }

    @Override
    public List<GymCenter> viewPendingGymCentres() {
        return List.of();
    }

    @Override
    public List<GymOwner> viewPendingGymOwners() {
        return List.of();
    }

    @Override
    public boolean isUserValid(String userName, String password) {
        return false;
    }
}
