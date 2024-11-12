package com.flipfit.dao;

import com.flipfit.bean.GymOwner;
import com.flipfit.bean.GymSlots;
import com.flipfit.exceptions.DBConnectionException;
import com.flipfit.exceptions.DataEntryFailedException;
import com.flipfit.exceptions.InvalidCredentialsException;
import com.flipfit.exceptions.ResourceAlreadyExistsException;
import com.flipfit.utils.DBConnection;

import java.sql.*;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class GymOwnerDAOImpl implements GymOwnerDAO {
    private Connection connection = null;
    private PreparedStatement statement = null;

    /**
     *
     * @param gymOwner to be updated
     * @return to be updated
     * @throws InvalidCredentialsException to be updated
     * @throws DataEntryFailedException to be updated
     */
    @Override
    public boolean createProfile(GymOwner gymOwner) throws InvalidCredentialsException, DataEntryFailedException {
        try {
            connection = DBConnection.connect();

            statement = connection.prepareStatement("SELECT * from Registration where EmailAddress = ?");
            statement.setString(1, gymOwner.getOwnerEmailAddress());
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                throw new InvalidCredentialsException("User already exists with this email address");
            }
            System.out.println("Adding User Profile");
            statement = connection.prepareStatement("insert into User(`UserId`,`Name`,`Email`,`PhoneNumber`,`Role`,`Address`) values (?,?,?,?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS);
            statement.setInt(1,gymOwner.getOwnerId());
            statement.setString(2, gymOwner.getOwnerName());
            statement.setString(3, gymOwner.getOwnerEmailAddress());
            statement.setString(4, gymOwner.getOwnerPhone());
            statement.setString(5, "gymowner");
            statement.setString(6, gymOwner.getOwnerAddress());
            int rowsAffected = statement.executeUpdate();
            int ownerId = 0;
            if (rowsAffected > 0) {
                // Retrieve the generated customerId
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    ownerId = generatedKeys.getInt(1);
                }
            } else {
                throw new DataEntryFailedException("Failed Adding User Details to User Database");
            }

            statement = connection.prepareStatement("insert into OwnerInfo values (?,?,?,?,?,?)");
            statement.setInt(1, ownerId);
            statement.setString(2, gymOwner.getOwnerName());
            statement.setString(3, gymOwner.getOwnerEmailAddress());
            statement.setString(4, gymOwner.getOwnerAddress());
            statement.setString(5, gymOwner.getOwnerPhone());
            statement.setString(6, gymOwner.getPassword());
            statement.executeUpdate();

            statement = connection.prepareStatement("insert into Registration (`UserId`,`EmailAddress`,`Password`,`Role`) values (?,?,?,?)");
            statement.setInt(1, ownerId);
            statement.setString(2, gymOwner.getOwnerEmailAddress());
            statement.setString(3, gymOwner.getPassword());
            statement.setString(4, "gymowner");
            statement.executeUpdate();
            return true;
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (DBConnectionException e) {
            System.out.println(e);
        }
        return false;
    }

    /**
     *
     * @param ownerId to be updated
     * @param centerName to be updated
     * @param location to be updated
     * @param slots to be updated
     * @return to be updated
     * @throws DataEntryFailedException to be updated
     */

    @Override
    public boolean registerCenter(int ownerId, String centerName, String location, int slots) throws DataEntryFailedException{
        try {
            connection = DBConnection.connect();
            statement = connection.prepareStatement("insert into OwnerRequest(`OwnerId`,`CenterName`,`CenterLocation`,`NumOfSlots`) values (?,?,?,?)");
            statement.setInt(1, ownerId);
            statement.setString(2, centerName);
            statement.setString(3, location);
            statement.setInt(4, slots);
            int rowsAffected = statement.executeUpdate();
            if (rowsAffected <= 0) {
                throw new DataEntryFailedException("Data Entry Failed into Owner Request Database");
            } else {
                return true;
            }
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (DBConnectionException e) {
            System.out.println(e);
        }
        return false;
    }

    /**
     *
     * @param centerID to be updated
     * @param slot to be updated
     * @return to be updated
     * @throws ResourceAlreadyExistsException to be updated
     * @throws DataEntryFailedException to be updated
     */
    @Override
    public boolean addSlots(int centerID, GymSlots slot) throws ResourceAlreadyExistsException, DataEntryFailedException {
        // Check if the same slot is already present in the slot table for the given gymCenter
        if (isSlotExists(centerID, slot)) {
            throw new ResourceAlreadyExistsException("Slot already exists for the given GymCenter, and given timings.");
        }
        String sql = "INSERT INTO Slots(`CenterId`,`StartTime`,`EndTime`,`NumOfSeats`,`Cost`) VALUES (?,?,?,?,?)";

        try {
            connection = DBConnection.connect();

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, centerID); // Assuming slot.getSlotID() retrieves the slot ID
            statement.setTime(2, Time.valueOf(slot.getStartTime())); // Assuming slot.getStarttime() returns LocalDateTime
            statement.setTime(3, Time.valueOf(slot.getEndTime())); // Assuming slot.getEndTime() returns a LocalTime object
            statement.setInt(4, slot.getTotalSeats());
            statement.setInt(5, slot.getCost()); // Assuming gymCenter.getGymID() retrieves the gymID

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted <= 0) {
                throw new DataEntryFailedException("Failed to add slot");
            } else {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (DBConnectionException e) {
            System.out.println(e);
        }
        return false;
    }

    /**
     *
     * @param centerID to be updated
     * @param slot to be updated
     * @return to be updated
     */

    public boolean isSlotExists(int centerID, GymSlots slot) {
        String sql = "SELECT COUNT(*) AS count FROM Slots WHERE centerID = ? AND starttime = ? AND endtime = ?";
        try {
            connection = DBConnection.connect();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, centerID);
            statement.setTime(2, Time.valueOf(slot.getStartTime())); // Assuming slot.getStarttime() returns LocalDateTime
            statement.setTime(3, Time.valueOf(slot.getEndTime())); //

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                int count = resultSet.getInt("count");
                return count > 0;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (DBConnectionException e) {
            System.out.println(e);
        }
        return false;
    }


    /**
     *
     * @param centerID to be updated
     * @param starttime to be updated
     * @return to be updated
     * @throws DataEntryFailedException to be updated
     */
    @Override
    public boolean deleteSlot(int centerID, LocalTime starttime) throws DataEntryFailedException {
        String sql = "DELETE FROM Slots WHERE centerID = ? AND starttime = ?";

        try {
            connection = DBConnection.connect();

            PreparedStatement statement = connection.prepareStatement(sql);

            // Convert LocalDateTime to java.sql.Timestamp for DATETIME columns
            statement.setInt(1, centerID);
            statement.setTime(2, Time.valueOf(starttime));

            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                return true;
            } else {
                throw new DataEntryFailedException("Slot not found or failed to delete");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (DBConnectionException e) {
            System.out.println(e);
        }
        return false;
    }

    /**
     *
     * @param centerID to be updated
     * @return to be updated
     * @throws DataEntryFailedException to be updated
     */
    @Override
    public boolean deleteCenter(int centerID) throws DataEntryFailedException{
        String sql = "DELETE FROM GymCenters WHERE centerID = ? ";

        try {
            connection = DBConnection.connect();

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, centerID);


            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                return true;
            } else {
                throw new DataEntryFailedException("Center not found or failed to delete");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (DBConnectionException e) {
            System.out.println(e);
        }
        return false;
    }

    /**
     *
     * @param gymOwner to be updated
     * @return to be updated
     * @throws DataEntryFailedException to be updated
     */
    @Override
    public boolean editProfile(GymOwner gymOwner) throws DataEntryFailedException {
        String sql = "UPDATE OwnerInfo SET Name = ?, Email = ?, Address = ?, PhoneNumber = ?, Password=? WHERE OwnerId = ?";

        try {
            connection = DBConnection.connect();

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, gymOwner.getOwnerName());
            statement.setString(2, gymOwner.getOwnerEmailAddress());
            statement.setString(3, gymOwner.getOwnerAddress());
            statement.setString(4, gymOwner.getOwnerPhone());
            statement.setString(5, gymOwner.getPassword());
            System.out.println(gymOwner.getOwnerId());
            statement.setInt(6, gymOwner.getOwnerId());
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated <= 0) {
                throw new DataEntryFailedException("Failed to update profile");
            }

            statement = connection.prepareStatement("UPDATE User SET Name = ?, Email = ?, Address = ?, PhoneNumber = ? WHERE UserId = ?");
            statement.setString(1, gymOwner.getOwnerName());
            statement.setString(2, gymOwner.getOwnerEmailAddress());
            statement.setString(3, gymOwner.getOwnerAddress());
            statement.setString(4, gymOwner.getOwnerPhone());
            statement.setInt(5, gymOwner.getOwnerId());
            statement.executeUpdate();

            statement = connection.prepareStatement("UPDATE Registration SET EmailAddress = ?, Password = ? WHERE UserId = ?");
            statement.setString(1, gymOwner.getOwnerEmailAddress());
            statement.setString(2, gymOwner.getPassword());
            statement.setInt(3, gymOwner.getOwnerId());
            statement.executeUpdate();

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (DBConnectionException e) {
            System.out.println(e);
        }
        return false;
    }

    /**
     *
     * @param email to be updated
     * @param password to be updated
     * @param role to be updated
     * @return to be updated
     * @throws InvalidCredentialsException to be updated
     */
    @Override
    public boolean updatepwd(String email, String password, String role) throws InvalidCredentialsException {
        try {
            connection = DBConnection.connect();
            statement = connection.prepareStatement("Select * from Registration where EmailAddress=? and role=?");
            statement.setString(1, email);
            statement.setString(2, role);
            ResultSet resultSet = statement.executeQuery();
            if (!resultSet.next()) {
                throw new InvalidCredentialsException("You are not registered for this role yet!!");
            } else {
                int id = resultSet.getInt(1);
                statement = connection.prepareStatement("update Registration set Password=? where UserId=?");
                statement.setString(1, password);
                statement.setInt(2, id);
                statement.executeUpdate();

                statement = connection.prepareStatement("update OwnerInfo set Password=? where ownerId=?");
                statement.setString(1, password);
                statement.setInt(2, id);
                statement.executeUpdate();
                return true;
            }

        } catch (SQLException se) {
            se.printStackTrace();
        } catch (DBConnectionException e) {
            System.out.println(e);
        }
        return false;
    }
}
