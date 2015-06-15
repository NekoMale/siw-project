package it.uniroma3.controller.helper;

import it.uniroma3.model.FavouritesFacade;
import it.uniroma3.model.TrackFacade;
import it.uniroma3.model.Users;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class HelperDislike {

	public boolean isValid(HttpServletRequest request) {
		HttpSession session = request.getSession();
		Users user = (Users)(session.getAttribute("user"));	
		Long idTrack = Long.parseLong(request.getParameter("idTrack"));
		boolean errors = false;
		
		if(user==null||idTrack==null) {
			request.setAttribute("err", "Errore nella trasmissione dei dati!");
			errors = true;
		}
		
		FavouritesFacade ff = new FavouritesFacade();
		TrackFacade tf = new TrackFacade();
		if(ff.getFav(user, tf.findTrack(idTrack))==null) {
			request.setAttribute("err", "Hai già tolto il mi piace a questa canzone!");
			errors = true;
		}
		
		return !errors;
	}

}
