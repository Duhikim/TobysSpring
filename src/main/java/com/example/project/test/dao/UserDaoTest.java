package main.java.com.example.project.test.dao;

import main.java.com.example.project.domain.User;
import main.java.com.example.project.dao.UserDao;
import main.java.com.example.project.config.DaoFactory;

import java.sql.SQLException;

public class UserDaoTest {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		// ConnectionMaker connectionMaker = new DConnectionMaker(); // 1.3) UserDao가 사용할 ConnectionMaker 구현 클래스를 결정하고 오브젝트를 만든다.
		// UserDao dao = new UserDao(connectionMaker); // 1.3) 생성한 connection maker를 이용하여 UserDao 생성

		UserDao dao = new DaoFactory().userDao(); // 1.4) 팩토리에서 생성한 Dao 사용.

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
