package main.java.com.example.project.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DConnectionMaker implements ConnectionMaker {
	@Override
	public Connection makeConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection c = DriverManager.getConnection(
				"jdbc:mysql://localhost/test", "root", "duhi6215");
		return c;
	}
}
