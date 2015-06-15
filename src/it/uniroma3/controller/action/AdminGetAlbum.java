package it.uniroma3.controller.action;

import it.uniroma3.controller.helper.HelperAdminLogin;
import it.uniroma3.model.Album;
import it.uniroma3.model.AlbumFacade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class AdminGetAlbum implements Action {

	@Override
	public String perform(HttpServletRequest request) {
		HttpSession session = request.getSession();
		HelperAdminLogin hal = new HelperAdminLogin();
		if(!hal.isLogged(session))
			return "/controller/HomeLoad";
		
		Long id = Long.parseLong(request.getParameter("id"));
		AlbumFacade af = new AlbumFacade();
		Album album = af.findAlbum(id);
		request.setAttribute("albumRequested", album);
		return "/admin/editalbum.jsp";
	}

}
