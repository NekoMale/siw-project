package it.uniroma3.controller.action;

import java.util.List;

import it.uniroma3.controller.helper.HelperAdvancedSearch;
import it.uniroma3.model.Track;
import it.uniroma3.model.TrackFacade;

import javax.servlet.http.HttpServletRequest;

public class AdvancedSearch implements Action {

	@Override
	public String perform(HttpServletRequest request) {
		
		HelperAdvancedSearch helper = new HelperAdvancedSearch();
		
		if(helper.isValid(request)) {
			String lyric = request.getParameter("lyric");
			String nameTrack = request.getParameter("name");
			String albumTitle = request.getParameter("album");
			String nameAuthor = request.getParameter("author");
			
			TrackFacade tf = new TrackFacade();
			List<Track> searchedTracks = tf.retrieveTracksByAdvancedSearch(lyric,nameTrack,albumTitle,nameAuthor);
			request.setAttribute("searchedTracks", searchedTracks);		
			
			return "/searchresult.jsp";
		}
		return "/advancedsearch.jsp";
	}

}