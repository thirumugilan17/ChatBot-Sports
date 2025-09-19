package Project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionProvider {
    public static Connection getCon() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Update the database URL as needed
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/chatbot", "root", "thiru@1234");
            return con;
        } catch (Exception e) {
            System.out.println("Error in connection: " + e);
            return null;
        }
    }
}
