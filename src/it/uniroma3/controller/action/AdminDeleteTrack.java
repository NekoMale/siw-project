package it.uniroma3.controller.action;



import it.uniroma3.model.TrackFacade;

import javax.servlet.http.HttpServletRequest;

public class AdminDeleteTrack implements Action {

	@Override
	public String perform(HttpServletRequest request) {
		Long id = Long.parseLong(request.getParameter("id"));
		TrackFacade tf = new TrackFacade();
		if(tf.deleteTrack(id)) request.setAttribute("msg", "Brano eliminato con successo!");
		else request.setAttribute("msg", "Operazione non riuscita!");
		return "/controller/AdminTrackList";
	}

}
