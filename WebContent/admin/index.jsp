<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Benvenuto ${user.username}</h1>
	<a href="<c:url value="/controller/AdminTrackList" />">Gestione Canzoni</a><br>
	<a href="<c:url value="/controller/AdminUserList" />">Gestione Utenti</a>
</body>
</html>