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
import java.time.LocalDateTime;
import java.time.LocalTime;


@Path("/owner-menu")
@Produces(MediaType.APPLICATION_JSON)
public class FlipFitGymOwnerRestController {
    GymOwnerBusiness service = new GymOwnerBusinessImpl();

    /**
     * Endpoint to create a new gym owner profile.
     *
     * @param name The name of the gym owner.
     * @param email The email address of the gym owner.
     * @param address The address of the gym owner.
     * @param pwd The password for the gym owner's account.
     * @param contact The contact number of the gym owner.
     * @return A success or failure message indicating whether the profile was created.
     */
    @POST
    @Path("/createowner")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public String createOwner(
            @FormParam("name") String name,
            @FormParam("email") String email,
            @FormParam("address") String address,
            @FormParam("pwd") String pwd,
            @FormParam("contact") String contact) {

        // Create a GymOwner object with provided data
        GymOwner owner = new GymOwner(name, email, contact, address, pwd);

        // Call the service method to create the profile
        if (service.createProfile(owner)) {
            return "Gym Owner Profile Created Successfully";
        } else {
            return "Failed to create Gym Owner Profile. Please try again.";
        }
    }

    /**
     * Endpoint to register a new gym center for an owner.
     *
     * @param centername The name of the gym center.
     * @param centerloc The location of the gym center.
     * @param noofslots The number of available slots at the gym center.
     * @param ownerId The ID of the gym owner registering the center.
     * @return A message indicating whether the gym center was registered successfully.
     */

    @POST
    @Path("/registercenter")
    public String registercenter(
            @FormParam("centername") String centername,
            @FormParam("centerloc") String centerloc,
            @FormParam("noofslots") Integer noofslots,
            @FormParam("ownerId") Integer ownerId

    ) {
        if (service.registerCenter(ownerId, centername, centerloc, noofslots)) {
            return "Gym Center Registered Successfully";
        } else
            return "Registration Failed";

    }

    /**
     * Endpoint to add a new time slot for a specific gym center.
     *
     * @param centerid The ID of the gym center where the slot is to be added.
     * @param starttime The start time of the slot.
     * @param endtime The end time of the slot.
     * @param noofseats The number of available seats in the slot.
     * @param costs The cost of the slot.
     * @return A success or failure message indicating whether the slot was added.
     */

    @POST
    @Path("/addslot")
    public String addslot(
            @FormParam("centerid") Integer centerid,
            @FormParam("starttime") String starttime,
            @FormParam("endtime") String endtime,
            @FormParam("noofseats") Integer noofseats,
            @FormParam("costs") Integer costs

    ) {
        LocalTime startTime = LocalTime.parse(starttime);
        LocalTime endTime = LocalTime.parse(endtime);
        GymSlots slot = new GymSlots(centerid, startTime, endTime, noofseats, costs);
        if (service.addnewSlot(centerid, slot)) {
            return "New Slot Added Successfully";
        } else
            return "Slot Not Added";

    }

    /**
     * Endpoint to delete a specific time slot for a gym center.
     *
     * @param centerid The ID of the gym center from which the slot is to be deleted.
     * @param starttime The start time of the slot to delete.
     * @return A message indicating whether the slot was deleted successfully.
     */

    @DELETE
    @Path("/deleteslot")
    public String deleteslot(
            @FormParam("centerid") Integer centerid,
            @FormParam("starttime") String starttime

    ) {
        LocalTime startTime = LocalTime.parse(starttime);
        if (service.deleteSlot(centerid, startTime)) {
            return "Slot Deleted Successfully";
        } else
            return "Slot Not Deleted";

    }

    /**
     * Endpoint to delete a specific gym center.
     *
     * @param centerid The ID of the gym center to delete.
     * @return A message indicating whether the gym center was deleted successfully.
     */

    @DELETE
    @Path("/{centerid}/deletecenter")
    public String deletecenter(@PathParam("centerid") Integer centerid) {
        if (service.deleteCenter(centerid)) {
            return "Center Deleted Successfully";
        } else
            return "Center Not Deleted";

    }

    /**
     * Endpoint to edit the profile information of a gym owner.
     *
     * @param name The updated name of the gym owner.
     * @param email The updated email address of the gym owner.
     * @param address The updated address of the gym owner.
     * @param pwd The updated password for the gym owner's account.
     * @param contact The updated contact number of the gym owner.
     * @param ownerId The ID of the gym owner whose profile is to be edited.
     * @return A success or failure message indicating whether the profile was updated.
     */
    @PUT
    @Path("/editprofile")
    public String editprofile(
            @FormParam("name") String name,
            @FormParam("email") String email,
            @FormParam("address") String address,
            @FormParam("pwd") String pwd,
            @FormParam("contact") String contact,
            @FormParam("ownerId") Integer ownerId
    ) {
        GymOwner owner = new GymOwner(name, email, contact, address, pwd);
        owner.setOwnerId(ownerId);
        if (service.editProfile(owner)) {
            return "Profile Edited Successfully";
        } else
            return "Profile Not Edited";
    }
}