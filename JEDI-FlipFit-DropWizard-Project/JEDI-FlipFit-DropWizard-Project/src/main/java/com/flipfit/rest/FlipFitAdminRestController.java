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


/**
 * This class provides REST API endpoints for managing the administrative operations of the Gym.
 * It offers endpoints to view bookings, customers, gym owners, pending requests, and approve owner registrations.
 */
@Path("/admin-menu")
@Produces(MediaType.APPLICATION_JSON)
public class FlipFitAdminRestController {
    GymAdminBusiness service = new GymAdminBusinessImpl();
    GymUserBusiness userService = new GymUserBusinessImpl();

    /**
     * Endpoint to view all gym bookings.
     *
     * @return A list of GymBooking objects representing all bookings in the system.
     */
    @GET
    @Path("/viewbookings")
    public List<GymBooking> viewBookings() {

        return service.viewBookings();
    }

    /**
     * Test endpoint to check if the API is functioning.
     *
     * @return A simple string "Test" to confirm the API is working.
     */
    @GET
    @Path("/test")
    public String test() {
        return "Test";
    }

    /**
     * Endpoint to view all customers in the gym system.
     *
     * @return A list of GymCustomer objects representing all customers.
     */
    @GET
    @Path("/viewcustomers")
    public List<GymCustomer> viewCustomer() {
        return userService.viewAllCustomers();

    }
    /**
     * Endpoint to view all gym owners in the system.
     *
     * @return A list of GymOwner objects representing all gym owners.
     */
    @GET
    @Path("/viewowners")
    public List<GymOwner> viewOwner() {
        return userService.viewAllGymOwners();
    }
    /**
     * Endpoint to view all pending owner registration requests.
     *
     * @return A list of GymOwnerRequest objects representing the pending requests.
     */
    @GET
    @Path("/viewpendingrequests")
    public List<GymOwnerRequest> viewPendingRequests() {
        return service.pendingRequests();
    }
    /**
     * Endpoint to approve a pending owner registration request.
     *
     * @param requestId The ID of the registration request to approve.
     * @return A string message indicating the request has been approved.
     */
    @PUT
    @Path("/{requestId}/updateOwnerRequest")
    public String approveOwnerRequest(@PathParam("requestId") Integer requestId) {
        service.approveOwnerRegistration(requestId, "approve");
        return "Approved";
    }

}