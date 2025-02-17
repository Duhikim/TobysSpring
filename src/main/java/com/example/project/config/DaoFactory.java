package main.java.com.example.project.config;

import main.java.com.example.project.dao.AccountDao;
import main.java.com.example.project.dao.MessageDao;
import main.java.com.example.project.dao.UserDao;
import main.java.com.example.project.dao.ConnectionMaker;
import main.java.com.example.project.dao.DConnectionMaker;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DaoFactory {
	@Bean
	public UserDao userDao(){
		// ConnectionMaker connectionMaker = new DConnectionMaker();
		// return new UserDao(connectionMaker); // 이렇게 할 경우, Dao가 많아지면 connection maker 객체를 생성하는 코드가 많아진다.

		return new UserDao(connectionMaker());
	}
	public AccountDao accountDao(){
		return new AccountDao(connectionMaker());
	}
	public MessageDao messageDao(){
		return new MessageDao(connectionMaker());
	}

	// 제어의 역전(IoC). Dao에서는 ConnectionMaker 객체를 생성하지 않는다.
	public ConnectionMaker connectionMaker(){
		return new DConnectionMaker();
	}
}
