package Business.abstracts;

import Entities.concretes.User;

public interface UserService {

	void validation(User user);
	void logIn(String email, String password);
}
