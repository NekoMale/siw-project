<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>Lyrics Admin - Pannello Tracce</title>
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
	    
	    <div class="container title-row">
	    	<h1>Gestione Canzoni</h1>
	    </div>
	
		<div class="container result-body">
			<div class="row text-center msg-row">
				${msg}
				${errUpdate}
			</div>
			<div class="row text-center options-row">
				<a href="<c:url value="/admin/createtrack.jsp" />" >Inserisci una nuova canzone</a> - <a href="<c:url value="/admin/searchtrack.jsp" />" >Cerca una canzone</a> 
			</div>
			<div class="row">
				<div class="col-md-1"></div>
				<div class="col-md-4"><h4>Titolo</h4></div>
				<div class="col-md-2"><h4>Autore</h4></div>
				<div class="col-md-2"><h4>Album</h4></div>
				<div class="col-md-1"><h4>Genere</h4></div>
			</div>
			<c:forEach var="tracks" items="${tracks}">
				<div class="row result-row">
					<div class="col-md-1"></div>
					<div class="col-md-4"><a href="<c:url value="/controller/GetTrack?id=${tracks.id}&man=on" />" target = "_blank">${tracks.name}</a></div>
					<div class="col-md-2">${tracks.author.name}</div>
					<div class="col-md-2">${tracks.album.title}</div>
					<div class="col-md-1">${tracks.genre.name}</div>
					<div class="col-md-1"><form action="<c:url value="/controller/GetTrack" />" method="get">
						<input type="hidden" name="man" value="on"/>
						<input type="hidden" name="id" value="${tracks.id}"/>
						<input type="submit" value="gestisci"/>
						</form></div>
					<div class="col-md-1"><form action="<c:url value="/admin/confdeletetrack.jsp" />" method="get">
						<input type="hidden" name="id" value="${tracks.id}"/>
						<input type="hidden" name="name" value="${tracks.name}"/>
						<input type="submit" value="elimina"/>
						</form></div>
				</div>
			</c:forEach>
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
	                    <li>Lyrics Site � un sito che, sin dal 2015, raccoglie tutte le canzoni, album e autori esistenti. Anche i meno conosciuti.</li>
	                    <li>Sito realizzato da: NekoMale & Vetrix</li>
	                </ul>
	            </div>
	        </div>
	    </footer>
		
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
	</body>
</html>