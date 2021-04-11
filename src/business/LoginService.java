package business;

import javax.ejb.Local;
import javax.ejb.Stateless;

import beans.User;

@Stateless
@Local
public class LoginService implements UserInterface {
	User user = new User();
	
	public LoginService() {
		this.user.setUserName("");
		this.user.setPassWord("");
	}

	@Override
	public User getUser() {
		return user;
	}

	@Override
	public void setUser(User user) {
		this.user = user;
	}

}
