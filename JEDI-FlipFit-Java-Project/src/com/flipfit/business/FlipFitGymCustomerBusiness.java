package com.flipfit.business;
import com.flipfit.bean.*;
import com.flipfit.business.interfaces.IFlipFitGymCustomer;
import com.flipfit.dao.*;
//import com.flipfit.exceptions.InvalidChoiceException;
import java.util.List;

public class FlipFitGymCustomerBusiness implements IFlipFitGymCustomer {
    private final FlipFitGymCustomerDAOImpl flipFitGymCustomerDAOImpl ;

    public FlipFitGymCustomerBusiness(FlipFitGymCustomerDAOImpl FFGymCustomer){
        this.flipFitGymCustomerDAOImpl=FFGymCustomer;
    }

    @Override
    public List<FlipFitBooking> viewBookedSlots(int userId) {

        System.out.println("Viewing booked slots:> ");
        FlipFitBookingDAOImpl bookingDAO = new FlipFitBookingDAOImpl();
        FlipFitSlotDAOImpl slotDAO = new FlipFitSlotDAOImpl();
        List<FlipFitBooking> bookingsList= bookingDAO.getAllBookings(userId);

        bookingsList.forEach(booking -> {
            FlipFitSlots slotdetails = slotDAO.getSlotDetailsById(booking.getSlotId());
            System.out.println("Booking ID: " + booking.getBookingId() + " Slot timing " + slotdetails.getSlotTime());
        });

        return bookingsList;
    }

    @Override
    public FlipFitBooking checkBookingConflicts(int userId, int slotTime) {
        System.out.println("Checking conflict for slot " + slotTime);
        return flipFitGymCustomerDAOImpl.checkBookingConflicts(userId, slotTime);
    }
    @Override
    public List<FlipFitGymCentre> viewCentres() {
        System.out.println("view centres called:> ");
        return flipFitGymCustomerDAOImpl.viewCentres();
    }

    public boolean makePayment(int userId) {
        System.out.println("Make payment called:> ");
        flipFitGymCustomerDAOImpl.makePayment(userId);
        return true;
    }
    public FlipFitGymCustomer editDetails(FlipFitGymCustomer flipFitGymCustomer){

            return flipFitGymCustomerDAOImpl.editDetails(flipFitGymCustomer);
    }

    @Override
    public FlipFitGymCustomer registerCustomer(FlipFitGymCustomer flipFitGymCustomer) {
        FlipFitUser flipFitUser = new FlipFitUser();
        flipFitUser.setPassword(flipFitGymCustomer.getPassword());
        flipFitUser.setEmailID(flipFitGymCustomer.getEmailID());
        flipFitUser.setPhoneNumber(flipFitGymCustomer.getPhoneNumber());
        flipFitUser.setUserName(flipFitGymCustomer.getUserName());
        flipFitUser.setRoleID(0);
        flipFitGymCustomer.setRole(0);
        flipFitGymCustomerDAOImpl.addUser(flipFitUser);
        return flipFitGymCustomerDAOImpl.addCustomer(flipFitGymCustomer, flipFitUser);
    }

    @Override
    public FlipFitUser login(FlipFitUser flipFitUser) {
        FlipFitUserDAOImpl userDAO = new FlipFitUserDAOImpl();
        flipFitUser.setRoleID(0);
        flipFitUser = userDAO.loginAsCustomer(flipFitUser.getEmailID(), flipFitUser.getPassword());
        return flipFitUser;
    }

}
