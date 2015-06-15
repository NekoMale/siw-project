package it.uniroma3.controller.action;

import java.util.List;

import it.uniroma3.model.Favourites;
import it.uniroma3.model.FavouritesFacade;
import it.uniroma3.model.UserFacade;
import it.uniroma3.model.Users;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class GetUser implements Action{

	@Override
	public String perform(HttpServletRequest request) {
		HttpSession session = request.getSession();
		FavouritesFacade ff = new FavouritesFacade();
		Users user = (Users) session.getAttribute("user");
		List<Favourites> favs = ff.getFavsOrdered(user.getUsername());
		request.setAttribute("favs",favs);
		return "/userprofile.jsp";
	}

}
