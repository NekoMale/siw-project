package it.uniroma3.controller.action;

import it.uniroma3.controller.helper.HelperRegister;
import it.uniroma3.model.*;

import javax.servlet.http.HttpServletRequest;

public class Register implements Action {

	public String perform(HttpServletRequest request) {
		
		HelperRegister helper=new HelperRegister();
		
		if(helper.isValid(request)){
			String username = request.getParameter("username");
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			
			UserFacade uf = new UserFacade();
			Users user = uf.register(username, email, password);
			request.setAttribute("userReg", user);
			
			return "/regconf.jsp";
		}else{
			return "/register.jsp";
		}
	}
}