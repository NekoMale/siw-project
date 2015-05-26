package it.uniroma3.controller.action;

import java.util.List;

import it.uniroma3.model.UserFacade;
import it.uniroma3.model.Users;

import javax.servlet.http.HttpServletRequest;

public class AdminUserList implements Action {

	@Override
	public String perform(HttpServletRequest request) {
		UserFacade uf = new UserFacade();
		List<Users> users = uf.retrieveAllUsers();
		request.setAttribute("users", users);
		return "/admin/pannelloutenti.jsp";
	}

}
