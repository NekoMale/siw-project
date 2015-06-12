package it.uniroma3.controller.action;

import it.uniroma3.model.UserFacade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class GetUser implements Action{

	@Override
	public String perform(HttpServletRequest request) {
		HttpSession session = request.getSession();
		UserFacade uf=new UserFacade();
		request.setAttribute("userRequested",uf.findUser(request.getParameter("username")));
		return "/userprofile.jsp";
	}

}
