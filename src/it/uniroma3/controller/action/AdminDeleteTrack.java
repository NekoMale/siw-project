package it.uniroma3.controller.action;



import it.uniroma3.controller.helper.HelperAdminLogin;
import it.uniroma3.model.TrackFacade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class AdminDeleteTrack implements Action {

	@Override
	public String perform(HttpServletRequest request) {
		HttpSession session = request.getSession();
		HelperAdminLogin hal = new HelperAdminLogin();
		if(!hal.isLogged(session))
			return "/controller/HomeLoad";
		
		Long id = Long.parseLong(request.getParameter("id"));
		TrackFacade tf = new TrackFacade();
		if(tf.deleteTrack(id)) request.setAttribute("msg", "Brano eliminato con successo!");
		else request.setAttribute("msg", "Operazione non riuscita!");
		return "/controller/AdminTrackList";
	}

}
