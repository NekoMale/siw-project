package it.uniroma3.controller.action;

import it.uniroma3.controller.helper.HelperAdminLogin;
import it.uniroma3.controller.helper.HelperEditUserData;
import it.uniroma3.model.UserFacade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class AdminEditUser implements Action {

	@Override
	public String perform(HttpServletRequest request) {
		HttpSession session = request.getSession();
		HelperAdminLogin hal = new HelperAdminLogin();
		if(!hal.isLogged(session))
			return "/controller/HomeLoad";
		

		HelperEditUserData helper = new HelperEditUserData();
		UserFacade uf = new UserFacade();
		if(helper.isValid(request)) {
			Long id = Long.parseLong(request.getParameter("id"));
			String username = request.getParameter("username");
			String email = request.getParameter("email");
			
			if(uf.upDataUser(id, username, email)) {
				request.setAttribute("msg", "Operazione effettuata con successo!");
				return "/controller/AdminUserList";
			}
			request.setAttribute("updateErr", "Operazione non riuscita!");
			return "/controller/AdminUserList";
		}
		else {
			request.setAttribute("man","on");
			request.setAttribute("userRequested",uf.findUser(Long.parseLong(request.getParameter("id"))));
			return "/admin/userdetails.jsp";
		}
	}
}
