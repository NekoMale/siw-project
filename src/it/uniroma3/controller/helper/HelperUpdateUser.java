package it.uniroma3.controller.helper;

import it.uniroma3.model.UserFacade;
import it.uniroma3.model.Users;

import javax.servlet.http.HttpServletRequest;

public class HelperUpdateUser {
	
	public HelperUpdateUser() {}
	
	public boolean isValid(HttpServletRequest request) {
	
		String username = request.getParameter("username");
		String email = request.getParameter("email");
		Long id = Long.parseLong(request.getParameter("id"));
		Users user;
		UserFacade uf = new UserFacade();
		
		boolean errors=false;
		
		if(username==null||username==""){
			request.setAttribute("usernameErr","Campo obbligatorio");
			errors = true;
		}
		
		if(email==null||email==""){
			request.setAttribute("emailErr","Campo obbligatorio");
			errors = true;
		}

		user = uf.findUser(username);
		if(user!=null) {
			if(user.getId().compareTo(id)!=0) {
				request.setAttribute("usernameErr","Username già esistente!");
				errors = true;
			}
		}
		user = uf.findEmail(email);
		if(user!=null) {
			if(user.getId().compareTo(id)!=0) {
				request.setAttribute("emailErr",id+ "Email già esistente!" +user.getId());
				errors = true;
			}
		}
		
		return !errors;
	}

}
