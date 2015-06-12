package it.uniroma3.controller.action;

import java.util.List;

import it.uniroma3.controller.helper.HelperAdminLogin;
import it.uniroma3.model.UserFacade;
import it.uniroma3.model.Users;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class AdminUserList implements Action {

	@Override
	public String perform(HttpServletRequest request) {
		HttpSession session = request.getSession();
		HelperAdminLogin hal = new HelperAdminLogin();
		if(!hal.isLogged(session))
			return "/controller/HomeLoad";
		
		UserFacade uf = new UserFacade();
		List<Users> users = uf.retrieveAllUsers();
		request.setAttribute("users", users);
		return "/admin/userspanel.jsp";
	}

}
