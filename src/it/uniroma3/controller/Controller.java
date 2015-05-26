package it.uniroma3.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import it.uniroma3.controller.action.*;

@WebServlet("/controller/*")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nextPage = null;
		String actionName = "it.uniroma3.controller.action."+request.getPathInfo().substring(1);
		Action action;
		
		try{
			action = (Action)Class.forName(actionName).newInstance();
			nextPage = action.perform(request);
		}catch(Exception e){
			request.setAttribute("err", e);
			nextPage="/index.jsp";
		}
		
		nextPage = response.encodeURL(nextPage);
		ServletContext application  = getServletContext();
		RequestDispatcher rd = application.getRequestDispatcher(nextPage);
		rd.forward(request, response);
		return; 
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nextPage = null;
		String actionName = "it.uniroma3.controller.action."+request.getPathInfo().substring(1);
		Action action;
		
		try{
			action = (Action)Class.forName(actionName).newInstance();
			nextPage = action.perform(request);
		}catch(Exception e){
			request.setAttribute("err", e);
			nextPage="/index.jsp";
		}
		
		nextPage = response.encodeURL(nextPage);
		ServletContext application  = getServletContext();
		RequestDispatcher rd = application.getRequestDispatcher(nextPage);
		rd.forward(request, response);
		return; 
	}

}
