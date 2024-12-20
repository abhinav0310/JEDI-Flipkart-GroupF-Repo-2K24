package com.flipfit.dao;
import com.flipfit.dao.interfaces.*;
import java.sql.*;
import com.flipfit.bean.FlipFitSlots;
import com.flipfit.constant.DBConstants;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FlipFitSlotDAOImpl implements IFlipFitSlotDAO {
    /**
     * Add Slot
     * @param slot
     * @return
     */
    @Override
    public FlipFitSlots addSlot(FlipFitSlots slot) {
        String sql = "INSERT INTO Slots (centreID, slotTime, seatsAvailable) VALUES (?, ?, ?)";
        try (Connection conn = GetConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setInt(1, slot.getCentreId());
            stmt.setInt(2, slot.getSlotTime());
            stmt.setInt(3, slot.getSeatsAvailable());

            int affectedRows = stmt.executeUpdate(); // Use executeUpdate() for INSERT
            if (affectedRows == 0) {
                throw new SQLException("Creating slot failed, no rows affected.");
            }

            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    int slotID = generatedKeys.getInt(1);
                    slot.setSlotId(slotID);
                } else {
                    throw new SQLException("Creating slot failed, no ID obtained.");
                }
            }
        } catch (Exception e) {
            System.out.println("Error adding slot: " + e);
        }
        return slot;
    }

    /**
     * Delete Slot
     * @param centreID
     * @param slotID
     * @return
     */
    @Override
    public boolean deleteSlot(int centreID, int slotID) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    DBConstants.DB_URL, DBConstants.USER, DBConstants.PASSWORD);

            PreparedStatement stmt = con.prepareStatement("DELETE FROM Slots WHERE centreID = ? AND slotID = ?");

            stmt.setInt(1, centreID);
            stmt.setInt(2, slotID);

            int i = stmt.executeUpdate();
            System.out.println(i + " slot deleted");

            // Close the connection
            con.close();

            return i > 0;

        } catch (Exception e) {
            System.out.println("Error deleting slot: " + e);
        }
        return false;
    }

    /**
     * Change Slot
     * @param slot
     * @return
     */
    @Override
    public boolean changeSlot(FlipFitSlots slot) {
        String sql = "UPDATE Slots SET centreID = ?, slotTime = ?, seatsAvailable = ? WHERE slotID = ?";
        try (Connection conn = GetConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, slot.getCentreId());
            stmt.setInt(2, slot.getSlotTime());
            stmt.setInt(3, slot.getSeatsAvailable());
            stmt.setInt(4, slot.getSlotId());

            int affectedRows = stmt.executeUpdate(); // Use executeUpdate() for INSERT
            if (affectedRows == 0) {
                throw new SQLException("Updating slots failed, no rows affected.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * Get All Slots
     * @param centreID
     * @return
     */
    @Override
    public List<FlipFitSlots> getAllSlots(int centreID) {
        List<FlipFitSlots> slots = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    DBConstants.DB_URL, DBConstants.USER, DBConstants.PASSWORD);

            PreparedStatement stmt = con.prepareStatement("SELECT * FROM Slots WHERE centreID = ?");
            stmt.setInt(1, centreID);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int slotID = rs.getInt("slotID");
                int StartTime = rs.getInt("slotTime");
                int SeatsAvailable = rs.getInt("seatsAvailable");

                FlipFitSlots slot = new FlipFitSlots();
                slot.setSlotId(slotID);
                slot.setCentreId(centreID);
                slot.setSlotTime(StartTime);
                slot.setSeatsAvailable(SeatsAvailable);
                slots.add(slot);
            }
            rs.close();
            stmt.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("Error retrieving slots: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return slots;
    }

    /**
     * Get Slot Details By Id
     * @param slotId
     * @return
     */
    @Override
    public FlipFitSlots getSlotDetailsById(int slotId) {
        String sql = "SELECT * FROM Slots WHERE slotID=?";
        try (Connection conn = GetConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, slotId);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    int slotid = rs.getInt("slotID");
                    int seatsAvailable = rs.getInt("seatsAvailable");
                    int slotTime = rs.getInt("slotTime");
                    int centreID = rs.getInt("centreID");
                    FlipFitSlots slot = new FlipFitSlots();
                    slot.setSlotId(slotid);
                    slot.setSlotTime(slotTime);
                    slot.setSeatsAvailable(seatsAvailable);
                    slot.setCentreId(centreID);

                    return slot;
                } else {
                    throw new SQLException("Slot details not found for slotID = " + slotId);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Get Slot Details
     * @param startTime
     * @param centreID
     * @return
     */
    @Override
    public FlipFitSlots getSlotDetails(int startTime, int centreID) {
        String sql = "SELECT * FROM Slots WHERE slotTime = ? AND centreID = ?";
        try (Connection conn = GetConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, startTime);
            stmt.setInt(2, centreID);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    int slotid = rs.getInt("slotID");
                    int seatsAvailable = rs.getInt("seatsAvailable");

                    FlipFitSlots slot = new FlipFitSlots();
                    slot.setSlotId(slotid);
                    slot.setSlotTime(startTime);
                    slot.setSeatsAvailable(seatsAvailable);
                    slot.setCentreId(centreID);

                    return slot;
                } else {
                    throw new SQLException("Slot details not found for startTime = " + startTime + " and centreID = " + centreID);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
