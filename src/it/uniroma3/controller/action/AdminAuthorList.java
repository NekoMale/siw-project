package it.uniroma3.controller.action;

import it.uniroma3.controller.helper.HelperAdminLogin;
import it.uniroma3.model.Author;
import it.uniroma3.model.AuthorFacade;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class AdminAuthorList implements Action {

	@Override
	public String perform(HttpServletRequest request) {
		HttpSession session = request.getSession();
		HelperAdminLogin hal = new HelperAdminLogin();
		if(!hal.isLogged(session))
			return "/controller/HomeLoad";
		
		AuthorFacade af = new AuthorFacade();
		List<Author> authors = af.retrieveAllAuthors();
		request.setAttribute("authors", authors);
		return "/admin/authorspanel.jsp";
	}

}
