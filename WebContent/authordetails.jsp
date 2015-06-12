<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lyrics - Dettagli ${authorRequested.name}</title>
</head>
<body> 	 	
	<table>
		<tr><td><h1>${authorRequested.name}</h1></td></tr>
		<tr><td>Data debutto: ${authorRequested.debut}</td></tr>
		<tr><td>Informazioni: ${authorRequested.info}</td></tr>
	</table>
	
	<a href="<c:url value="/controller/AdvancedSearch?name=&album=&author=${authorRequested.name}&lyric=&genre=" />">Vai alla lista delle canzoni di ${authorRequested.name}</a>

	<h2>Discografia di ${authorRequested.name}</h2>
	<table>
		<tr><td><h4>Anno</h4></td><td><h4>Titolo</h4></td></tr>
		<c:forEach var="albums" items="${authorRequested.album}">
		<tr><td>${albums.year}</td><td>${albums.title}</td></tr>
		</c:forEach>
	</table>
</body>
</html>