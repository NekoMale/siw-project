<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>Lyrics Admin - Inserisci una nuova canzone</title>
        <link href='http://fonts.googleapis.com/css?family=PT+Sans' rel='stylesheet' type='text/css'>
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet" >
        <link href="${pageContext.request.contextPath}/css/interface.css" rel="stylesheet" >
        <link href="${pageContext.request.contextPath}/admin/css/edittrack.css" rel="stylesheet" >
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
		                <li><a href="<c:url value="/controller/AdminUserList" />">Gestione Utenti</a></li>
		                <li><p></p></li>
		                <li><a href="<c:url value="/controller/GetUser?username=${user.username}"/>">Profilo ${user.username}</a></li>
			            <li><a href="<c:url value="/controller/HomeLoad"/>">Torna al Sito</a></li>
		            </ul>
		        </div>
		    </div>
	    </header>
		
		<div class="container">
			<div class="row text-center title-row">
				<h1>Inserisci una nuova canzone</h1>
			</div>
		</div>
		<div class="container edit-body">
			<form action="<c:url value="/controller/AdminCreateTrack" />" method="post">
				<div class="row">
					<div class="col-md-2"></div>
					<div class="col-md-1"><label for="name">Titolo:</label></div>
					<div class="col-md-7"><input type="text" class="form-control" name="name" id="name" value="${track.name}"/></div>
				</div>
				<div class="row">
					<div class="col-md-2"></div>
					<div class="col-md-1"><label for="author">Autore:</label></div>
					<div class="col-md-7"><input type="text" class="form-control" name="author" id="author" value="${track.author.name}"/></div>
				</div>
				<div class="row">
					<div class="col-md-2"></div>
					<div class="col-md-1"><label for="album">Album:</label></div>
					<div class="col-md-7"><input type="text" class="form-control" name="album" id="album" value="${track.album.title}"/></div>
				</div>
				<div class="row">
					<div class="col-md-2"></div>
					<div class="col-md-1"><label for="genre">Genere:</label></div>
					<div class="col-md-7"><input type="text" class="form-control" name="genre" id="genre" value="${track.genre.name}"/></div>
				</div>
				<div class="row">
					<div class="col-md-2"></div>
					<div class="col-md-1"><label for="lyric">Titolo:</label></div>
					<div class="col-md-7"><textarea class="form-control" name="lyric" id="lyric" rows="15">${track.lyric}</textarea></div>
				</div>
				<div class="row">
					<div class="col-md-2"></div>
					<div class="col-md-8 text-center"><input type="submit" value="Conferma"/></div>
				</div>
			</form>			
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