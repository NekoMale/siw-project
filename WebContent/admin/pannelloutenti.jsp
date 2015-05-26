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
<table>
	<tr>
		<th>Username</th>
		<th>Email</th>
	</tr>
	<c:forEach var="users" items="${users}">
		<tr>
			<td><a href="<c:url value="/controller/AdminGetUser?un=${users.username}" />">${users.username}</a></td>
			<td>${users.email}</td>
			<td><input type="button" value="gestisci"/></td>
			<td><form action="<c:url value="/controller/DeleteUser?un=${users.username}" />" method="get">
				<input type="submit" value="elimina"/>
				</form></td>
			<td><input type="button" value="promuovi"/></td>
		</tr>
	</c:forEach>
</table>
</body>
</html>