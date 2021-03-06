<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>Lyrics - Testo ${trackRequested.author.name} - ${trackRequested.name}</title>
        <link href='http://fonts.googleapis.com/css?family=PT+Sans' rel='stylesheet' type='text/css'>
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet" >
        <link href="${pageContext.request.contextPath}/css/interface.css" rel="stylesheet" >
        <link href="${pageContext.request.contextPath}/css/trackdetails.css" rel="stylesheet" >
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
	    
	    <div class="container personal-adaptor song-body">
	    	<div class="row">
	    		<div class="col-md-12 text-center">
					<h1>${trackRequested.author.name} - ${trackRequested.name}</h1>
					<h4>Album: ${trackRequested.album.title} - Genere: ${trackRequested.genre.name}</h4>
	    		</div>
	    	</div>
	    	<div class="row lyric-row">
	    		<div class="col-md-2"></div>
	    		<div class="col-md-8">
	    			${trackRequested.lyric}
	    		</div>
	    	</div>
	    	<div class="row like-row">
	    		<div class="col-md-2"></div>
	    		<div class="col-md-7">
	    			<p><c:choose><c:when test="${trackRequested.favs==1}">Piace a 1 persona</c:when>
	    			<c:otherwise>Piace a ${trackRequested.favs} persone</c:otherwise></c:choose></p>	
	    			<c:if test="${user.username!=null}"><form <c:choose><c:when test="${fav==0}">action="<c:url value="/controller/Like"/>"</c:when>
	    				<c:otherwise>action="<c:url value="/controller/Dislike"/>"</c:otherwise></c:choose> method="post">
	    				<input type="hidden" name="idTrack" value="${trackRequested.id}">
	    				<input type="submit" class="btn btn-primary" value="<c:choose><c:when test="${fav==0}">mi piace</c:when><c:otherwise>non mi piace pi�</c:otherwise></c:choose>">
	    			</form></c:if>
	    			<span>${err}</span>
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