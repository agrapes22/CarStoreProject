package business;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import beans.User;

@Stateless
@LocalBean
public class RegistrationService implements UserInterface
{
	User user = new User();
	
    public RegistrationService() 
    {
        
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
