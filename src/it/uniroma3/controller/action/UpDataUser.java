package it.uniroma3.controller.action;

import it.uniroma3.controller.helper.HelperUpdateUser;
import it.uniroma3.model.UserFacade;
import it.uniroma3.model.Users;

import javax.jms.Session;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class UpDataUser implements Action {

	@Override
	public String perform(HttpServletRequest request) {
		Long id = Long.parseLong(request.getParameter("id"));
		String username = request.getParameter("username");
		String email = request.getParameter("email");

		HttpSession session = request.getSession();
		
		HelperUpdateUser helper = new HelperUpdateUser();
		
		if(helper.isValid(request)){
			UserFacade uf = new UserFacade();
			if(uf.upDataUser(id,username,email)) {
				request.setAttribute("username", username);
				request.setAttribute("msg", "Operazione Avvenuta con successo!");
			}
			else request.setAttribute("msg", "Operazione non riuscita!");
		}
		if(((Users)session.getAttribute("user")).getisAdmin()){
			request.setAttribute("man", "on");
			Users user = new Users();
			user.setEmail(email);
			user.setUsername(username);
			user.setId(id);
			request.setAttribute("userRequested",user);
			return "/admin/userdetails.jsp";
		}
		else {
			request.setAttribute("err", "Sessione non mantenuta!");
			return "/index.jsp";
		}
	}

}
