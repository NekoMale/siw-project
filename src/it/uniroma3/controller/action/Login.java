package it.uniroma3.controller.action;

import it.uniroma3.controller.helper.HelperLogin;
import it.uniroma3.model.UserFacade;
import it.uniroma3.model.Utente;

import javax.servlet.http.HttpServletRequest;

public class Login implements Action {

	@Override
	public String perform(HttpServletRequest request) {
		
		HelperLogin helper = new HelperLogin();
		
		if(helper.isValid(request)){
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			
			UserFacade uf = new UserFacade();
			Utente user = uf.findUser(username);
			request.setAttribute("user", user);
			
			return "/index.jsp";
		}else{
			return "/login.jsp";
		}
	}

}
