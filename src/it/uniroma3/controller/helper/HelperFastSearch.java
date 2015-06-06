package it.uniroma3.controller.helper;

import javax.servlet.http.HttpServletRequest;

public class HelperFastSearch {

	public boolean isValid(HttpServletRequest request) {
		String keyword = request.getParameter("keyword");
		Boolean errors = false;
		
		if(keyword==null||keyword==""){
			request.setAttribute("keywordErr", "Devi scrivere qualcosa!");
			errors = true;
		}
		
		return !errors;
	}

}
