package it.uniroma3.controller.action;

import it.uniroma3.controller.helper.HelperEditUserData;
import it.uniroma3.model.UserFacade;
import it.uniroma3.model.Users;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class EditUserData implements Action {

	@Override
	public String perform(HttpServletRequest request) {
		HelperEditUserData helper = new HelperEditUserData();
		if(helper.isValid(request)) {
			HttpSession session = request.getSession();
			Users user = (Users) session.getAttribute("user");
			String username = request.getParameter("username");
			String email = request.getParameter("email");
			
			UserFacade uf = new UserFacade();
			if(uf.upDataUser(user.getId(), username, email)) {
				user.setEmail(email);
				user.setUsername(username);
				session.setAttribute("user", user);
				request.setAttribute("msg", "Operazione effettuata con successo!");
				return "/controller/GetUser";
			}
			request.setAttribute("updateErr", "Operazione non riuscita!");
			return "/editdata.jsp";
		}
		else {
			return "/editdata.jsp";
		}
	}

}
