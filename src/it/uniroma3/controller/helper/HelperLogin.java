package it.uniroma3.controller.helper;

import it.uniroma3.model.UserFacade;
import it.uniroma3.model.Utente;

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
		
		if(password==null||password==""){
			request.setAttribute("passwordErr","Campo obbligatorio");
			errors = true;
		}
		
		Utente user = uf.findUser(username);
		if(user==null) {
			request.setAttribute("combinationErr", "Username errata");
			errors = true;
		}
		else if(!user.getPassword().equals(password)) {
			request.setAttribute("combinationErr", "Password o Username errata");
			errors = true;
		}
		
		return !errors;
	}

}
