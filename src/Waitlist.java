
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
    public void insertWaitlist(String holiday, String name){
        PreparedStatement statement;
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
    void magicianAdded(String name) {
        PreparedStatement statement;
        ResultSet results;
        
        //get all the unique holidays with distinct
        try{
            statement = connection.prepareStatement("SELECT * FROM Waitlist ORDER BY Timestamp ASC");
            results = statement.executeQuery();
            while(results.next()){
                JOptionPane.showMessageDialog(null,results.getString("Holiday")+" "+results.getString("Customer"));
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }
    
    //adds customers to the waitlist when a magician is remoevd
    void magicianRemoved(String name){
        PreparedStatement statement;
        ResultSet results;
        java.sql.Timestamp currentTimestamp = new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());
        
        results = bookings.getBookingsByMagician(name);
        
        try{
            while(results.next()){
                statement = connection.prepareStatement("INSERT INTO Waitlist "
                        + "(Customer, Holiday,Timestamp) VALUES (?,?,?)");
                statement.setString(1,results.getString("Customer"));
                statement.setString(2,results.getString("Holiday"));
                statement.setTimestamp(3,currentTimestamp);
                statement.executeUpdate();
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }
}