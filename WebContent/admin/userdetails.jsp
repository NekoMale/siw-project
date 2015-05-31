<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Dettagli ${userRequested.username}</h1>
	<h3>${msg}</h3>
		<c:choose>
			<c:when test="${man!=null}">
				<form action="<c:url value="/controller/UpDataUser" />" method="post">
				<input type="hidden" name="id" value="${userRequested.id}"/>
				<label for="username">Username: </label>
				<input type="text" id="username" name="username" value="${userRequested.username}"/>${usernameErr}<br>
				<label for="email">Email: </label>
				<input type="email" id="email" name="email" value="${userRequested.email}"/>${emailErr}<br>
			</c:when>
			<c:otherwise>
				username = ${userRequested.username}<br>
				email = ${userRequested.email}<br>
			</c:otherwise>
		</c:choose>
		admin = ${userRequested.isAdmin}<br>
		<c:if test="${man!=null}">
				<input type="submit" value="conferma"/>
			</form>
		</c:if>			
</body>
</html>