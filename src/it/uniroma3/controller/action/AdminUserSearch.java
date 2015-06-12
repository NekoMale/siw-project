package it.uniroma3.controller.action;

import it.uniroma3.controller.helper.HelperAdminLogin;
import it.uniroma3.controller.helper.HelperAdvancedSearch;
import it.uniroma3.controller.helper.HelperUserSearch;
import it.uniroma3.model.Track;
import it.uniroma3.model.TrackFacade;
import it.uniroma3.model.UserFacade;
import it.uniroma3.model.Users;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class AdminUserSearch implements Action {

	@Override
	public String perform(HttpServletRequest request) {
		HttpSession session = request.getSession();
		HelperAdminLogin hal = new HelperAdminLogin();
		if(!hal.isLogged(session))
			return "/controller/HomeLoad";
		
		HelperUserSearch helper = new HelperUserSearch();
		
		if(helper.isValid(request)) {
			String username = request.getParameter("username");
			String email = request.getParameter("email");
			
			UserFacade uf = new UserFacade();
			List<Users> searchedUsers = uf.retrieveUsersByAdvancedSearch(username, email);
			request.setAttribute("users", searchedUsers);		
			
			return "/admin/userspanel.jsp";
		}
		return "/admin/searchuser.jsp";
	}

}
