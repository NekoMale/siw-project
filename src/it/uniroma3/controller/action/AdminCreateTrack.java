package it.uniroma3.controller.action;

import it.uniroma3.model.*;

import javax.servlet.http.HttpServletRequest;

public class AdminCreateTrack implements Action {

	@Override
	public String perform(HttpServletRequest request) {
				
		Author aut = new Author();
		aut.setName(request.getParameter("author"));
		
		Album al = new Album();
		al.setTitle(request.getParameter("album"));
		
		Genre gen = new Genre();
		gen.setName(request.getParameter("genre"));
		
		TrackFacade tf=new TrackFacade();
		Track t = tf.createTrack(request.getParameter("name"),request.getParameter("lyric"), aut, al, gen);
		
		/*new Track(request.getParameter("name"), request.getParameter("lyric"));
		t.setAuthor(aut);
		t.setAlbum(al);
		t.setGenre(gen);*/
		
		//request.setAttribute("track",t);
		
		
		return "/admin/trackpanel.jsp";
	}

}
