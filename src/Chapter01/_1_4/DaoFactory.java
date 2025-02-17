package Chapter01._1_4;

import Chapter01._1_1.UserDao;
import Chapter01._1_3.ConnectionMaker;
import Chapter01._1_3.DConnectionMaker;

public class DaoFactory {
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
