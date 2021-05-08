package Business.concretes;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import Business.abstracts.UserService;
import DataAccess.abstracts.UserDao;
import Entities.concretes.User;

public class UserManager implements UserService{

	private UserDao userDao;
	private User user;
		
	
	public UserManager(User user) {
		super();
		this.user = user;
	}

	public UserManager(UserDao userDao) {
		super();
		this.userDao = userDao;
	}

	@Override
	public void validation(User user) {
		
	
		//EmailRegex
		String regex = "^(.+)@(.+)$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher=pattern.matcher(user.getEmail());
		if(!matcher.matches()) {
			System.out.println("Geçerli bir email adresi giriniz!!");
			return;
		}
		
		// Password check
		if(user.getPassword().length()<6) {
			System.out.println("Password must be more than 6 characters.");
			return;
		}
		
		//Names check
		if(user.getFirstName().length()<2 || user.getLastName().length()<2){
			System.out.println("Your name and lastname must be more than 2 characters.");
			return;
		}
		
		//Mail check
		Scanner scanner = new Scanner(System.in);
		System.out.println("Press 1 to verify the email.");
		int selection = scanner.nextInt();
		if(selection != 1) {
			System.out.println("Could not verify the email.");
			return;
		}
		
		userDao.register(user);
	}

	@Override
	public void logIn(String email, String password) {
		userDao.login(email, password);
		
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public User isEmailUsed(String email) {
		return userDao.isEmailUsed(email);
	}
}
