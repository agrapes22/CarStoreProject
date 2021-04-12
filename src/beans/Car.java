package beans;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class Car 
{
	String make;
	String model;
	String color;
	String year;
	String miles;

	public Car()
	{
		make = "";
		model = "";
		color = "";
		year = "";
		miles = "";
	}
	
	public Car(String make, String model, String color, String year, String miles) {
		super();
		this.make = make;
		this.model = model;
		this.color = color;
		this.year = year;
		this.miles = miles;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getMiles() {
		return miles;
	}

	public void setMiles(String miles) {
		this.miles = miles;
	}
	
	
}
