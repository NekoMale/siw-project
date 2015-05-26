package it.uniroma3.controller.action;

import it.uniroma3.model.UserFacade;
import it.uniroma3.model.Users;

import javax.servlet.http.HttpServletRequest;

public class AdminGetUser implements Action {

	@Override
	public String perform(HttpServletRequest request) {
		UserFacade uf = new UserFacade();
		Users user = uf.findUser(request.getParameter("un"));
		request.setAttribute("userRequested", user);
		return "/admin/userdetails.jsp";
	}

}
