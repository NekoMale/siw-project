package it.uniroma3.controller.helper;

import javax.servlet.http.HttpServletRequest;

public class HelperRegister {
	
	public HelperRegister(){
		
	}
	
	public boolean isValid(HttpServletRequest request){
		
		String username = request.getParameter("username");
		String email = request.getParameter("email");
		String confEmail = request.getParameter("confemail");
		String password = request.getParameter("password");
		String confPassword = request.getParameter("confpassword");
		boolean errors=false;
		
		if(username==null||username==""){
			request.setAttribute("usernameErr","Campo obbligatorio");
			errors = true;
		}
				
		if(email==null||email==""){
			request.setAttribute("emailErr","Campo obbligatorio");
			errors = true;
		}else if((!(email.equals(confEmail)))){
			request.setAttribute("emailErr","Le email non corrispondono");
			request.setAttribute("confEmailErr","Le email non corrispondono");
			errors = true;
		}
		
		if(password==null||password==""){
			request.setAttribute("passwordErr","Campo obbligatorio");
			errors = true;
		}else if(!(password.equals(confPassword))){
			request.setAttribute("passwordErr","Le password non corrispondono");
			request.setAttribute("confPasswordErr","Le password non corrispondono");
			errors = true;
		}
		
		return !errors;
	}
	
}
