<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Inserisci una nuova canzone</h1>
	
	<form action="<c:url value="/controller/AdminCreateTrack" />" method="post">
	<div>Titolo: <input type="text" name="title" value="${track.name}"/></div>
	<div>Autore: <input type="text" name="author" value="${track.author.name}"/></div>
	<div>Album: <input type="text" name="album" value="${track.album.title}"/></div>
	<div>Genere: <input type="text" name="genre" value="${track.genre.name}"/></div>
	<div>Testo: <textarea  name="lyric">${track.lyric}</textarea></div>
	<div><input type="submit" value="Conferma"/></div>
	</form>	
</body>
</html>