 /**
 * Anthony Marucci
 */

import java.sql.*;
import javax.swing.JOptionPane;

public class Holiday {
    private static final String dbURL = "jdbc:derby://localhost:1527/Magician Application";
    public static Connection connection;
    private static ResultSet results;
    private static PreparedStatement statement;
        
    
    Holiday(){
        try{
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            connection = DriverManager.getConnection(dbURL, "anthony", "1234");
        }catch (SQLException | ClassNotFoundException exception){
            exception.printStackTrace();
        }
    }
    
    //add a holiday to the database
    public static void addHoliday(String holidayName){
        try {
            statement = connection.prepareStatement("INSERT INTO Holiday (Name) "
                    + "VALUES (?)");
            statement.setString(1, holidayName);
            statement.executeUpdate();
        } catch (SQLException exception) {
            JOptionPane.showMessageDialog(null,"Holiday Already Exists");
        }
    }
    
    public static void removeHoliday(String holidayName){
        try {
            statement = connection.prepareStatement("DELETE FROM Holiday "
                    + "WHERE Name = ?");
            statement.setString(1, holidayName);
            statement.executeUpdate();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        
        Bookings.removeHoliday(holidayName);
        Waitlist.removeHoliday(holidayName);
    }
    
    public static ResultSet getHolidays(){
        try {
            statement = connection.prepareStatement("SELECT * FROM Holiday");
            results = statement.executeQuery();
        } catch (SQLException exception) {
            exception.printStackTrace();
            results = null; //if there are no results
        }
        
        return results;
    }
}
