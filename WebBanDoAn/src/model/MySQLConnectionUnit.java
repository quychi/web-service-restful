package model;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

public class MySQLConnectionUnit {
	public static Connection getMySQLConnection()
	         throws ClassNotFoundException, SQLException {
	    
	     String hostName = "localhost";
	     String dbName = "laptrinhweb";
	     String userName = "root";
	     String password = "";
	     return getMySQLConnection(hostName, dbName, userName, password);
	 }
	  
	 public static Connection getMySQLConnection(String hostName, String dbName,
	         String userName, String password) throws SQLException,
	         ClassNotFoundException {
	    
	     Class.forName("com.mysql.jdbc.Driver");
	  
	     // Cấu trúc URL Connection đối với MySQL:
	     // Ví dụ: 
	     // jdbc:mysql://localhost:3306/simplehr
	     String connectionURL = "jdbc:mysql://" + hostName + ":3306/" + dbName;
	  
	     Connection conn = (Connection) DriverManager.getConnection(connectionURL, userName,
	             password);
	     return conn;
}
	 }
