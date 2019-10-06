package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class MySQLJDBCUtil {

	public static Connection getConnection() throws SQLException {
        Connection conn = null;
 
        try  {   
        	
        	try {
				Class.forName("com.mysql.jdbc.Drive");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 	        	
 
//            // assign db parameters
//            String url = "jdbc:mysql://localhost:3306/test";
//            String user = "root";
//            String password = "12345";
            
            String url = "sql12.freemysqlhosting.net/sql12307553";
            String user = "sql12307553";
            String password = "pAuxhHmMAG";   
                       
            // create a connection to the database
            conn = DriverManager.getConnection(url, user, password);
        } catch (SQLException ex) {
        	// handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        } 
        return conn;
    }
		
	
		
}
