package it.uniroma3.controller.action;

import it.uniroma3.controller.helper.HelperAdminLogin;
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

public class AdminEditTrack implements Action {

	@Override
	public String perform(HttpServletRequest request) {
		HttpSession session = request.getSession();
		HelperAdminLogin hal = new HelperAdminLogin();
		if(!hal.isLogged(session))
			return "/controller/HomeLoad";
		
		HelperCreateTrack helper = new HelperCreateTrack();
		
		if(helper.isValid(request)) {
			Long id = Long.parseLong(request.getParameter("id"));
			String authorName = request.getParameter("author");
			String albumTitle = request.getParameter("album");
			String genreName = request.getParameter("genre");
			
			AuthorFacade af = new AuthorFacade();
			Author author = af.getAuthor(authorName);
			Album album;
			if(author==null) {
				author = new Author(authorName);
				album = new Album(albumTitle);
				album.setAuthor(author);
			}
			else {
				AlbumFacade alf = new AlbumFacade();
				album = alf.getAlbumByAuthor(albumTitle,author.getName());
				if(album==null) {
					album = new Album(albumTitle);
					album.setAuthor(author);
				}
			}
			GenreFacade gf = new GenreFacade();
			Genre genre = gf.getGenre(genreName);
			if(genre==null) {
				genre = new Genre(genreName);
			}
			
			TrackFacade tf=new TrackFacade();
			if(tf.updateTrack(id, request.getParameter("name"),request.getParameter("lyric"), author, album, genre,request)) {
				request.setAttribute("msg", "Operazione Avvenuta con successo!");
			}
			else request.setAttribute("msg", "Operazione non riuscita!");
			
			return "/controller/AdminTrackList";	
		}
		else {
			return "/admin/edittrack.jsp";
		}
	}
}
