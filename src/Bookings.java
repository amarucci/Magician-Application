/**
 * Anthony Marucci
 */

import java.sql.*;
import javax.swing.JOptionPane;

public class Bookings {
    private static final String dbURL = "jdbc:derby://localhost:1527/Magician Application";
    public static Connection connection;
    private static PreparedStatement statement;
    private static ResultSet results;
    
    //connects to the data base when the class is made
    Bookings(){
        try{
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            connection = DriverManager.getConnection(dbURL, "anthony", "1234");
        }catch (SQLException | ClassNotFoundException exception){
            exception.printStackTrace();
        }
    }
    
    //simply returns all the bookings in the database
    //calls the other get bookings method with no search filter, just so its
    //not weird when you call it
    public static ResultSet getBookings(){
        return getBookings("");
    }
    
    //returns all the bookings but with a filter
    public static ResultSet getBookings(String filter){        
        try {
            statement = connection.prepareStatement("SELECT * FROM Booking "
                    + "WHERE Holiday LIKE ?");
            statement.setString(1, filter+"%");
            results = statement.executeQuery();
        } catch (SQLException exception) {
            exception.printStackTrace();
            results = null;
        }
        
        return results;
    }
    
    //adds the booking to the data base
    private static void insertBooking(String magician, String holiday, String name){
        try {
            statement = connection.prepareStatement("INSERT INTO Booking "
                        + "(Magician, holiday, customer) "
                        + "VALUES (?, ?, ?)");
                statement.setString(1, magician);
                statement.setString(2, holiday);  
                statement.setString(3, name);
                statement.executeUpdate();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }
    
    //adds a bookign to the bookings database
    public static void addBooking(String name, String holiday){
        String magician;
        magician = getFreeMagicians(holiday);
        
        if(magician != null){ //book them becuase there is a person avaliable
            insertBooking(magician, holiday, name);
            JOptionPane.showMessageDialog(null, name+" was booked for "
                        +holiday +" with magician "+magician);
        }else{ //put them in the waitlist
            Waitlist.insertWaitlist(holiday,name);
            JOptionPane.showMessageDialog(null, name+" was wait listed for " + holiday);
        }
    }
    
    //returns the booking information for a given holiday
    public static ResultSet getBookingsByMagician(String name){
        try {
            statement = connection.prepareStatement("SELECT * FROM Booking "
                    + "WHERE Magician = ?");
            statement.setString(1,name);
            results = statement.executeQuery();
        } catch (SQLException exception) {
            exception.printStackTrace();
            results = null;
        }
        
        return results;
    }
    
    //returns a set of magicians that are free for a given date
    public static String getFreeMagicians(String holiday) {
        String magician;
        
        //I use Magician.Name here just to be sure its picking from the magician tablee
        try{
            statement = connection.prepareStatement("SELECT Name FROM Magician"
                    + " WHERE Magician.Name NOT IN (Select Booking.Magician FROM Booking"
                    + " WHERE Booking.Holiday = ?)");
            statement.setString(1,holiday);
            results = statement.executeQuery();
            
            //check if there was a free person
            if(results.next()){
                magician = results.getString("Name");
            }else{
                magician = null;
            }
        }
        catch(SQLException exception){
            exception.printStackTrace();
            magician = null;
        }
        
        return magician;
    }
    
    //deletes the rows where the magician who was removed had bookings
    public static void magicianRemoved(String name){
        try {
            //get all the people that had that magician
            statement = connection.prepareStatement("SELECT * FROM Booking "
                    + "WHERE Magician = ?");
            statement.setString(1, name);
            results = statement.executeQuery();
            
            //delete those entries
            //this is done before the adding to stop any conflict
            statement = connection.prepareStatement("DELETE FROM Booking "
                    + "WHERE Magician = ?");
            statement.setString(1,name);
            statement.executeUpdate();
            
            //add them to booking
            //if they can't be added this method will automatically put them in the wait list
            while(results.next()){
                addBooking(results.getString("Customer"),results.getString("Holiday"));
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    //removes anyone with this holiday booked
    public static void removeHoliday(String holidayName) {
        try{
            statement = connection.prepareStatement("DELETE FROM Booking "
                    + "WHERE Holiday = ?");
            statement.setString(1,holidayName);
            statement.executeUpdate();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }
}
