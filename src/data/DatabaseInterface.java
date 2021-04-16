package data;

import java.util.ArrayList;

import javax.ejb.Local;

import beans.Car;

@Local
public interface DatabaseInterface {
	public int deleteOne(int d);
	public int insertOne(Car car);
	public ArrayList<Car> readAll();
	public int updateOne(int d, Car car);
}
