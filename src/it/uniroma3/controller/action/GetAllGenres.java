package it.uniroma3.controller.action;

import it.uniroma3.model.GenreFacade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class GetAllGenres implements Action {

	@Override
	public String perform(HttpServletRequest request) {
		HttpSession session = request.getSession();
		GenreFacade gf = new GenreFacade();
		request.setAttribute("Genres", gf.retrieveAllGenres());
		return "/genrelist.jsp";
	}
}
