package it.uniroma3.controller.action;

import it.uniroma3.controller.helper.HelperAdminLogin;
import it.uniroma3.controller.helper.HelperAdvancedSearch;
import it.uniroma3.model.Track;
import it.uniroma3.model.TrackFacade;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class AdminTrackSearch implements Action {

	@Override
	public String perform(HttpServletRequest request) {
		HttpSession session = request.getSession();
		HelperAdminLogin hal = new HelperAdminLogin();
		if(!hal.isLogged(session))
			return "/controller/HomeLoad";
		
		HelperAdvancedSearch helper = new HelperAdvancedSearch();
		
		if(helper.isValid(request)) {
			String lyric = request.getParameter("lyric");
			String nameTrack = request.getParameter("name");
			String albumTitle = request.getParameter("album");
			String nameAuthor = request.getParameter("author");
			
			TrackFacade tf = new TrackFacade();
			List<Track> searchedTracks = tf.retrieveTracksByAdvancedSearch(lyric,nameTrack,albumTitle,nameAuthor);
			request.setAttribute("tracks", searchedTracks);		
			
			return "/admin/trackspanel.jsp";
		}
		return "/admin/searchtrack.jsp";
	}

}
