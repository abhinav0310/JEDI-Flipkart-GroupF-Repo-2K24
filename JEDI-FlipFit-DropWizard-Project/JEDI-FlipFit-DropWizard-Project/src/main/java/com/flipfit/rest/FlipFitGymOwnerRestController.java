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

    @DELETE
    @Path("/{centerid}/deletecenter")
    public String deletecenter(@PathParam("centerid") Integer centerid) {
        if (service.deleteCenter(centerid)) {
            return "Center Deleted Successfully";
        } else
            return "Center Not Deleted";

    }

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