<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>Lyrics Site - Ricerca Rapida</title>
        <link href='http://fonts.googleapis.com/css?family=PT+Sans' rel='stylesheet' type='text/css'>
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet" >
        <link href="${pageContext.request.contextPath}/css/interface.css" rel="stylesheet" >
        <link href="${pageContext.request.contextPath}/css/search.css" rel="stylesheet" >
	</head>
	<body>
		<!-- navbar top - header -->
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
	    
	    <div class="container search-form">
	    	<div class="row">
		    	<div class="col-md-2"></div>
		    	<div class="col-md-10">
		    		<h1>Ricerca Rapida</h1>
		    		<h5>Inserisci ciò che ricordi del testo, artista, album o titolo della canzone che cerchi</h5>
		    	</div>	    	
	    	</div>
		    <div class="row mid-row">
	    		<form action="<c:url value="/controller/FastSearch"/>" method="get">
			    	<div class="col-md-3"></div>
			    	<div class="col-md-4">
			    		<input type="text" class="form-control" name="keyword" />
			    		<p>${keywordErr}</p>
			    	</div>
			    	<div class="col-md-1">
			    		<input type="submit" class="btn btn-info" value="cerca" />
			    	</div>
		    	</form>
		    </div>
		    <div class="row">
		    	<div class="col-md-3"></div>
		    	<div class="col-md-9">
		    		<p><a href="<c:url value="/advancedsearch.jsp" />">Ricerca Avanzata</a></p>
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