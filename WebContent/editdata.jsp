<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>Lyrics - Home</title>
        <link href='http://fonts.googleapis.com/css?family=PT+Sans' rel='stylesheet' type='text/css'>
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet" >
        <link href="${pageContext.request.contextPath}/css/interface.css" rel="stylesheet" >
        <link href="${pageContext.request.contextPath}/css/editdata.css" rel="stylesheet" >
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
              
        <div class="container edit-data-container">
        	<div class="row title-row">
        		<div class="col-md-12">
        			<h1>Modifica i tuoi dati</h1>
        		</div>
        	</div>
        	<form action="<c:url value="/controller/EditUserData"/>" method="post">
        	<input type="hidden" name="id" value="${user.id}" />
        	<div class="row">
        		<div class="col-md-4"></div>
        		<div class="col-md-4">
        			<label for="username">Username: </label><input type="text" class="form-control" name="username" id="username" value="${user.username}"/><span>${userErr}</span><br>
        			<label for="email">Email: </label><input type="email" class="form-control" name="email" id="email" value="${user.email}"/><span>${emailErr}</span>
        		</div>
        	</div>
        	<div class="row text-center error-row">
        		<div class="col-md-4"></div>
        		<div class="col-md-4">${updateErr}</div>
        	</div>
        	<div class="row btn-row">
        		<div class="col-md-4"></div>
        		<div class="col-md-4 text-center">
        			<input type="submit" class="btn btn-primary" value="modifica"/>
        		</div>
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