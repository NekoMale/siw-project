package it.uniroma3.controller.action;

import it.uniroma3.controller.helper.HelperAdminLogin;
import it.uniroma3.controller.helper.HelperEditAlbum;
import it.uniroma3.controller.helper.HelperCreateTrack;
import it.uniroma3.controller.helper.HelperEditAuthor;
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

public class AdminEditAuthor implements Action {

	@Override
	public String perform(HttpServletRequest request) {
		HttpSession session = request.getSession();
		HelperAdminLogin hal = new HelperAdminLogin();
		if(!hal.isLogged(session))
			return "/controller/HomeLoad";
		
		HelperEditAuthor helper = new HelperEditAuthor();
		
		if(helper.isValid(request)) {
			Long id = Long.parseLong(request.getParameter("id"));
			String name = request.getParameter("name");
			int debut = 0;
			if(request.getParameter("debut")!=""&&request.getParameter("debut")!=null)
				debut = Integer.parseInt(request.getParameter("debut"));
			String info = request.getParameter("info");
			
			AuthorFacade af = new AuthorFacade();
			if(af.updateAuthor(id,name,debut,info)) {
				request.setAttribute("msg", "Operazione Avvenuta con successo!");
			}
			else request.setAttribute("msg", "Operazione non riuscita!");
			
			return "/controller/AdminAuthorList";	
		}
		else {
			request.setAttribute("id", request.getParameter("id"));
			return "/controller/AdminGetAuthor";
		}
	}
}
