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
<p><b>Vuoi davvero eliminare ${param.username}?</b></p>
<form action="<c:url value="/controller/AdminDeleteUser" />" method="get">
	<input type="hidden" name="id" value="${param.id}"/>
	<input type="submit" value="elimina"/>
</form>
</body>
</html>