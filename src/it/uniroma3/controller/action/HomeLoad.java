package it.uniroma3.controller.action;

import it.uniroma3.model.TrackFacade;
import it.uniroma3.model.Track;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

public class HomeLoad implements Action {

	@Override
	public String perform(HttpServletRequest request) {
		TrackFacade tf = new TrackFacade();
		List<Track> lastTracks = tf.retrieveLastTracks();
		List<Track> likedTracks = tf.retrieveLikedTracks();
		request.setAttribute("lastTracks", lastTracks);
		request.setAttribute("likedTracks", likedTracks);
		return "/home.jsp";
	}
}
