package beans;

import java.security.Principal;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import data.DatabaseService;

@ManagedBean
public class User {
	
	private String firstName, lastName, email, address, phoneNumber, userName, passWord;
	
	DatabaseService data = new DatabaseService();
	
	public User() {
		firstName = "";
		lastName = "";
		email = "";
		address = "";
		phoneNumber = "";
		userName = "";
		passWord = "";
	}

	public User(String firstName, String lastName, String email, String address, String phoneNumber, String userName,
			String passWord) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.userName = userName;
		this.passWord = passWord;
		
		//data.register(firstName, lastName, email, address, phoneNumber, userName, passWord);
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	
	public DatabaseService getData()
	{
		return data;
	}
	
	@PostConstruct
	public void init()
	{
		Principal principle= FacesContext.getCurrentInstance().getExternalContext().getUserPrincipal();
		if(principle == null)
		{
			setFirstName("Unknown");
			setLastName("");
		}
		else
		{
			setFirstName(principle.getName());
			setLastName("");
		}

	}
}


//test commit 2