<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lyrics - Pannello Canzoni</title>
</head>
<body>
	<a href="<c:url value="/admin/createtrack.jsp" />" >Inserisci una nuova canzone</a>
	${msg}
	<table>
		<tr>
			<th>Titolo</th>
			<th>Autore</th>
			<th>Album</th>
			<th>Genere</th>
		</tr>
		<c:forEach var="track" items="${tracks}">
			<tr>
				<td><a href="<c:url value="/controller/GetTrack?id=${track.id}" />" target = "_blank">${track.name}</a></td>
				<td>${track.author.name}</td>
				<td>${track.album.title}</td>
				<td>${track.genre.name}</td>
				<td><form action="<c:url value="/controller/GetTrack" />" method="get">
					<input type="hidden" name="man" value="on"/>
					<input type="hidden" name="id" value="${track.id}"/>
					<input type="submit" value="gestisci"/>
					</form></td>
				<td><form action="<c:url value="/admin/confdeletetrack.jsp" />" method="get">
					<input type="hidden" name="id" value="${track.id}"/>
					<input type="hidden" name="name" value="${track.name}"/>
					<input type="submit" value="elimina"/>
					</form></td>
			</tr>
		</c:forEach>
	</table>
	${errUpdate}
	${msg}
</html>