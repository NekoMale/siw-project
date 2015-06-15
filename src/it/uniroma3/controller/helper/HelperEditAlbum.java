package it.uniroma3.controller.helper;

import it.uniroma3.model.AuthorFacade;

import javax.servlet.http.HttpServletRequest;

public class HelperEditAlbum {
	
	public boolean isValid(HttpServletRequest request) {
		boolean errors = false;
		String title = request.getParameter("title");
		String author = request.getParameter("author");

		if(title==null||title=="") {
			request.setAttribute("titleErr", "Campo Obbligatorio!");
			errors = true;
		}
		if(author==null||author=="") {
			request.setAttribute("authorErr", "Campo Obbligatorio!");
			errors = true;
		}
		else {
			AuthorFacade af = new AuthorFacade();
			if(af.getAuthor(author)==null) {
				request.setAttribute("authorErr", "Autore non esistente nel database!");
				errors = true;
			}
		}
		
		return !errors;
	}

}
