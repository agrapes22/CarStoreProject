package data;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class database 
{
	private File userData = new File("userData.txt");
	
	public database()
	{
		
	}
	
	public void readFile() throws FileNotFoundException
	{
		Scanner in = new Scanner(userData);
		
	}
	
}
