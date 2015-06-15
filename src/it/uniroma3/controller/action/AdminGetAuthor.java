package it.uniroma3.controller.action;

import it.uniroma3.controller.helper.HelperAdminLogin;
import it.uniroma3.model.Author;
import it.uniroma3.model.AuthorFacade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class AdminGetAuthor implements Action {

	@Override
	public String perform(HttpServletRequest request) {
		HttpSession session = request.getSession();
		HelperAdminLogin hal = new HelperAdminLogin();
		if(!hal.isLogged(session))
			return "/controller/HomeLoad";
		
		Long id = Long.parseLong(request.getParameter("id"));
		AuthorFacade af = new AuthorFacade();
		Author author = af.findAuthor(id);
		request.setAttribute("authorRequested", author);
		return "/admin/editauthor.jsp";
	}

}
