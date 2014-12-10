 /**
 * Anthony Marucci
 */

import java.sql.*;
import javax.swing.JOptionPane;

public class Customer {
    private static final String dbURL = "jdbc:derby://localhost:1527/Magician Application";
    public static Connection connection;
    private static ResultSet results;
    private static PreparedStatement statement;
        
    
    Customer(){
        try{
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            connection = DriverManager.getConnection(dbURL, "anthony", "1234");
        }catch (SQLException | ClassNotFoundException exception){
            exception.printStackTrace();
        }
    }
    
    //add a customer to the database
    public static void addCustomer(String name){
        try {
            statement = connection.prepareStatement("INSERT INTO Customer (Name) "
                    + "VALUES (?)");
            statement.setString(1, name);
            statement.executeUpdate();
        } catch (SQLException exception) {
            //won't add the customer twice, but they can still be booked twice
        }
    }
    
    //removes a customer
    public static void removeCustomer(String name){
        try {
            statement = connection.prepareStatement("DELETE FROM Customer "
                    + "WHERE Name = ?");
            statement.setString(1, name);
            statement.executeUpdate();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        
        Bookings.removeCustomer(name);
        Waitlist.removeCustomer(name);
    }
    
    //returns all the customers
    public static ResultSet getCustomers(){
        try {
            statement = connection.prepareStatement("SELECT * FROM Customer");
            results = statement.executeQuery();
        } catch (SQLException exception) {
            exception.printStackTrace();
            results = null; //if there are no results
        }
        
        return results;
    }
}
