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
		Track track = tf.findTrack(Long.parseLong(request.getParameter("id")));
		Users user = (Users) session.getAttribute("user");
		request.setAttribute("trackRequested", track);
		
		FavouritesFacade ff = new FavouritesFacade();
		Favourites fav = ff.findFav(user,track);
		if(fav==null)
			request.setAttribute("fav", 0);
		else
			request.setAttribute("fav", fav.getId());
		
		if(man != null && man != "")
			return "/admin/edittrack.jsp";
		else
			return "/trackdetails.jsp";
	}

}
