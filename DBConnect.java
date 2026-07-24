package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection cc = DriverManager.getConnection("jdbc:mysql://localhost:3306/sandip","root","root");
		System.out.println("Connected successfully");
		cc.close();

	}

}