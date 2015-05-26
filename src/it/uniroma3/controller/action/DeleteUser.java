package it.uniroma3.controller.action;

import it.uniroma3.model.UserFacade;

import javax.servlet.http.HttpServletRequest;

public class DeleteUser implements Action {

	@Override
	public String perform(HttpServletRequest request) {
		UserFacade uf = new UserFacade();
		return null;
	}

}
