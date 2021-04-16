package business;

import java.util.ArrayList;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;
import javax.inject.Inject;

import beans.Car;
import data.DatabaseInterface;

@Local
@Stateless
@Alternative
public class BusinessService1 implements BusinessServiceInterface {
	@Inject
	DatabaseInterface db;

	@Override
	public int deleteOne(int d) {
		return db.deleteOne(d);
	}

	@Override
	public int insertOne(Car car) {
		return db.insertOne(car);
	}

	@Override
	public ArrayList<Car> readAll() {
		return db.readAll();
	}

	@Override
	public int updateOne(int d, Car car) {
		return db.updateOne(d, car);
	}

}
