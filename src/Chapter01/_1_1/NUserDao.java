package Chapter01._1_1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// 클라이언트가 수정할 수 있는 Dao 클래스.
// 상속받는 UserDao 클래스는 비공개로 남겨둔 채로 추상 메서드인 getConnection만 수정하도록 할 수 있다.
public class NUserDao extends UserDao {
	public Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection c = DriverManager.getConnection(
				"jdbc:mysql://localhost/test", "root", "duhi6215");
		return c;
	}

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
