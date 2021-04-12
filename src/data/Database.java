package data;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.Scanner;

import beans.User;

public class Database 
{
	private File userData = new File("userData.txt");
	
	private List<User> users = new ArrayList<>();
	
	public Database()
	{
		
	}
	
	public void readFile() throws FileNotFoundException
	{
		Scanner in = new Scanner(userData);
		
		while (in.hasNextLine())
		{
			String line = in.nextLine();
		
			String[] user = line.split("|");
			
			String fN = user[0];
			String lN = user[1];
			String email = user[2];
			String address = user[3];
			String phoneNum = user[4];
			String userNam = user[5];
			String pass = user[6];
			
			users.add(new User(fN, lN, email, address, phoneNum, userNam, pass));
		}
	}
	
	public boolean signIn(String user, String pass)
	{
		for (User u : users)
		{
			String uName = u.getUserName();
			String password = u.getPassWord();
			
			if (user == uName && pass == password)
			{
				return true;
			}
			
			else return false;
		}
		return false;
	}
	
	public boolean register(String firstName, String lastName, String email, String address, String phoneNumber, String userName,
			String passWord)
	{
		for (User u : users)
		{
			String user = u.getUserName();
			String pass = u.getPassWord();
			
			if (userName == user)
			{
				return false;
			}	
		}
		
		User newUser = new User(firstName, lastName, email, address, phoneNumber, userName, passWord);
		return true;
	}
	
	
}
