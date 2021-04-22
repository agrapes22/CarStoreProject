package business;

import java.util.ArrayList;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;

import beans.Car;


@Stateless
@Local
@Alternative
public interface BusinessServiceInterface {
	public int deleteOne(int d);
	public int insertOne(Car car);
	public ArrayList<Car> readAll();
	public int updateOne(int d, Car car);
	public Car readOne(int id);
}
