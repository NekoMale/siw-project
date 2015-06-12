package it.uniroma3.controller.action;

import java.util.List;

import it.uniroma3.controller.helper.HelperAdminLogin;
import it.uniroma3.model.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class AdminTrackList implements Action {

	@Override
	public String perform(HttpServletRequest request) {
		HttpSession session = request.getSession();
		HelperAdminLogin hal = new HelperAdminLogin();
		if(!hal.isLogged(session))
			return "/controller/HomeLoad";
		
		TrackFacade tf = new TrackFacade();
		List<Track> tracks = tf.retrieveAllTracks();
		request.setAttribute("tracks", tracks);
		request.setAttribute("msg", request.getParameter("msg"));
		return "/admin/trackspanel.jsp";
	}

}
