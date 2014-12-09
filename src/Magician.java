/**
 * Anthony Marucci
 */

import java.sql.*;
import javax.swing.JOptionPane;

public class Magician {
    private static final String dbURL = "jdbc:derby://localhost:1527/Magician Application";
    public static Connection connection;
    private static final Waitlist waitlist = new Waitlist();
    private static final Bookings bookings = new Bookings();
    
    //constructor just connects to the database
    Magician(){
        try{
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            connection = DriverManager.getConnection(dbURL, "anthony", "1234");
        }catch (SQLException | ClassNotFoundException exception){
            exception.printStackTrace();
        }
    }
    
    //returns the list of all the magicians
    public ResultSet getMagicianList(){
        PreparedStatement statement;
        ResultSet results;
        
        try {
            statement = connection.prepareStatement("SELECT * FROM Magician");
            results = statement.executeQuery();
        } catch (SQLException exception) {
            exception.printStackTrace();
            results = null;
        }
        
        return results;
    }
    
    //add a magician to the database
    public void addMagician(String name){
        PreparedStatement statement;
        try {
            statement = connection.prepareStatement("INSERT INTO Magician "
                    + "(Name) VALUES (?)");
            statement.setString(1, name);
            statement.executeUpdate();
            
            //updates the wait and booking list
            /* should this be a method in each class
            i.e. booking has add magician that books and then waitlist has add magician
                    that takes off the waitlist
            or should it all be done here using the methods of the class?
            */
            waitlist.magicianAdded(name);
        } catch (SQLException exception){
            JOptionPane.showMessageDialog(null, "Magician already exists");
        }
    }
    
    //remove magician from the database
    public void removeMagician(String name){
        PreparedStatement statement;
        try {
            statement = connection.prepareStatement("DELETE FROM Magician "
                    + "WHERE Name = ?");
            statement.setString(1, name);
            statement.executeUpdate();
            
            //updates the booking and then the waitlist
            bookings.magicianRemoved(name);
            waitlist.magicianRemoved(name);
        } catch (SQLException exception){
            exception.printStackTrace();
        }
    }
}
