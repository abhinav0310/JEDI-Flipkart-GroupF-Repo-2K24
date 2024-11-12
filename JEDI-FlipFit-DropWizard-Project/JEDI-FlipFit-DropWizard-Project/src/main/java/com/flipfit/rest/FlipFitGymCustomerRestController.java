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

import java.text.SimpleDateFormat;
import javax.ws.rs.Consumes;
import javax.ws.rs.QueryParam;
import javax.ws.rs.*;

@Path("/customer-menu")
@Produces(MediaType.APPLICATION_JSON)
public class FlipFitGymCustomerRestController {
    GymCustomerBusiness service = new GymCustomerBusinessImpl();
    GymCenterBusiness centerBusiness = new GymCenterBusinessImpl();
    GymAdminBusiness ser = new GymAdminBusinessImpl();

    public Date stringtodate(String dat) {

        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Date date = sdf.parse(dat);
            return date;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Creates a new gym customer profile.
     *
     * @param name the name of the customer
     * @param email the email address of the customer
     * @param address the address of the customer
     * @param password the password for the customer account
     * @param contact the contact number of the customer
     * @return a success message if the profile is created, otherwise an error message
     */
    @POST
    @Path("/createProfile")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public String createProfile(
            @FormParam("name") String name,
            @FormParam("email") String email,
            @FormParam("address") String address,
            @FormParam("password") String password,
            @FormParam("contact") String contact
    ) {
        GymCustomer newCustomer = new GymCustomer(name, address, email, contact, password);
        boolean isCreated = service.createProfile(newCustomer);
        if (isCreated) {
            return "Customer profile created successfully!";
        } else {
            return "Failed to create customer profile. Please try again.";
        }
    }

    @GET
    @Path("/{customerId}/viewBookings")
    public List<GymBooking> viewBookings(@PathParam("customerId") Integer customerId) {
        return service.viewBookings(customerId);
    }

    @GET
    @Path("/viewcenters")
    public List<GymCenter> viewCenters() {
        return ser.viewCenter();
    }

    @GET
    @Path("/{centerId}/viewslots")
    public List<GymSlots> viewSlots(@PathParam("centerId") Integer centerId, String date) {

        return centerBusiness.viewSlots(centerId, stringtodate((date)));
    }

    @POST
    @Path("/{slotid}/bookaslot")
    public String bookaslot(@QueryParam("custId") Integer custId, @QueryParam("centerId") Integer centerId, @QueryParam("date") String date, @PathParam("slotid") Integer slotid) {
        int bookingId = service.createBooking(custId, slotid, centerId, stringtodate(date));

        String str = "Slot Booked with Booking Id: " + bookingId;
        return str;


    }

    @DELETE
    @Path("/{bookingid}/{custid}/cancelbooking")
    public String cancelBooking(@PathParam("bookingid") Integer bookingid, @PathParam("custid") Integer custid) {
        if (service.cancelBooking(custid, bookingid)) {
            return "Booking Canceled Successfully";
        } else
            return "Booking Canceled Failed";
    }

    @PUT
    @Path("/editprofile")
    public String editprofile(
            @FormParam("name") String name,
            @FormParam("email") String email,
            @FormParam("address") String address,
            @FormParam("pwd") String pwd,
            @FormParam("contact") String contact,
            @FormParam("custId") Integer custId
    ) {
        GymCustomer customer = new GymCustomer(name, address, email, contact, pwd);
        customer.setCustomerId(custId);
        // Call service to update the profile
        if (service.editProfile(customer)) {
            return "Profile Edited Successfully";

        } else
            return "failed";
    }

}

