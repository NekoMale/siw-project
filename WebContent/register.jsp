<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>Lyrics - Registrati</title>
        <link href='http://fonts.googleapis.com/css?family=PT+Sans' rel='stylesheet' type='text/css'>
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet" >
        <link href="${pageContext.request.contextPath}/css/interface.css" rel="stylesheet" >
        <link href="${pageContext.request.contextPath}/css/register.css" rel="stylesheet" >
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
	                        <c:if test="${user.username==null}">
	                        	<li><a href="<c:url value="/register.jsp"/>" >Registrati</a></li>
	                        </c:if>
	                    </ul>
	                </div>                
	            </div>
	    </header>
	    
		<div class="container text-center page-title">
			<h1>Registrati</h1>
	    </div>
		
		<div class="container register-form">
			<form action="<c:url value="/controller/Register" />" method="post">
		    	<div class="row">
		    		<div class="col-md-2"></div>
		    		<div class="col-md-4">
						<label for="username">Username:</label>
						<input type="text" class="form-control" name="username" id="username" value="${username}"/>
						<p>${usernameErr}</p>
						<label for="email">Email:</label>
						<input type="email" class="form-control" name="email" id="email" value="${email}"/>
						<p>${emailErr}</p>
						<label for="confemail">Conferma Email:</label>
						<input type="email" class="form-control" name="confemail" id="confemail" value="${confemail}"/>
						<p>${confEmailErr}</p>
		    		</div>
		    		<div class="col-md-4">
						<label for="password">Password:</label>
						<input type="password" class="form-control" name="password" id="password" pattern=".{6,}" required title="Scrivi almeno 6 caratteri"/>
						<p>${passwordErr}</p>
						<label for="confpassword">Conferma Password:</label>
						<input type="password" class="form-control" name="confpassword" id="confpassword" pattern=".{6,}" required title="Scrivi almeno 6 caratteri"/>
						<p>${confPasswordErr}</p>
		    		</div>
		    	</div>
		    	<div class="row text-center">
					<input type="submit" value="registrati"/>
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