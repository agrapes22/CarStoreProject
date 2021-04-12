package controllers;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import beans.Car;

@ManagedBean
@ViewScoped
public class CarController {

	public String onSubmit() {
		// Gets the user values from the input form
		FacesContext context = FacesContext.getCurrentInstance();
		Car car = context.getApplication().evaluateExpressionGet(context, "#{car}", Car.class);
		
		// put the user object into the POST request
		FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("car", car);
		
		return "productPage.xhtml";
	}
	
	
}

