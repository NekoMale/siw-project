<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lyrics - Lista Canzoni</title>
</head>
<body>
	<table>
		<tr><h1>Lista canzoni</h1></tr>
		<c:forEach var="Tracks" items="${Tracks}">
		<tr>
			<td><a href="<c:url value="/controller/GetTrack?id=${Tracks.id}" />" target = "_blank">${Tracks.name}</a></td>
			<td>${Tracks.author.name}</td>
			<td>${Tracks.album.title}</td>
			<td>${Tracks.genre.name}</td>
		</tr>
		</c:forEach>
	</table>	
</body>
</html>