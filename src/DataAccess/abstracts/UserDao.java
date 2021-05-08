package DataAccess.abstracts;

import Entities.concretes.User;

public interface UserDao {

	void register(User user);
	void login(String email, String password);
	User isEmailUsed(String mail);
}
