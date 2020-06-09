package model;

import java.sql.DriverManager;

import com.mysql.jdbc.Connection;

public class Connectiondb {
	private  String hostname = "localhost";
	private  String username = "root";
	private  String password = "";
	private  String classname = "com.mysql.jdbc.Driver";
	private  String dbname = "laptrinhweb";
	private  String url = "jdbc:mysql://" + hostname + ":3306/" +dbname;
	private  Connection conn; 
	
	public Connectiondb() {	
		try {
			Class.forName(classname);
			conn = (Connection) DriverManager.getConnection(url, username, password);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public Connection getConnection() {
		return conn;
	}
	
	
	
}
