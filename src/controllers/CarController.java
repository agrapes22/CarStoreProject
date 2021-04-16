package controllers;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import beans.Car;
import business.BusinessServiceInterface;

@ManagedBean
@ViewScoped
public class CarController {
	
	@Inject
	BusinessServiceInterface bs;
	
	public String onSubmitCreate() throws SQLException {
		// read the get values from the form
		FacesContext context = FacesContext.getCurrentInstance();
		
		// store the get values in an object
		// b holds the value of the submitted object from the web page
		Car c = context.getApplication().evaluateExpressionGet(context, "#{car}", Car.class);
		
		// store the object in the database
		bs.insertOne(c);
		
		// put the get values into a response page
		FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("car", c);
		
		// show the response page
		return "productPage.xhtml";
	}
	
	public ArrayList<Car> getAll() throws SQLException {
		return bs.readAll();
	}
	
	public String onSubmitEdit() throws SQLException {
		// read the get values from the form
		FacesContext context = FacesContext.getCurrentInstance();
		
		// store the get values in an object
		// b holds the value of the submitted object from the web page
		Car c = context.getApplication().evaluateExpressionGet(context, "#{car}", Car.class);		
		
		// store the object in the database
		bs.updateOne(c.getId(), c);
		
		// put the get values into a response page
		FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("car", c);
		
		// show the response page
		return "productPage.xhtml";
	}
	
	public String onDelete(Car car) throws SQLException {
		// delete the object in the database
		bs.deleteOne(car.getId());
		
		// put the get values into a response page
		FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("car", car);
		
		return "productPage.xhtml";
	}
	
	public String onShowEdit(Car car) {
		FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("car", car);
		
		return "EditForm.xhtml";
	}
	
	public String showNewProductForm() {
		return "newProduct.xhtml";
	}
	
	public String showProductPage() {
		return "productPage.xhtml";
	}
}

