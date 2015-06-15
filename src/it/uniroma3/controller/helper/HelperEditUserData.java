package it.uniroma3.controller.helper;


import it.uniroma3.model.UserFacade;
import it.uniroma3.model.Users;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class HelperEditUserData {

	public boolean isValid(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String username = request.getParameter("username");
		String email = request.getParameter("email");
		Long id = Long.parseLong(request.getParameter("id"));
		
		UserFacade uf = new UserFacade();
		boolean errors = false;
		
		if(username==null||username=="") {
			request.setAttribute("userErr", "Campo obbligatorio!");
			errors = true;
		}
		else {
			Users user = (Users) uf.getUser(username); 
			if(user!=null && !user.getId().equals(id)) {
				request.setAttribute("userErr", "Username Esistente!");
				errors = true;
			}
		}
		if(email==null||email=="") {
			request.setAttribute("emailErr", "Campo obbligatorio!");
			errors = true;
		}
		else {
			Users user = (Users) uf.getUserByEmail(email); 
			if(user!=null && !user.getId().equals(id)) {
				request.setAttribute("emailErr", "Email Esistente!");
				errors = true;
			}
		}
		if(session.getAttribute("user")==null) {
			request.setAttribute("msg", "Per effettuare questa operazione devi fare l'accesso!");
			errors = true;
		}
		return !errors;
	}

}
