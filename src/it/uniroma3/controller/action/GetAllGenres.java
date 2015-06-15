package it.uniroma3.controller.action;

import it.uniroma3.model.GenreFacade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class GetAllGenres implements Action {

	@Override
	public String perform(HttpServletRequest request) {
		GenreFacade gf = new GenreFacade();
		request.setAttribute("genres", gf.retrieveAllGenresOrdered());
		return "/genrelist.jsp";
	}
}
