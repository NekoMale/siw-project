<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lyrics - Lista Generi</title>
</head>
<body>
	<table>
		<tr><h1>Lista generi</h1></tr>
		<c:forEach var="Genres" items="${Genres}">
		<tr>
			<td><a href="<c:url value="/controller/GetAllTracksByGenre?genreName=${Genres.name}" />">${Genres.name}</a></td>
		</tr>
		</c:forEach>
</body>
</html>