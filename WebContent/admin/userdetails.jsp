<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>Lyrics Admin - Home</title>
        <link href='http://fonts.googleapis.com/css?family=PT+Sans' rel='stylesheet' type='text/css'>
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet" >
        <link href="${pageContext.request.contextPath}/css/interface.css" rel="stylesheet" >
        <link href="${pageContext.request.contextPath}/admin/css/userdetails.css" rel="stylesheet" >
	</head>
	<body>
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
		            	<li><a href="<c:url value="/controller/AdminAlbumList" />">Gestione Album</a></li>
		            	<li><a href="<c:url value="/controller/AdminAuthorList" />">Gestione Autori</a></li>
		                <li><a href="<c:url value="/controller/AdminUserList" />">Gestione Utenti</a></li>
		                <li><p></p></li>
		                <li><a href="<c:url value="/controller/GetUser?username=${user.username}"/>">Profilo ${user.username}</a></li>
			            <li><a href="<c:url value="/controller/HomeLoad"/>">Torna al Sito</a></li>
		            </ul>
		        </div>
		    </div>
		</header>
		
		
		<div class="container text-center title-row">
			<h1>Dettagli ${userRequested.username}</h1>
			<h3>${msg}</h3>
		</div>
	    <div class="container personal-adaptor user-body">
	    	<c:if test="${man!=null}"><form action="<c:url value="/controller/AdminEditUser" />" method="post"></c:if>
	    		<c:choose>
					<c:when test="${man!=null}">
	    				<div class="row">
							<div class="col-md-4"><input type="hidden" name="id" value="${userRequested.id}"/></div>
							<div class="col-md-1"><label for="username">Username: </label></div>
							<div class="col-md-3"><input type="text" class="form-control" id="username" name="username" value="${userRequested.username}"/>
													<span>${userErr}</span></div>
						</div>
						<div class="row">
							<div class="col-md-4"></div>
							<div class="col-md-1"><label for="email">Email: </label></div>
							<div class="col-md-3"><input type="email" class="form-control" id="email" name="email" value="${userRequested.email}"/>
													<span>${emailErr}</span></div>
					</c:when>
					<c:otherwise>
						<div class="row">
							<div class="col-md-4"></div>
							<div class="col-md-1"><b>Username:</b></div>
							<div class="col-md-3">${userRequested.username}</div>
						</div>
						<div class="row">
							<div class="col-md-4"></div>
							<div class="col-md-1"><b>Email:</b></div>
							<div class="col-md-3">${userRequested.email}</div>
					</c:otherwise>
				</c:choose>
					</div>
					<div class="row">
						<div class="col-md-4"></div>
						<div class="col-md-1"><b>Admin:</b></div>
						<div class="col-md-3">${userRequested.isAdmin}</div>
					</div>
				<c:if test="${man!=null}">
					<div class="row last-row">
						<div class="col-md-4"></div>
						<div class="col-md-4 text-center"><input type="submit" value="conferma"/></div>
					</div>
					</form>
				</c:if>
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

	
		