package it.uniroma3.controller.helper;

import javax.servlet.http.HttpServletRequest;

public class HelperEditAuthor {

	public boolean isValid(HttpServletRequest request) {
		String authorName = request.getParameter("name");
		boolean errors = false;
		
		if(authorName==null||authorName=="") {
			request.setAttribute("nameErr", "Campo Obbligatorio");
			errors = true;
		}
		
		return !errors;
	}

}
