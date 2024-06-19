package university.management.system;

import java.sql.Connection;  // Import java.sql.Connection
import java.sql.DriverManager;
import java.sql.Statement;

public class DatabaseConnection {
    
    Connection con;
    Statement s;
    
    public DatabaseConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql:///universitymanagementsystem", "root", "Aritri@2210");
            s = con.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        new DatabaseConnection();
    }
}
