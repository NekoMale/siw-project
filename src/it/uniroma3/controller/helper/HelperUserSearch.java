package it.uniroma3.controller.helper;

import javax.servlet.http.HttpServletRequest;

public class HelperUserSearch {
	
	public boolean isValid(HttpServletRequest request) {
	String username = request.getParameter("username");
	String email = request.getParameter("email");
	Boolean errors = false;
	
	if( (username==null||username=="") && (email==null||email=="")){
		request.setAttribute("advancedErr", "Devi compilare almeno un campo!");
		errors = true;
	}
	
	return !errors;
	}

}
