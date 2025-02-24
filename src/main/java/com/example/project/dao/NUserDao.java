package com.example.project.dao;

// 클라이언트가 수정할 수 있는 Dao 클래스.
// 상속받는 UserDao 클래스는 비공개로 남겨둔 채로 추상 메서드인 getConnection만 수정하도록 할 수 있다.

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class NUserDao extends UserDao {
	public NUserDao(ConnectionMaker connectionMaker) {
		super(connectionMaker);
	}

	public Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection c = DriverManager.getConnection(
				"jdbc:mysql://localhost/test", "root", "duhi6215");
		return c;
	}

}
