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

/**
 * This class provides REST API endpoints for managing the gym customer's operations.
 * It offers endpoints to create a profile, view bookings, view gym centers, book slots,
 * cancel bookings, and edit the customer profile.
 */
@Path("/customer-menu")
@Produces(MediaType.APPLICATION_JSON)
public class FlipFitGymCustomerRestController {
    GymCustomerBusiness service = new GymCustomerBusinessImpl();
    GymCenterBusiness centerBusiness = new GymCenterBusinessImpl();
    GymAdminBusiness ser = new GymAdminBusinessImpl();

    /**
     * Converts a date string (dd/MM/yyyy) into a Date object.
     *
     * @param dat The date string to convert.
     * @return The corresponding Date object, or null if the parsing fails.
     */
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

    /**
     * Endpoint to view all bookings made by a customer.
     *
     * @param customerId The ID of the customer whose bookings are to be retrieved.
     * @return A list of GymBooking objects representing the bookings made by the customer.
     */
    @GET
    @Path("/{customerId}/viewBookings")
    public List<GymBooking> viewBookings(@PathParam("customerId") Integer customerId) {
        return service.viewBookings(customerId);
    }

    /**
     * Endpoint to view all available gym centers.
     *
     * @return A list of GymCenter objects representing all gym centers.
     */
    @GET
    @Path("/viewcenters")
    public List<GymCenter> viewCenters() {
        return ser.viewCenter();
    }

    /**
     * Endpoint to view available slots for a specific gym center on a specific date.
     *
     * @param centerId The ID of the gym center.
     * @param date The date for which slots are to be viewed.
     * @return A list of GymSlots objects representing the available slots at the center.
     */
    @GET
    @Path("/{centerId}/viewslots")
    public List<GymSlots> viewSlots(@PathParam("centerId") Integer centerId, String date) {

        return centerBusiness.viewSlots(centerId, stringtodate((date)));
    }

    /**
     * Endpoint to book a slot for a customer at a specific gym center.
     *
     * @param custId The ID of the customer making the booking.
     * @param centerId The ID of the gym center.
     * @param date The date of the booking.
     * @param slotid The ID of the slot to book.
     * @return A confirmation message with the booking ID.
     */
    @POST
    @Path("/{slotid}/bookaslot")
    public String bookaslot(@QueryParam("custId") Integer custId, @QueryParam("centerId") Integer centerId, @QueryParam("date") String date, @PathParam("slotid") Integer slotid) {
        Date parsedDate = stringtodate(date);
        int bookingId = service.createBooking(custId, slotid, centerId, parsedDate);


        String str = "Slot Booked with Booking Id: " + bookingId;
        return str;
    }
    /**
     * Endpoint to cancel an existing booking made by a customer.
     *
     * @param bookingid The ID of the booking to cancel.
     * @param custid The ID of the customer who made the booking.
     * @return A message indicating the success or failure of the cancellation.
     */

    @DELETE
    @Path("/{bookingid}/{custid}/cancelbooking")
    public String cancelBooking(@PathParam("bookingid") Integer bookingid, @PathParam("custid") Integer custid) {
        if (service.cancelBooking(custid, bookingid)) {
            return "Booking Canceled Successfully";
        } else
            return "Booking Canceled Failed";
    }

    /**
     * Endpoint to edit a customer's profile information.
     *
     * @param name The updated name of the customer.
     * @param email The updated email address of the customer.
     * @param address The updated address of the customer.
     * @param pwd The updated password for the customer's account.
     * @param contact The updated contact number of the customer.
     * @param custId The ID of the customer whose profile is to be updated.
     * @return A success or failure message indicating whether the profile was edited successfully.
     */
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

