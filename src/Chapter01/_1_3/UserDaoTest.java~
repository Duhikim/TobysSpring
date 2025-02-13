package Chapter01._1_3;

import Chapter01._1_1.User;
import Chapter01._1_1.UserDao;

import java.sql.SQLException;

public class UserDaoTest {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		ConnectionMaker connectionMaker = new DConnectionMaker(); // UserDao가 사용할 ConnectionMaker 구현 클래스를 결정하고 오브젝트를 만든다.

		UserDao dao = new UserDao(connectionMaker);

		// NUserDao dao = new NUserDao();
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
