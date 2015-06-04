package it.uniroma3.controller.action;

import java.util.List;

import it.uniroma3.controller.helper.HelperFastSearch;
import it.uniroma3.model.Track;
import it.uniroma3.model.TrackFacade;

import javax.servlet.http.HttpServletRequest;

public class FastSearch implements Action {

	@Override
	public String perform(HttpServletRequest request) {
		
		HelperFastSearch helper = new HelperFastSearch();
		
		if(helper.isValid(request)) {
			String keyword = request.getParameter("keyword");
			TrackFacade tf = new TrackFacade();
			List<Track> searchedTracks = tf.retrieveTracksByKeyword(keyword);
			request.setAttribute("searchedTracks", searchedTracks);
					
			return "/searchresult.jsp";
		}
		return "/search.jsp";
		
	}

}
