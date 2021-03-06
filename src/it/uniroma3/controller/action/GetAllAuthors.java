package it.uniroma3.controller.action;

import it.uniroma3.model.AuthorFacade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class GetAllAuthors implements Action {

	@Override
	public String perform(HttpServletRequest request) {
		AuthorFacade af = new AuthorFacade();
		request.setAttribute("authors", af.retrieveAllAuthorsOrdered());
		return "/authorlist.jsp";
	}

}
