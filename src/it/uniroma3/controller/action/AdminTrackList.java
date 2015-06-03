package it.uniroma3.controller.action;

import java.util.List;
import it.uniroma3.model.*;
import javax.servlet.http.HttpServletRequest;

public class AdminTrackList implements Action {

	@Override
	public String perform(HttpServletRequest request) {
		TrackFacade tf = new TrackFacade();
		List<Track> tracks = tf.retrieveAllTracks();
		request.setAttribute("tracks", tracks);
		return "/admin/trackspanel.jsp";
	}

}
