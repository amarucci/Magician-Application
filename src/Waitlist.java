
import java.sql.*;
import java.util.Calendar;
import javax.swing.JOptionPane;

/**
 *
 * @author ajm6162
 */
public class Waitlist {
    private static final String dbURL = "jdbc:derby://localhost:1527/Magician Application";
    public static Connection connection;
    private static ResultSet results;
    private static PreparedStatement statement;
    
    Waitlist(){
        try{
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            connection = DriverManager.getConnection(dbURL, "anthony", "1234");
        }catch (SQLException | ClassNotFoundException exception){
            exception.printStackTrace();
        }
    }
    
    //simply returns all the waitlist in the database
    //calls the other get getWaitlist method with no search filter, just so its
    //not weird when you call it
    public static ResultSet getWaitList(){
        return getWaitList("");
    }
    
    //simply returns all the waitlist in the database(orders by holiday)(and with a filter)
    public static ResultSet getWaitList(String filter){
        try {
            //uses ILIKE for case insensitive
            statement = connection.prepareStatement("SELECT * FROM WaitList "
                    + "WHERE Holiday LIKE ? "
                    + "ORDER BY Timestamp ASC");
            statement.setString(1, filter +"%");
            results = statement.executeQuery();
        } catch (SQLException exception) {
            exception.printStackTrace();
            results = null;
        }
        
        return results;
    }

    //add an entry to the waitlist
    public static void insertWaitlist(String holiday, String name){
        java.sql.Timestamp currentTimestamp = new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());
        
        try {
            statement = connection.prepareStatement("INSERT INTO Waitlist "
                    + "(timeStamp, holiday, customer) "
                    + "VALUES (?, ?, ?)");
            statement.setTimestamp(1, currentTimestamp);
            statement.setString(2, holiday);  
            statement.setString(3, name);
            statement.executeUpdate();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }
    
    
    //updates the bookings and waitlsit database when a magician is removed
    /*
    ---------------------------------------------------------------*
    fix this shit for real
    *---------------------------------------------------------------
    */
    public static void magicianAdded(String name) {
        try{
            statement = connection.prepareStatement("SELECT Holiday FROM Waitlist "
                    + "GROUP BY Holiday");
            results = statement.executeQuery();
            while(results.next()){
                JOptionPane.showMessageDialog(null,results.getString("Holiday"));
            } 
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }
    
    //adds customers to the waitlist when a magician is remoevd
    public static void magicianRemoved(String name){
        java.sql.Timestamp currentTimestamp = new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());
        
        results = Bookings.getBookingsByMagician(name);
        
        try{
            while(results.next()){
                statement = connection.prepareStatement("INSERT INTO Waitlist "
                        + "(Customer, Holiday,Timestamp) VALUES (?,?,?)");
                statement.setString(1,results.getString("Customer"));
                statement.setString(2,results.getString("Holiday"));
                statement.setTimestamp(3,currentTimestamp);
                statement.executeUpdate();
                JOptionPane.showMessageDialog(null, results.getString("Customer") + 
                        " waitlisted for " + results.getString("Holiday"));
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    //removes anyone with this holiday booked
    public static void removeHoliday(String holidayName) {        
        try{
            statement = connection.prepareStatement("DELETE FROM Waitlist "
                    + "WHERE Holiday = ?");
            statement.setString(1,holidayName);
            statement.executeUpdate();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }
}