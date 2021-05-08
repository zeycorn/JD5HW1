import java.util.ArrayList;

import Business.concretes.UserManager;
import Core.GLoggerManagerAdapter;
import Core.LoggerService;
import DataAccess.concretes.HibernateUserDao;
import Entities.concretes.User;

public class Main {

	public static void main(String[] args) {

		LoggerService loggerManager = new GLoggerManagerAdapter();
		loggerManager.logToSystem("asdw@gmail.com");
		
		ArrayList<User> users = new ArrayList<>();
		UserManager userManager = new UserManager(new HibernateUserDao(users));
		
		User zeynep = new User(1,"Zeynep","Çýtlak","asdw@gmail.com","1234567");
		User onur = new User(1,"Onur","Dizdar","asdw@gmail.com","1267986567");
		User burak = new User(1,"Burak","Saðlýk","alakfe@gmail.com","167");
		
		userManager.validation(burak);
		userManager.validation(onur);
		userManager.validation(zeynep);
		
		userManager.logIn("asdw@gmail.com", "1234567");
		userManager.logIn("alakfe@gmail.com","167");
	}

}
