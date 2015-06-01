<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Modifica ${trackRequested.name}</h1>
	
	<form action="<c:url value="/controller/AdminEditTrack" />" method="post">
	<input type="hidden" name="id" value="${trackRequested.id}"/>
	<div>Titolo: <input type="text" name="name" value="${trackRequested.name}"/></div>
	<div>Autore: <input type="text" name="author" value="${trackRequested.author.name}"/></div>
	<div>Album: <input type="text" name="album" value="${trackRequested.album.title}"/></div>
	<div>Genere: <input type="text" name="genre" value="${trackRequested.genre.name}"/></div>
	<div>Testo: <textarea  name="lyric">${trackRequested.lyric}</textarea></div>
	<div><input type="submit" value="Conferma"/></div>
	</form>	
</body>
</html>