package com.flipfit.dao;
import com.flipfit.bean.*;
import com.flipfit.dao.interfaces.IFlipFitGymCustomerDAO;
import java.sql.*;
        import java.util.*;


public class FlipFitGymCustomerDAOImpl implements IFlipFitGymCustomerDAO{
    /**
     * View Booked Slots
     * @param userID int
     * @return
     */
    public List<FlipFitSlots> viewBookedSlots(int userID) {
        List<FlipFitSlots> bookedSlots = new ArrayList<>();
        String sql = "SELECT * FROM Booking WHERE userID = ? and isDeleted=FALSE";

        try (Connection conn = GetConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setInt(1, userID);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                FlipFitSlots slot = new FlipFitSlots();
                slot.setSlotId(rs.getInt("slotID"));
                bookedSlots.add(slot);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return bookedSlots;
    }

    /**
     * Check Booking Conflicts
     * @param userId int
     * @param slotTime int
     * @return
     */
    public FlipFitBooking checkBookingConflicts(int userId, int slotTime) {
        String sql = "SELECT * FROM Booking WHERE userID = ? and slotTime = ?";
        try (Connection conn = GetConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setInt(1, userId);
            stmt.setInt(2, slotTime);
            try(ResultSet rs = stmt.executeQuery()) {
                if(rs.next()) {
                    FlipFitBooking booking = new FlipFitBooking();
                    booking.setSlotTime(rs.getInt("slotTime"));
                    booking.setSlotId(rs.getInt("slotID"));
                    booking.setUserId(userId);
                    booking.setBookingId(rs.getInt("bookingID"));
                    booking.setIsdeleted(rs.getBoolean("isDeleted"));
                    return booking;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * View Centres
     * @return
     */
    public List<FlipFitGymCentre> viewCentres() {
        List<FlipFitGymCentre> gymcentres = new ArrayList<>();
        String sql = "SELECT * FROM GymCentre";
        try (Connection conn = GetConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)){
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                FlipFitGymCentre gymcentre = new FlipFitGymCentre();
                gymcentre.setCentreID(rs.getInt("centreID"));
                gymcentre.setOwnerID(rs.getInt("ownerID"));
                gymcentre.setCapacity(rs.getInt("capacity"));
                gymcentre.setCity(rs.getString("city"));
                gymcentre.setPincode(rs.getString("pincode"));
                gymcentres.add(gymcentre);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return gymcentres;
    }

    /**
     * Make Payment
     * @param userID
     * @return
     */
    public boolean makePayment(int userID) {
        return false;
    }

    /**
     * viewPaymentDetails
     * @param userID
     */
    public void viewPaymentDetails(int userID) {

    }

//    /**
//     * Edit Payment Details
//     * @param userID
//     */
//    public void editPaymentDetails(int userID) {
//
//    }

    /**
     * Edit Details
     * @param customer
     * @return
     */
    public FlipFitGymCustomer editDetails(FlipFitGymCustomer customer) {
        String sql = "UPDATE Customer SET city=?, pincode=? WHERE customerID=?";

        try (Connection conn = GetConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setString(1, customer.getCity());
            stmt.setString(2, customer.getPinCode());
            stmt.setInt(3,customer.getUserId());
            ResultSet rs = stmt.executeQuery();
            if(rs==null) {
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        sql = "UPDATE User SET userName=?, password=? WHERE userID=?";

        try (Connection conn = GetConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setString(1, customer.getUserName());
            stmt.setString(2, customer.getPassword());
            stmt.setInt(3,customer.getUserId());
            ResultSet rs = stmt.executeQuery();
            if(rs==null) {
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return customer;
    }

    /**
     * Add User
     * @param user
     * @return
     */
    public FlipFitUser addUser(FlipFitUser user) {
        String sql = "INSERT INTO User (userID, userName, roleID, emailID, phoneNumber, password) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = GetConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setInt(1,user.getUserID());
            stmt.setString(2, user.getUserName());
            stmt.setInt(3, user.getRoleID());
            stmt.setString(4, user.getEmailID());
            stmt.setString(5, user.getPhoneNumber());
            stmt.setString(6, user.getPassword());
            int affectedRows = stmt.executeUpdate(); // Use executeUpdate() for INSERT
            if (affectedRows == 0) {
                throw new SQLException("Creating user failed, no rows affected.");
            }

            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    int userID = generatedKeys.getInt(1);
                    user.setUserID(userID);
                } else {
                    throw new SQLException("Creating user failed, no ID obtained.");
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    /**
     * Add Customer
     * @param customer
     * @param user
     * @return
     */
    public FlipFitGymCustomer addCustomer(FlipFitGymCustomer customer, FlipFitUser user) {
        String sql = "INSERT INTO Customer (customerID, city, pincode) VALUES (?, ?, ?)";
        try (Connection conn = GetConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, user.getUserID());
            System.out.println(user.getUserID());
            stmt.setString(2, customer.getCity());
            stmt.setString(3, customer.getPinCode());
            int affectedRows = stmt.executeUpdate(); // Use executeUpdate() for INSERT
            if (affectedRows == 0) {
                throw new SQLException("Creating customer failed, no rows affected.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        customer.setUserId(user.getUserID());
        return customer;
    }
}

