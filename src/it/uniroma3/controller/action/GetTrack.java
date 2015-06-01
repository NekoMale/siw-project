package it.uniroma3.controller.action;

import it.uniroma3.model.*;

import javax.servlet.http.HttpServletRequest;

public class GetTrack implements Action {

	@Override
	public String perform(HttpServletRequest request) {
		TrackFacade tf = new TrackFacade();
		Track track = tf.findTrack(Long.parseLong(request.getParameter("id")));
		request.setAttribute("trackRequested", track);
		return "/trackdetails.jsp";
	}

}
