package DataAccess.concretes;

import java.util.ArrayList;

import DataAccess.abstracts.UserDao;
import Entities.concretes.User;

public class HibernateUserDao implements UserDao{

	private ArrayList<User> users;
	
	public HibernateUserDao(ArrayList<User> users) {
		super();
		this.users = users;
	}

	public ArrayList<User> getUsers() {
		return users;
	}

	public void setUsers(ArrayList<User> users) {
		this.users = users;
	}

	@Override
	public void register(User user) {

		users.add(user);
		System.out.println("Registered: "+ user.getFirstName() +" "+user.getLastName());
	}

	@Override
	public void login(String email, String password) {

		for(User user : users) {
			if(email == user.getEmail() && password == user.getPassword()) {
				System.out.println("Welcome " + user.getFirstName()+" "+user.getLastName() );
			} else {
				System.out.println("Incorrect username or password.");
			}
		}
		
	}

	@Override
	public User isEmailUsed(String mail) {

		for(User user : users) {
			if(user.getEmail().equals(mail)) {
				return user;
			}
		}
		return null;
	}

}
