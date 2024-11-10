package com.flipfit.dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.Random;
import com.flipfit.bean.FlipFitGymCentre;
import com.flipfit.constant.DBConstants;
import com.flipfit.bean.FlipFitSlots;

public class FlipFitGymCentreDAOImpl {
    Random rand = new Random();

    /**
     * Create FlipFit Gym Centre
     * @param FFGC
     * @return
     */
    public FlipFitGymCentre createGymCentre(FlipFitGymCentre FFGC){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    DBConstants.DB_URL,DBConstants.USER,DBConstants.PASSWORD);

            PreparedStatement stmt = con.prepareStatement("INSERT INTO GymCentre VALUES (?, ?, ?, ?, ?, ?)");


            // Generate random integers in range 0 to 999
            FFGC.setCentreID(rand.nextInt(1000));
            stmt.setInt(1, FFGC.getCentreID());
            stmt.setInt(2, FFGC.getOwnerID());
            stmt.setInt(3,FFGC.getCapacity());
            stmt.setString(4, FFGC.getCity());
            stmt.setString(5, FFGC.getState());
            stmt.setString(6, FFGC.getPincode());

            int i = stmt.executeUpdate();
            System.out.println( i + " centre added");

            con.close();
        } catch(Exception e){
            System.out.println(e);
        }
        return FFGC;
    };

    /**
     * Update Gym Centre
     * @param FFGC
     * @return
     */
    public FlipFitGymCentre updateGymCentre(FlipFitGymCentre FFGC){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    DBConstants.DB_URL,DBConstants.USER,DBConstants.PASSWORD);

            PreparedStatement stmt = con.prepareStatement(("UPDATE GymCentre SET ownerID = ?, capacity = ?, city = ?, state = ?, pincode = ? WHERE centreID = ?"));


            stmt.setInt(1, FFGC.getOwnerID());
            stmt.setInt(2,FFGC.getCapacity());
            stmt.setString(3, FFGC.getCity());
            stmt.setString(4, FFGC.getState());
            stmt.setString(5, FFGC.getPincode());
            stmt.setInt(6, FFGC.getCentreID());

            int i = stmt.executeUpdate();
            System.out.println( i + " centre updated");

            con.close();
        } catch(Exception e){
            System.out.println(e);
        }
        return FFGC;
    };

    /**
     * Delete Gym Centre
     * @param FFGC
     */
    public void deleteGymCentre(FlipFitGymCentre FFGC){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    DBConstants.DB_URL,DBConstants.USER,DBConstants.PASSWORD);

            PreparedStatement stmt = con.prepareStatement("DELETE FROM GymCentre WHERE centreID=(?)");

            stmt.setInt(1, FFGC.getCentreID());

            int i = stmt.executeUpdate();
            System.out.println( i + " centre deleted");

            con.close();
        } catch(Exception e){
            System.out.println(e);
        }
    };

    /**
     * View Centres
     * @param city string
     * @return
     */
    public ArrayList<FlipFitGymCentre> viewCentres(String city){
        ArrayList<FlipFitGymCentre> ffarray = new ArrayList<FlipFitGymCentre>();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    DBConstants.DB_URL,DBConstants.USER,DBConstants.PASSWORD);

            PreparedStatement stmt = con.prepareStatement("SELECT * FROM GymCentre WHERE city = ?");
            stmt.setString(1, city);

            ResultSet rs = stmt.executeQuery();


            while(rs.next()){
                FlipFitGymCentre FFGC = new FlipFitGymCentre();
                FFGC.setCentreID(rs.getInt("centreID"));
                FFGC.setOwnerID(rs.getInt("ownerID"));
                FFGC.setCapacity(rs.getInt("capacity"));
                FFGC.setCity(rs.getString("city"));
                FFGC.setState(rs.getString("state"));
                FFGC.setPincode(rs.getString("pincode"));

                ffarray.add(FFGC);
            };


            con.close();
        } catch(Exception e){
            System.out.println(e);
        }
        return ffarray;
    }

    /**
     * viewAvailableSlots
     * @param FFGC
     * @return
     */
    public ArrayList<FlipFitSlots> viewAvailableSlots(FlipFitGymCentre FFGC){
            ArrayList<FlipFitSlots> ffarray = new ArrayList<FlipFitSlots>();

            try{
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection(
                        DBConstants.DB_URL,DBConstants.USER,DBConstants.PASSWORD);

                PreparedStatement stmt = con.prepareStatement("SELECT * FROM Slots WHERE centreID = ? and seatsAvailable > 0");
                stmt.setInt(1, FFGC.getCentreID());

                ResultSet rs = stmt.executeQuery();

                while(rs.next()){
                    FlipFitSlots FFS = new FlipFitSlots();
                    FFS.setSlotId(rs.getInt("slotID"));
                    FFS.setCentreId(rs.getInt("centreID"));
                    FFS.setSeatsAvailable(rs.getInt("seatsAvailable"));
                    FFS.setSlotTime(rs.getInt("slotTime"));

                    ffarray.add(FFS);
                };


                con.close();
            } catch(Exception e){
                System.out.println(e);
            }
            return ffarray;
    };


}
