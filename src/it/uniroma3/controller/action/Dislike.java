package it.uniroma3.controller.action;

import it.uniroma3.model.Favourites;
import it.uniroma3.model.FavouritesFacade;
import it.uniroma3.model.Track;
import it.uniroma3.model.TrackFacade;
import it.uniroma3.model.Users;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class Dislike implements Action {

	@Override
	public String perform(HttpServletRequest request) {
		HttpSession session = request.getSession();
		TrackFacade tf = new TrackFacade();
		Track track = tf.findTrack(Long.parseLong(request.getParameter("idTrack")));
		Users user = (Users)(session.getAttribute("user"));
		FavouritesFacade ff = new FavouritesFacade();
		Favourites fav = ff.deleteFav(track,user);
		if(fav==null)
			request.setAttribute("fav", "0");
		else
			request.setAttribute("fav", fav.getId());
		request.setAttribute("trackRequested", track);
		return "/trackdetails.jsp";
	}

}
