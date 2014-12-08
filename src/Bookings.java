/**
 * Anthony Marucci
 */

import java.sql.*;
import java.util.Calendar;
import javax.swing.JOptionPane;

public class Bookings {
    private static final String dbURL = "jdbc:derby://localhost:1527/Magician Application";
    public static Connection connection;
    
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
    public ResultSet getBookings(){
        return getBookings("");
    }
    
    //returns all the bookings but with a filter
    public ResultSet getBookings(String filter){
        PreparedStatement statement;
        ResultSet results;
        
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
    private void insertBooking(String magician, String holiday, String name){
        PreparedStatement statement;
        
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
    public void addBooking(String name, String holiday){
        String magician;
        Waitlist waitlist = new Waitlist();
        magician = getFreeMagicians(holiday);
        
        if(magician != null){ //book them becuase there is a person avaliable
            insertBooking(magician, holiday, name);
            JOptionPane.showMessageDialog(null, name+" was booked for "
                        +holiday +" with magician "+magician);
        }else{ //put them in the waitlist
            waitlist.insertWaitlist(holiday,name);
            JOptionPane.showMessageDialog(null, name+" was wait listed for " + holiday);
        }
    }
    
    //returns the booking information for a given holiday
    public ResultSet getBookingsByMagician(String name){
        PreparedStatement statement;
        ResultSet results;
        
        try {
            statement = connection.prepareStatement("SELECT * FROM Booking"
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
    public String getFreeMagicians(String holiday) {
        PreparedStatement statement;
        ResultSet results;
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
    
    public void magicianRemoved(String name){
        PreparedStatement statement;
        
        try {
            statement = connection.prepareStatement("DELETE * FROM Booking"
                    + "WHERE Magician = ?");
            statement.setString(1,name);
            statement.executeUpdate();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }
}
