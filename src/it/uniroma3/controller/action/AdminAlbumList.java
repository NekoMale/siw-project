package it.uniroma3.controller.action;

import it.uniroma3.controller.helper.HelperAdminLogin;
import it.uniroma3.model.Album;
import it.uniroma3.model.AlbumFacade;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class AdminAlbumList implements Action {

	@Override
	public String perform(HttpServletRequest request) {
		HttpSession session = request.getSession();
		HelperAdminLogin hal = new HelperAdminLogin();
		if(!hal.isLogged(session))
			return "/controller/HomeLoad";
		
		AlbumFacade af = new AlbumFacade();
		List<Album> albums = af.retrieveAllAlbums();
		request.setAttribute("albums", albums);
		return "/admin/albumspanel.jsp";
	}

}
