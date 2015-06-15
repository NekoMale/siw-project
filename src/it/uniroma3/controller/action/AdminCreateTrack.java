package it.uniroma3.controller.action;

import it.uniroma3.controller.helper.HelperCreateTrack;
import it.uniroma3.model.*;

import javax.servlet.http.HttpServletRequest;

public class AdminCreateTrack implements Action {

	@Override
	public String perform(HttpServletRequest request) {
		HelperCreateTrack helper = new HelperCreateTrack();
		
		if(helper.isValid(request)) {
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
			Track track = tf.createTrack(request.getParameter("name"),request.getParameter("lyric"), author, album, genre);
			
			return "/controller/AdminTrackList";
		}
		else {
			request.setAttribute("name", request.getParameter("name"));
			request.setAttribute("author", request.getParameter("author"));
			request.setAttribute("album", request.getParameter("album"));
			request.setAttribute("lyric", request.getParameter("lyric"));
			request.setAttribute("genre", request.getParameter("genre"));
			return "/admin/createtrack.jsp";
		}
	}
}
