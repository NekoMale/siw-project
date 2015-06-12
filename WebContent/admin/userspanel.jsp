<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>Lyrics Admin - Pannello Utenti</title>
        <link href='http://fonts.googleapis.com/css?family=PT+Sans' rel='stylesheet' type='text/css'>
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet" >
        <link href="${pageContext.request.contextPath}/css/interface.css" rel="stylesheet" >
        <link href="${pageContext.request.contextPath}/admin/css/trackspanel.css" rel="stylesheet" >
	</head>
	<body>
		<!-- navbar top - header -->
	    <header class="navbar navbar-default">
			<div class="container">
		    	<div class="navbar-header">
		         	<a href="<c:url value="/admin/index.jsp"/>" class="navbar-brand logo">Lyrics Site</a>
		            <button class="navbar-toggle" data-toggle="collapse" data-target=".navHeaderCollapse">
		            	<span class="icon-bar"></span>
		                <span class="icon-bar"></span>
		                <span class="icon-bar"></span>
		            </button>
				</div>
		        <div class="collapse navbar-collapse navHeaderCollapse">
		        	<ul class="nav navbar-nav navbar-right">
		            	<li><a href="<c:url value="/controller/AdminTrackList" />">Gestione Canzoni</a></li>
		                <li><a href="<c:url value="/controller/AdminUserList" />">Gestione Utenti</a></li>
		                <li><p></p></li>
		                <li><a href="<c:url value="#"/>">Profilo ${user.username}</a></li>
			            <li><a href="<c:url value="/controller/HomeLoad"/>">Torna al Sito</a></li>
		            </ul>
		        </div>
		    </div>
	    </header>
	    
	    <div class="container title-row">
	    	<div class="row">
		    	<div class="col-md-1"></div>
		    	<div class="col-md-4"><h1>Gestione Utenti</h1></div>
		    </div>
	    </div>
	
		<div class="container result-body">
			<div class="row text-center options-row">
				<a href="<c:url value="/admin/searchuser.jsp" />" >Cerca un utente</a> 
			</div>
			<div class="row">
				<div class="col-md-2"></div>
				<div class="col-md-2"><h4>Username</h4></div>
				<div class="col-md-3"><h4>Email</h4></div>
			</div>
			<c:forEach var="users" items="${users}">
				<div class="row result-row">
					<div class="col-md-2"></div>
					<div class="col-md-2"><a href="<c:url value="/controller/AdminGetUser?username=${users.username}" />">${users.username}</a></div>
					<div class="col-md-3">${users.email}</div>
					<div class="col-md-1">
						<form action="<c:url value="/controller/AdminGetUser" />" method="get">
							<input type="hidden" name="man" value="on"/>
							<input type="hidden" name="username" value="${users.username}"/>
							<input type="submit" value="gestisci"/>
						</form>
					</div>
					<div class="col-md-1">
						<form action="<c:url value="/admin/confdeleteuser.jsp" />" method="get">
							<input type="hidden" name="id" value="${users.id}"/>
							<input type="hidden" name="username" value="${users.username}"/>
							<input type="submit" value="elimina"/>
						</form>
					</div>
					<div class="col-md-1">
						<form action="<c:choose><c:when test="${users.isAdmin==false}"><c:url value="/controller/AdminPromoteUser" /></c:when><c:otherwise><c:url value="/controller/AdminDowngradeUser" /></c:otherwise></c:choose>" method="get">
							<input type="hidden" name="id" value="${users.id}"/>
							<input type="submit" value="<c:choose><c:when test="${users.isAdmin==false}">Promuovi</c:when><c:otherwise>Declassa</c:otherwise></c:choose>"/>
						</form>
					</div>
				</div>
			</c:forEach>
			<div class="row text-center">
				${msg}
			</div>
		</div>	
			
		<footer class="footer navbar-default">
	        <div class="container">
	            <div class="row">
	                <ul class="col-md-3">
	                    <li><b>Mappa Sito:</b></li>
	                    <li><a href="#"></a></li>
	                    <li></li>
	                    <li><a href="#"></a></li>
	                </ul>
	                <ul class="col-md-3">
	                    <li><b>Info</b></li>
	                    <li><a href="#">Chi Siamo</a></li>
	                    <li><a href="#">Perché siamo nati</a></li>
	                </ul>
	                <ul class="col-md-6">
	                    <li><b>Lyrics Site</b></li>
	                    <li>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla ac pretium arcu, eget congue nisl. Sed rutrum enim sem, ac hendrerit felis posuere eu.</li>
	                    <li>Sito realizzato da: NekoMale & Vetrix</li>
	                </ul>
	            </div>
	        </div>
	    </footer>
		
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
	</body>
</html>