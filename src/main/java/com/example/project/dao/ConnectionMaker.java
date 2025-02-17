package main.java.com.example.project.dao;

import java.sql.Connection;
import java.sql.SQLException;

public interface ConnectionMaker {
	public Connection makeConnection() throws ClassNotFoundException, SQLException;

}
