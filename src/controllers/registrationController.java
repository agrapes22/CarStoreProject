package controllers;

import java.io.FileNotFoundException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import beans.User;
import business.UserInterface;

@ManagedBean
@ViewScoped
public class registrationController {
	@Inject
	UserInterface services;
	
	public String onSubmit() {
		// Gets the user values from the input form
		FacesContext context = FacesContext.getCurrentInstance();
		User user = context.getApplication().evaluateExpressionGet(context, "#{user}", User.class);
		
		// put the user object into the POST request
		FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("user", user);
		
		
		user.getData().readAll();
		//boolean in = user.getData().register(user);
		//System.out.println(in);
		
		// Show next page
		return "productPage.xhtml";
	}
	
	public UserInterface getServices() {
		return services; 
	}
}

