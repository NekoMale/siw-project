package it.uniroma3.controller.action;

import it.uniroma3.model.TrackFacade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class GetAllTracks implements Action {

	@Override
	public String perform(HttpServletRequest request) {
		TrackFacade tf = new TrackFacade();
		request.setAttribute("tracks", tf.retrieveAllTracksOrdered());
		return "/tracklist.jsp";
	}
}
