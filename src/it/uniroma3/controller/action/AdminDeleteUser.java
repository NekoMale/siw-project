package it.uniroma3.controller.action;

import it.uniroma3.model.UserFacade;

import javax.servlet.http.HttpServletRequest;

public class AdminDeleteUser implements Action {

	@Override
	public String perform(HttpServletRequest request) {
		Long id = Long.parseLong(request.getParameter("id"));
		UserFacade uf = new UserFacade();
		if(uf.deleteUser(id)) request.setAttribute("msg", "Utente eliminato con successo!");
		else request.setAttribute("msg", "Operazione non riuscita!");
		return "/controller/AdminUserList";
	}

}
