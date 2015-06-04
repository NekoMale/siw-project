<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Insert title here</title>
	</head>
	<body>
		${msg}
		<table>
			<tr>
				<th>Titolo</th>
				<th>Autore</th>
				<th>Album</th>
				<th>Genere</th>
			</tr>
			<c:forEach var="searchedTracks" items="${searchedTracks}">
				<tr>
					<td><a href="<c:url value="/controller/GetTrack?id=${searchedTracks.id}" />" target = "_blank">${searchedTracks.name}</a></td>
					<td>${searchedTracks.author.name}</td>
					<td>${searchedTracks.album.title}</td>
					<td>${searchedTracks.genre.name}</td>
				</tr>
			</c:forEach>
		</table>
	</body>
</html>