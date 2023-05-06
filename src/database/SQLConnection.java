package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLConnection {
	
	protected String DB_USERNAME = "root";
	protected String DB_PASSWORD = "";
	protected String DB_URL = "jdbc:mysql://localhost:3306/members";

	private static Connection connection = null;
	
	public SQLConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
			System.out.println("Bağlantı başarılı!");
		} catch(SQLException e) {
			e.printStackTrace();
			System.exit(0);
		}
		
	}
	
	public static Connection getConnection() {
		return connection;
	}
	
}
