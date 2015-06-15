<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>Lyrics - Elenco Autori</title>
        <link href='http://fonts.googleapis.com/css?family=PT+Sans' rel='stylesheet' type='text/css'>
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet" >
        <link href="${pageContext.request.contextPath}/css/interface.css" rel="stylesheet" >
        <link href="${pageContext.request.contextPath}/css/authordetails.css" rel="stylesheet" >
	</head>
	<body>
	    <header class="navbar navbar-default">
	        <div class="container">
	        	<div class="navbar-header">
	            	<a href="<c:url value="/controller/HomeLoad"/>" class="navbar-brand logo">Lyrics Site</a>
	                <button class="navbar-toggle" data-toggle="collapse" data-target=".navHeaderCollapse">
	                	<span class="icon-bar"></span>
	                    <span class="icon-bar"></span>
	                    <span class="icon-bar"></span>
	                </button>
	            </div>
	            <div class="collapse navbar-collapse navHeaderCollapse">
	                <ul class="nav navbar-nav navbar-right">
	            	    <li><a href="<c:url value="/controller/GetAllTracks" />">Canzoni</a></li>
	                    <li><a href="<c:url value="/controller/GetAllAuthors" />">Artisti</a></li>
	                    <li><a href="<c:url value="/controller/GetAllGenres" />">Generi</a></li>
	                    <li><a href="<c:url value="/search.jsp"/>">Ricerca</a></li>
	                    <li><p></p></li>
	                    <li>
		                <c:choose>
		                	<c:when test="${user.username!=null}">
		                  		<a href="<c:url value="/controller/GetUser"/>">Profilo ${user.username}</a>
		                   	</c:when>
		                   	<c:otherwise>
		                   		<a href="<c:url value="/login.jsp"/>">Accedi</a>
		                   	</c:otherwise>
		            	</c:choose>
		                </li>
		                <c:if test="${user.isAdmin==true}">
		                  	<li><a href="<c:url value="/admin"/>">Gestione Sito</a></li>
		                </c:if>
	                    <c:if test="${user.username==null}">
	                      	<li><a href="<c:url value="/register.jsp"/>" >Registrati</a></li>
	                    </c:if>
	                </ul>
	            </div>
	    	</div>
	    </header>
	    
	    <div class="container">
			<div class="row">
				<div class="col-md-12 author-name">
					<h1>${authorRequested.name}</h1>
				</div>
			</div>
			<div class="row">
				<div class="col-md-5">
					<p><b>Data debutto:</b> <c:choose><c:when test="${authorRequested.debut==0}">//</c:when><c:otherwise>${authorRequested.debut}</c:otherwise></c:choose>
					<p><b>Informazioni:</b> ${authorRequested.info}
				</div>
			</div>
		</div>
		
	    <div class="container author-details-container personal-adaptor">
			<div class="row">
				<div class="col-md-5">
					<div class="row title-row">
						<div class="col-md-12 text-center"><h3>Album</h3></div>
					</div>
					<div class="row">
						<div class="col-md-3"><b>Anno</b></div>
						<div class="col-md-9"><b>Titolo</b></div>
					</div>
					<c:forEach var="albums" items="${authorRequested.album}">
						<div class="row result-row">
							<div class="col-md-3"><c:choose><c:when test="${albums.year==0}">//</c:when><c:otherwise>${albums.year}</c:otherwise></c:choose></div>
							<div class="col-md-9">${albums.title}</div>
						</div>
					</c:forEach>
				</div>
				<div class="col-md-2"></div>
				<div class="col-md-5">
					<div class="row title-row">
						<div class="col-md-12 text-center"><h3>Canzoni</h3></div>
					</div>
					<c:forEach var="tracks" items="${authorRequested.tracks}">
						<div class="row result-row">
							<div class="col-md-12"><a href="<c:url value="/controller/GetTrack?id=${tracks.id}" />">${tracks.name}</a></div>
						</div>
					</c:forEach>
				</div>
			</div>
		</div>
	
		<footer class="footer navbar-default">
	        <div class="container">
	            <div class="row">
	                <ul class="col-md-4">
	                </ul>
	                <ul class="col-md-3">
	                </ul>
	                <ul class="col-md-5">
	                    <li><b>Lyrics Site</b></li>
	                    <li>Lyrics Site è un sito che, sin dal 2015, raccoglie tutte le canzoni, album e autori esistenti. Anche i meno conosciuti.</li>
	                    <li>Sito realizzato da: NekoMale & Vetrix</li>
	                </ul>
	            </div>
	        </div>
	    </footer>
		
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
	</body>
</html>