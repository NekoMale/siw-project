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
${man}
<h1>${trackRequested.author.name} - ${trackRequested.name}</h1>
<div>titolo = ${trackRequested.name}</div>
<div>autore = ${trackRequested.author.name}</div>
<div>album = ${trackRequested.album.title}</div>
<div>genere = ${trackRequested.genre.name}</div>
<div>testo = ${trackRequested.lyric}</div>
</body>
</html>