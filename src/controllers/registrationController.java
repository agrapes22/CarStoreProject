package controllers;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import beans.User;

@ManagedBean
@ViewScoped
public class RegistrationController {
	
	public String onSubmit() {
		// Gets the user values from the input form
		FacesContext context = FacesContext.getCurrentInstance();
		User user = context.getApplication().evaluateExpressionGet(context, "#{user}", User.class);
		
		// put the user object into the POST request
		//FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("user", user);
		
		FacesContext.getCurrentInstance().getExternalContext().getRequestMap().replace("user", user);
		
		System.out.println(user.getAddress());
		
		// Show next page
		return "productPage.xhtml";
	}
}
