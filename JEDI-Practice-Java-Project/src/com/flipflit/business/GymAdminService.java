package com.flipflit.business;

import com.flipflit.bean.GymCenter;
import com.flipflit.bean.GymOwner;

import java.util.List;

public interface GymAdminService {

    void approveGymCenter(String gymCentreId, boolean isApproved);

    void approveGymOwner(String gymOwnerId, boolean isApproved);

    List<GymCenter> viewPendingGymCentres();

    List<GymOwner> viewPendingGymOwners();

    boolean isUserValid(String userName, String password);
}
