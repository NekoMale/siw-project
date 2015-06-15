package it.uniroma3.controller.action;

import it.uniroma3.model.TrackFacade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class GetAllTracksByGenre implements Action{

	@Override
	public String perform(HttpServletRequest request) {
		TrackFacade tf = new TrackFacade();
		String genre = request.getParameter("genreName");
		request.setAttribute("tracks", tf.retrieveTracksByGenreOrdered(genre));
		return "/tracklist.jsp";
	}

}
