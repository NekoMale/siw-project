package it.uniroma3.controller.helper;

import it.uniroma3.model.UserFacade;
import it.uniroma3.model.Users;

import javax.servlet.http.HttpServletRequest;

public class HelperLogin {
	
	public HelperLogin(){
		
	}
	
	public boolean isValid(HttpServletRequest request){
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		UserFacade uf = new UserFacade();
		boolean errors=false;
		
		if(username==null||username==""){
			request.setAttribute("usernameErr","Campo obbligatorio");
			errors = true;
		}
		else {
			Users user = uf.findUser(username);
			if(user==null || !user.getPassword().equals(password)) {
				request.setAttribute("combinationErr", "Password o Username errata");
				errors = true;
			}
		}
		
		if(password==null||password==""){
			request.setAttribute("passwordErr","Campo obbligatorio");
			errors = true;
		}
		
		

		request.setAttribute("username", username);
		
		return !errors;
	}

}
