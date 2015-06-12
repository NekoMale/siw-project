package it.uniroma3.controller.action;

import it.uniroma3.model.TrackFacade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class GetAllTracks implements Action {

	@Override
	public String perform(HttpServletRequest request) {
		HttpSession session = request.getSession();
		TrackFacade tf = new TrackFacade();
		request.setAttribute("Tracks", tf.retrieveAllTracks());
		return "/tracklist.jsp";
	}
}
