package it.uniroma3.controller.action;

import it.uniroma3.model.FavouritesFacade;
import it.uniroma3.model.Track;
import it.uniroma3.model.UserFacade;
import it.uniroma3.model.Users;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class Like implements Action {

	@Override
	public String perform(HttpServletRequest request) {
		HttpSession session = request.getSession();
		Track track =(Track)(request.getAttribute("track"));
		Users user = (Users)(session.getAttribute("user"));
		FavouritesFacade ff = new FavouritesFacade();
		ff.createFav(track,user);
		request.setAttribute("id", track.getId());
		return "/controller/GetTrack";
	}

}
