package it.uniroma3.controller.action;

import it.uniroma3.model.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class GetTrack implements Action {

	@Override
	public String perform(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String man = request.getParameter("man");
		TrackFacade tf = new TrackFacade();
		FavouritesFacade ff = new FavouritesFacade();
		Track track = tf.findTrack(Long.parseLong(request.getParameter("id")));
		Users user = (Users) session.getAttribute("user");
		Favourites fav = ff.findFav(user,track);
		request.setAttribute("trackRequested", track);
		request.setAttribute("favourite", fav);
		if(man != null && man != "")
			return "/admin/edittrack.jsp";
		else
			return "/trackdetails.jsp";
	}

}
