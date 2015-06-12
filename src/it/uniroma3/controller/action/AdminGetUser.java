package it.uniroma3.controller.action;

import it.uniroma3.controller.helper.HelperAdminLogin;
import it.uniroma3.model.UserFacade;
import it.uniroma3.model.Users;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class AdminGetUser implements Action {

	@Override
	public String perform(HttpServletRequest request) {
		HttpSession session = request.getSession();
		HelperAdminLogin hal = new HelperAdminLogin();
		if(!hal.isLogged(session))
			return "/controller/HomeLoad";
		
		UserFacade uf = new UserFacade();
		Users user = uf.findUser(request.getParameter("username"));
		String man = request.getParameter("man");
		request.setAttribute("userRequested", user);
		request.setAttribute("man", man);
		request.setAttribute("msg", request.getParameter("msg"));
		return "/admin/userdetails.jsp";
	}

}
