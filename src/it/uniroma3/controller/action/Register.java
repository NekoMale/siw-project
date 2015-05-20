package it.uniroma3.controller.action;

import it.uniroma3.model.*;

import javax.servlet.http.HttpServletRequest;

public class Register implements Action {

	@Override
	public String perform(HttpServletRequest request) {
		
		String username = request.getParameter("username");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		UserFacade uf = new UserFacade();
		Utente user = uf.register(username, email, password);
		request.setAttribute("user", user);
		
		return "/regconf.jsp";
	}

}
