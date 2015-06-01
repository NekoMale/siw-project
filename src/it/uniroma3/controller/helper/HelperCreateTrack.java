package it.uniroma3.controller.helper;

import it.uniroma3.model.AuthorFacade;

import javax.servlet.http.HttpServletRequest;

public class HelperCreateTrack {
	
	public HelperCreateTrack() {}
	
	public boolean isValid(HttpServletRequest request) {
		boolean errors = false;
		String author = request.getParameter("author");
		String album = request.getParameter("album");
		String genre = request.getParameter("genre");
		String name = request.getParameter("name");
		String lyric = request.getParameter("lyric");
		
		if(author==null||author=="") {
			errors = true;
		}
		if(album==null||album=="") {
			errors = true;
		}
		if(genre==null||genre=="") {
			errors = true;
		}
		if(name==null||name=="") {
			errors = true;
		}
		if(lyric==null||lyric=="") {
			errors = true;
		}
		
		return !errors;
	}

}
