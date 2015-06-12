package it.uniroma3.controller.action;

import it.uniroma3.controller.helper.HelperAdminLogin;
import it.uniroma3.model.UserFacade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class AdminDeleteUser implements Action {

	@Override
	public String perform(HttpServletRequest request) {
		HttpSession session = request.getSession();
		HelperAdminLogin hal = new HelperAdminLogin();
		if(!hal.isLogged(session))
			return "/controller/HomeLoad";
		
		Long id = Long.parseLong(request.getParameter("id"));
		UserFacade uf = new UserFacade();
		if(uf.deleteUser(id)) request.setAttribute("msg", "Utente eliminato con successo!");
		else request.setAttribute("msg", "Operazione non riuscita!");
		return "/controller/AdminUserList";
	}

}
