package it.uniroma3.controller.helper;

import javax.servlet.http.HttpSession;

import it.uniroma3.model.Users;


public class HelperAdminLogin {
	
	public boolean isLogged(HttpSession session) {
		Users user = (Users) session.getAttribute("user");
		boolean logged = true;
		
		if(user==null)
			logged = false;
		if(!user.getisAdmin())
			logged = false;
		
		return logged;
	}
}
