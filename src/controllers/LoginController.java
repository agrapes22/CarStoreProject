package controllers;

import java.io.FileNotFoundException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import beans.User;

@ManagedBean
@ViewScoped
public class LoginController {
	
	public String onSubmit() {
		// Gets the user values from the input form
		FacesContext context = FacesContext.getCurrentInstance();
		User user = context.getApplication().evaluateExpressionGet(context, "#{user}", User.class);
		
		// put the user object into the POST request
		FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("user", user);
		
		try {
			user.getData().readFile();
			boolean in = user.getData().signIn(user.getUserName(), user.getPassWord());
			System.out.println(in);
		} catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		
		// Show next page
		return "productPage.xhtml";
	}
}

