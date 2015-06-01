package it.uniroma3.controller.action;

import it.uniroma3.model.*;

import javax.servlet.http.HttpServletRequest;

public class GetTrack implements Action {

	@Override
	public String perform(HttpServletRequest request) {
		String man = request.getParameter("man");
		TrackFacade tf = new TrackFacade();
		Track track = tf.findTrack(Long.parseLong(request.getParameter("id")));
		request.setAttribute("trackRequested", track);
		if(man != "on")
			return "/admin/edittrack.jsp";
		else
			return "/trackdetails.jsp";
	}

}
