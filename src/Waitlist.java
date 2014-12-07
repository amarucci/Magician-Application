
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author ajm6162
 */
public class Waitlist {
    private static final String dbURL = "jdbc:derby://localhost:1527/Magician Application";
    public static Connection connection;
    private static final Bookings bookings = new Bookings();
    
    Waitlist(){
        try{
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            connection = DriverManager.getConnection(dbURL, "anthony", "1234");
        }catch (SQLException | ClassNotFoundException exception){
            exception.printStackTrace();
        }
    }
    
    //simply returns all the waitlist in the database(orders by tiemstamp)
    public ResultSet getWaitList(){
        return getWaitList("");
    }
    
    //simply returns all the waitlist in the database(orders by tiemstamp)(and with a filter)
    public ResultSet getWaitList(String filter){
        PreparedStatement statement;
        ResultSet results;
        
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
    public void insertWaitlist(String holiday, java.sql.Timestamp currentTimestamp, String name){
        PreparedStatement statement;
        
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
    void magicianAdded(String name) {
        PreparedStatement statement;
        ResultSet results;
        
        //get all the unique holidays with distinct
        try{
            //this is quite and odd statement.
            //it picks all the columns so that it gets all the information, since timestamp is always unique
            statement = connection.prepareStatement("SELECT DISTINCT Holiday, Timestamp FROM Waitlist "
                    + "ORDER BY Timestamp ASC");
            results = statement.executeQuery();
            while(results.next()){
                JOptionPane.showMessageDialog(null,results.getString("Holiday"));
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        
        //add those distinct values to bookings
    }
}