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
${msg}
<table>
	<tr>
		<th>Username</th>
		<th>Email</th>
	</tr>
	<c:forEach var="users" items="${users}">
		<tr>
			<td><a href="<c:url value="/controller/AdminGetUser?un=${users.username}" />">${users.username}</a></td>
			<td>${users.email}</td>
			<td><form action="<c:url value="/controller/AdminGetUser" />" method="get">
				<input type="hidden" name="man" value="on"/>
				<input type="hidden" name="username" value="${users.username}"/>
				<input type="submit" value="gestisci"/>
				</form></td>
			<td><form action="<c:url value="/admin/confdelete.jsp" />" method="get">
				<input type="hidden" name="id" value="${users.id}"/>
				<input type="hidden" name="username" value="${users.username}"/>
				<input type="submit" value="elimina"/>
				</form></td>
			<td><form action="<c:url value="/controller/AdminPromoteUser" />" method="get">
				<input type="hidden" name="id" value="${users.id}"/>
				<input type="submit" value="promuovi"/>
				</form></td>
		</tr>
	</c:forEach>
</table>
</body>
</html>