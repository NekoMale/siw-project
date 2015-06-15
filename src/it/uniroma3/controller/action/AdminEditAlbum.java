package it.uniroma3.controller.action;

import it.uniroma3.controller.helper.HelperAdminLogin;
import it.uniroma3.controller.helper.HelperEditAlbum;
import it.uniroma3.controller.helper.HelperCreateTrack;
import it.uniroma3.model.Album;
import it.uniroma3.model.AlbumFacade;
import it.uniroma3.model.Author;
import it.uniroma3.model.AuthorFacade;
import it.uniroma3.model.Genre;
import it.uniroma3.model.GenreFacade;
import it.uniroma3.model.Track;
import it.uniroma3.model.TrackFacade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class AdminEditAlbum implements Action {

	@Override
	public String perform(HttpServletRequest request) {
		HttpSession session = request.getSession();
		HelperAdminLogin hal = new HelperAdminLogin();
		if(!hal.isLogged(session))
			return "/controller/HomeLoad";
		
		HelperEditAlbum helper = new HelperEditAlbum();
		
		if(helper.isValid(request)) {
			Long id = Long.parseLong(request.getParameter("id"));
			String title = request.getParameter("title");
			String authorName = request.getParameter("author");
			int year = 0;
			if(request.getParameter("year")!=""&&request.getParameter("year")!=null) 
				year = Integer.parseInt(request.getParameter("year"));
			
			AlbumFacade af = new AlbumFacade();
			AuthorFacade auf = new AuthorFacade();
			Author author = auf.getAuthor(authorName);
			
			if(af.updateAlbum(id,title,year,author)) {
				request.setAttribute("msg", "Operazione Avvenuta con successo!");
			}
			else request.setAttribute("msg", "Operazione non riuscita!");
			
			return "/controller/AdminAlbumList";	
		}
		else {
			request.setAttribute("id", request.getParameter("id"));
			return "/controller/AdminGetAlbum";
		}
	}
}
