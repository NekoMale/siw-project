<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lyrics - Registrati</title>
</head>
<body>
	<h1>Inserisci i tuoi dati</h1>
	<form action="<c:url value="/Controller/Register" />" method="post">
	<div>Username: <input type="text" name="username" value="${param.username}"/>${usernameErr}</div>
	<div>Email: <input type="email" name="email" value="${param.email}"/>${emailErr}</div>
	<div>Conferma email: <input type="email" name=""/>${emailErr}</div>
	<div>Password: <input type="password" name="password" value="${param.password}"/>${passwdErr}</div>
	<div>Conferma password: <input type="password" name=""/>${passwdErr}</div>
	<input type="submit" value="registrati"/>
	</form>
</body>
</html>