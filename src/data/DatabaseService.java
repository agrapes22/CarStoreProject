package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;

import beans.BeautifulThing;
import beans.Car;

@Stateless
@Local
@Alternative
public class DatabaseService implements DatabaseInterface {
	// Connect
	String dbURL = "jdbc:mysql://localhost:8889/carDatabase";
	String user = "root";
	String password = "root";
	
	// four crud operations 
	public int deleteOne(int id) {
		int numberOfRowsAffected = 0;
		
		// database work
		
		Connection c = null;
		//Statement stmt = null;
		PreparedStatement stmt = null;
		int rowsAffected = 0;
		
		try {
			c = DriverManager.getConnection(dbURL, user, password);
			System.out.println("Connection Successful " + dbURL + " " + user + " " + password); 
			
			// Create SQL Statement
			stmt = c.prepareStatement("delete from beautifulThings.thingsTable where id = ?");
			stmt.setInt(1, id);
			
			// Execute the Statement
			rowsAffected = stmt.executeUpdate();
			
			
			
			// Success message
			System.out.println("Rows affected: " + rowsAffected);
 			
		} catch (SQLException e) {
			System.out.println("ERROR");	
			e.printStackTrace();
		} finally {
			// close the connection
			try {
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				c.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return numberOfRowsAffected;
	}
	
	public int insertOne(Car car) {
		int numberOfRowsAffected = 0;
		
		// database work
		
		Connection c = null;
		PreparedStatement stmt = null;
		int rowsAffected = 0;
		
		try {
			c = DriverManager.getConnection(dbURL, user, password);
			System.out.println("Connection Successful " + dbURL + " " + user + " " + password); 
			
			// Create SQL Statement
			stmt = c.prepareStatement("insert into beautifulThings.thingsTable "
					+ "(car_id, car_make, car_model, car_color, car_year, car_miles) values (null, ?, ?, ?, ?, ?)");
			stmt.setString(1, car.getMake());
			stmt.setString(2, car.getModel());
			stmt.setString(3, car.getColor());
			stmt.setString(4, car.getYear());
			stmt.setString(5, car.getMiles());
			
			// Execute the Statement
			rowsAffected = stmt.executeUpdate();
			
			// Success message
			System.out.println("Rows affected: " + rowsAffected);
 			
		} catch (SQLException e) {
			System.out.println("ERROR");	
			e.printStackTrace();
		} finally {
			// close the connection
			try {
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				c.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return numberOfRowsAffected; 
	}
	
	public ArrayList<Car> readAll() {
		ArrayList<Car> everyone = new ArrayList<>();
		Car car;
		
		// database work
		
		Connection c = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			c = DriverManager.getConnection(dbURL, user, password);
			System.out.println("Connection Successful " + dbURL + " " + user + " " + password); 
			
			// Create SQL Statement
			stmt = c.createStatement();
			
			// Execute the Statement
			rs = stmt.executeQuery("select * from beautifulThings.thingsTable");
			
			// Process the rows in the result set
			while(rs.next()) {
				System.out.println("ID = " + rs.getInt("id") + " Title = " + rs.getString("thing_title") + " Desc = "
						+ rs.getString("thing_description") + " Rating = " + rs.getInt("thing_value"));
				car = new Car(rs.getInt("car_id"), rs.getString("car_make"), rs.getString("car_model"),
						rs.getString("car_color"), rs.getString("car_year"), rs.getString("car_miles"));
				everyone.add(car);
			
			}
 			
		} catch (SQLException e) {
			System.out.println("ERROR");	
			e.printStackTrace();
		} finally {
			// close the connection
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				c.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return everyone;
	}
	
	public int updateOne(int id, Car car) {
		int numberOfRowsAffected = 0;
		
		// database work
		Connection c = null;
		PreparedStatement stmt = null;
		int rowsAffected = 0;
		
		try {
			c = DriverManager.getConnection(dbURL, user, password);
			System.out.println("Connection Successful " + dbURL + " " + user + " " + password); 
			
			// Create SQL Statement
			stmt = c.prepareStatement("update beautifulThings.thingsTable set car_make = ?, car_model = ?, "
					+ "car_color = ?, car_year = ?, car_miles = ?, where id = ?");
			stmt.setString(1, car.getMake());
			stmt.setString(2, car.getModel());
			stmt.setString(3, car.getColor());
			stmt.setString(4, car.getYear());
			stmt.setString(5, car.getMiles());
			stmt.setInt(6, id);
			
			// Execute the Statement
			stmt.executeUpdate();
			
			// Success message
			System.out.println("Rows affected: " + rowsAffected);
 			
		} catch (SQLException e) {
			System.out.println("ERROR");	
			e.printStackTrace();
		} finally {
			// close the connection
			try {
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				c.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return numberOfRowsAffected; 
	}

	@Override
	public Car readOne(int id) {
		Car car = null;
		
		// database work
		
		Connection c = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			c = DriverManager.getConnection(dbURL, user, password);
			System.out.println("Connection Successful " + dbURL + " " + user + " " + password); 
			
			// Create SQL Statement
			stmt = c.prepareStatement("select * from carDatabase.carTable WHERE id = ?");
			stmt.setInt(1, id);
			
			// Execute the Statement
			rs = stmt.executeQuery();
			
			// Process the rows in the result set
			while(rs.next()) {
				System.out.println("ID = " + rs.getInt("car_id") + " Make = " + rs.getString("car_make") + " Model = "
						+ rs.getString("car_model") + " Color = " + rs.getString("car_color") + " Year = " + rs.getString("car_year")
						+ " Miles = " + rs.getString("car_miles"));
				car = new Car(rs.getInt("car_id"), rs.getString("car_make"), rs.getString("car_model"),
						rs.getString("car_color"), rs.getString("car_year"), rs.getString("car_miles"));
			}
 			
		} catch (SQLException e) {
			System.out.println("ERROR");	
			e.printStackTrace();
		} finally {
			// close the connection
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				c.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return car;
	}
}
