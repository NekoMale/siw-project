package it.uniroma3.controller.helper;

import javax.servlet.http.HttpServletRequest;

public class HelperCreateTrack {
	
	public boolean isValid(HttpServletRequest request) {
		boolean errors = false;
		String author = request.getParameter("author");
		String album = request.getParameter("album");
		String genre = request.getParameter("genre");
		String name = request.getParameter("name");
		String lyric = request.getParameter("lyric");
		
		if(author==null||author=="") {
			request.setAttribute("authorErr", "Campo Obbligatorio!");
			errors = true;
		}
		if(album==null||album=="") {
			request.setAttribute("albumErr", "Campo Obbligatorio!");
			errors = true;
		}
		if(genre==null||genre=="") {
			request.setAttribute("genreErr", "Campo Obbligatorio!");
			errors = true;
		}
		if(name==null||name=="") {
			request.setAttribute("nameErr", "Campo Obbligatorio!");
			errors = true;
		}
		if(lyric==null||lyric=="") {
			request.setAttribute("lyricErr", "Campo Obbligatorio!");
			errors = true;
		}
		
		return !errors;
	}

}
