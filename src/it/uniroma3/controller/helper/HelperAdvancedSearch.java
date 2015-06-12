package it.uniroma3.controller.helper;

import javax.servlet.http.HttpServletRequest;

public class HelperAdvancedSearch {

	public boolean isValid(HttpServletRequest request) {
		String name = request.getParameter("name");
		String lyric = request.getParameter("lyric");
		String album = request.getParameter("album");
		String author = request.getParameter("author");
		Boolean errors = false;
		
		if( (name==null||name=="") && (lyric==null||lyric=="") && (album==null||album=="") && (author==null||author=="")){
			request.setAttribute("advancedErr", "Devi compilare almeno un campo!");
			errors = true;
		}
		
		return !errors;
	}

}