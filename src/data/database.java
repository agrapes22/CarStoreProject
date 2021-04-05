package data;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;
import java.util.Scanner;

import beans.User;

public class Database 
{
	private File userData = new File("userData.txt");
	
	private List<User> users = new ArrayList<>();
	
	public Database()
	{
		try 
		{
			readFile();
		} catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
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
	
	public void writeFile()
	{
		PrintWriter out;
		try {
			out = new PrintWriter(userData);

			for (User u : users)
			{
				out.print(u.getFirstName());
				out.print("|");
				out.print(u.getLastName());
				out.print("|");
				out.print(u.getEmail());
				out.print("|");
				out.print(u.getAddress());
				out.print("|");
				out.print(u.getPhoneNumber());
				out.print("|");
				out.print(u.getUserName());
				out.print("|");
				out.print(u.getPassWord());
				out.print("\n");
			}
			
			out.close();
			
		} catch (FileNotFoundException e) 
		{
			e.printStackTrace();
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
	
	public boolean register(User user)
	{
		for (User u : users)
		{
			String userN = u.getUserName();
			String pass = u.getPassWord();
			
			if (userN == user.getUserName())
			{
				return false;
			}	
		}
		
		users.add(user);
		
		writeFile();
		
		return true;
	}
	
}
