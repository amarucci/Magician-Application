/**
 * Anthony Marucci
 */

import java.sql.*;
import javax.swing.JOptionPane;

public class Magician {
    private static final String dbURL = "jdbc:derby://localhost:1527/Magician Application";
    public static Connection connection;
    
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
        MagicianApplication GUI = new MagicianApplication();
        try {
            statement = connection.prepareStatement("INSERT INTO Magician "
                    + "(Name) VALUES (?)");
            statement.setString(1, name);
            statement.executeUpdate();
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
        } catch (SQLException exception){
            exception.printStackTrace();
        }
    }
}
