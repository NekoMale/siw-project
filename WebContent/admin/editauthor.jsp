<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>Lyrics Admin - Modifica ${authorRequested.name}</title>
        <link href='http://fonts.googleapis.com/css?family=PT+Sans' rel='stylesheet' type='text/css'>
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet" >
        <link href="${pageContext.request.contextPath}/css/interface.css" rel="stylesheet" >
        <link href="${pageContext.request.contextPath}/admin/css/editauthor.css" rel="stylesheet" >
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
		
		<div class="container edit-body">
			<div class="row text-center title-row">
				<h1>Modifica: ${authorRequested.name}</h1>
			</div>
			<form action="<c:url value="/controller/AdminEditAuthor" />" method="post">
				<input type="hidden" name="id" value="${authorRequested.id}"/>
				<div class="row">
					<div class="col-md-2"></div>
					<div class="col-md-1"><label for="name">Nome:</label></div>
					<div class="col-md-7"><input type="text" class="form-control" name="name" id="name" value="${authorRequested.name}"/>
					<span>${nameErr}</span></div>
				</div>
				<div class="row">
					<div class="col-md-2"></div>
					<div class="col-md-1"><label for="debut">Debutto:</label></div>
					<div class="col-md-7"><input type="text" class="form-control" name="debut" id="debut" value="${authorRequested.debut}"/></div>
				</div>
				<div class="row">
					<div class="col-md-2"></div>
					<div class="col-md-1"><label for="info">Info</label></div>
					<div class="col-md-7"><textarea class="form-control" name="info" id="info" rows="7">${authorRequested.info}</textarea></div>
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