package Chapter01._1_1;

import Chapter01._1_2.NUserDao;
import Chapter01._1_3.ConnectionMaker;
import Chapter01._1_3.DConnectionMaker;
import Chapter01._1_3.SimpleConnectionMaker;

import java.sql.*;

public abstract class UserDao {
	private SimpleConnectionMaker simpleConnectionMaker;
	private ConnectionMaker connectionMaker;

	public UserDao(){
		// simpleConnectionMaker = new SimpleConnectionMaker();
		connectionMaker = new DConnectionMaker(); // 근데 여기서 클래스 이름이 나온다. 문제발생
	}
	public void add(User user) throws ClassNotFoundException, SQLException {

		//Connection c = simpleConnectionMaker.makeNewConnection();
		Connection c = connectionMaker.makeConnection();

		PreparedStatement ps = c.prepareStatement(
				"insert into users(id, name, password) values(?, ?, ?)");
		ps.setString(1, user.getId());
		ps.setString(2, user.getName());
		ps.setString(3, user.getPassword());
		ps.executeUpdate();

		ps.close();
		c.close();
	}

	public User get(String id) throws ClassNotFoundException, SQLException {

		Connection c = simpleConnectionMaker.makeNewConnection();

		PreparedStatement ps = c.prepareStatement(
				"select * from users where id = ?");
		ps.setString(1, id);

		ResultSet rs = ps.executeQuery();
		rs.next();
		User user = new User();
		user.setId(rs.getString("id"));
		user.setName(rs.getString("name"));
		user.setPassword(rs.getString("password"));

		rs.close();
		ps.close();
		c.close();

		return user;
	}

	public abstract Connection getConnection() throws ClassNotFoundException, SQLException;

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		NUserDao dao = new NUserDao();
		User user = new User();
		user.setId("hong");
		user.setName("홍길동");
		user.setPassword("1234");
		dao.add(user);
		System.out.println(user.getId() + " 등록 성공");

		User user2 = dao.get(user.getId());
		System.out.println(user2.getName());
		System.out.println(user2.getPassword());
		System.out.println(user2.getId() + " 조회 성공");
	}

}
