package com.flipfit.rest;

import javax.ws.rs.PathParam;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.*;

import com.flipfit.bean.*;
import com.flipfit.business.*;

@Path("/admin-menu")
@Produces(MediaType.APPLICATION_JSON)
public class FlipFitAdminRestController {
    GymAdminBusiness service = new GymAdminBusinessImpl();
    GymUserBusiness userService = new GymUserBusinessImpl();

    @GET
    @Path("/viewbookings")
    public List<GymBooking> viewBookings() {

        return service.viewBookings();
    }

    @GET
    @Path("/test")
    public String test() {
        return "Test";
    }


    @GET
    @Path("/viewcustomers")
    public List<GymCustomer> viewCustomer() {
        return userService.viewAllCustomers();

    }

    @GET
    @Path("/viewowners")
    public List<GymOwner> viewOwner() {
        return userService.viewAllGymOwners();
    }

    @GET
    @Path("/viewpendingrequests")
    public List<GymOwnerRequest> viewPendingRequests() {
        return service.pendingRequests();
    }

    @PUT
    @Path("/{requestId}/updateOwnerRequest")
    public String approveOwnerRequest(@PathParam("requestId") Integer requestId) {
        service.approveOwnerRegistration(requestId, "approve");
        return "Approved";
    }

}