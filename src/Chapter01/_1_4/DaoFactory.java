package Chapter01._1_4;

import Chapter01._1_1.UserDao;
import Chapter01._1_3.ConnectionMaker;
import Chapter01._1_3.DConnectionMaker;

public class DaoFactory {
	public UserDao userDao(){
		ConnectionMaker connectionMaker = new DConnectionMaker();
		return new UserDao(connectionMaker);
	}
}
