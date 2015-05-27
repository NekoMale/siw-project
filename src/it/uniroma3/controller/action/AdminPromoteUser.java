package it.uniroma3.controller.action;

import it.uniroma3.model.UserFacade;
import it.uniroma3.model.Users;

import javax.servlet.http.HttpServletRequest;

public class AdminPromoteUser implements Action {

	@Override
	public String perform(HttpServletRequest request) {
		Long id = Long.parseLong(request.getParameter("id"));
		UserFacade uf = new UserFacade();
		if(uf.promoteUser(id)) request.setAttribute("msg", "Operazione Avvenuta con successo!");
		else request.setAttribute("msg", "Operazione non riuscita!");
		return "/controller/AdminUserList";
	}

}
