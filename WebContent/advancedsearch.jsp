<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>Lyrics Site - Ricerca Avanzata</title>
        <link href='http://fonts.googleapis.com/css?family=PT+Sans' rel='stylesheet' type='text/css'>
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet" >
        <link href="${pageContext.request.contextPath}/css/interface.css" rel="stylesheet" >
        <link href="${pageContext.request.contextPath}/css/login.css" rel="stylesheet" >
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
	                    <li><a href="#">Italiane</a></li>
	                    <li><a href="#">Inglesi</a></li>
	                    <li><a href="#">Altre lingue</a></li>
	                    <li><a href="#">Generi</a></li>
	                    <li><a href="<c:url value="/search.jsp"/>">Ricerca</a></li>
	                    <li><p></p></li>
	                    <li>
		        	        <c:choose>
		                    	<c:when test="${user.username!=null}">
		                       		<a href="<c:url value="#"/>">Profilo ${user.username}</a>
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
	    
	    <div class="container">
	    	<div class="row">
	    		<h1>Ricerca Avanzata</h1>
			    <c:choose>
				    <c:when test="${user.username==null}">
					        	<h4>Per utilizzare la ricerca avanzata devi effettuare il login!</h4>
					    	</div>
				    	</div>
				    	<div class="container login-form">
					    	<form action="<c:url value="/controller/Login" />" method="post">
						    	<div class="row">
						    		<div class="col-md-4"></div>
						    		<div class="col-md-4">
										<label for="username">Username:</label>
										<input type="text" class="form-control" name="username" id="username" value="${username}"/>
										<p>${usernameErr}</p>
										<label for="password">Password:</label>
										<input type="password" class="form-control" name="password" id="password" />
										<p>${passwordErr} ${combinationErr}</p>
						    		</div>
						    	</div>
						    	<div class="row text-center">
									<input type="submit" value="accedi"/>
						    	</div>
							</form>
					    </div>
				   	</c:when>
				   	<c:otherwise>
				  				<h5>Riempi almeno uno dei seguenti campi</h5>	    	
					    	</div>
					    	<form action="<c:url value="/controller/AdvancedSearch"/>" method="get">
						    	<div class="row">
							    	<div class="col-md-2"></div>
							    	<div class="col-md-4">
							    		<label for="name">Titolo Canzone:</label>
							    		<input type="text" class="form-control" name="name" id="name" />
							    		<label for="album">Nome Album:</label>
							    		<input type="text" class="form-control" name="album" id="album" />
							    	</div>
							    	<div class="col-md-4">
							    		<label for="author">Autore:</label>
							    		<input type="text" class="form-control" name="author" id="author" />
							    		<label for="lyric">Testo:</label>
							    		<textarea class="form-control" name="lyric" id="lyric"></textarea>
							    	</div>
						    	</div>
						    	<div class="row">
						    		<div class="col-md-5"></div>
						    		<div class="col-md-2">
								    	<input type="submit" class="form-control" value="cerca" />
							    	</div>
						    	</div>
						    </form>
						    <div class="row">
						    	<p>${advancedErr}
						    	<p><a href="<c:url value="/advancedsearch.jsp" />">Ricerca Avanzata</a></p>
						    </div>
					    </div>
				   	</c:otherwise>
				</c:choose>
	    
	    <!-- <div class="container">
	    	<div class="row">
	    		<h1>Ricerca Avanzata</h1>
	    		<h5>Riempi almeno uno dei seguenti campi</h5>	    	
	    	</div>
	    	<form action="<c:url value="/controller/AdvancedSearch"/>" method="get">
		    	<div class="row">
			    	<div class="col-md-2"></div>
			    	<div class="col-md-4">
			    		<label for="name">Titolo Canzone:</label>
			    		<input type="text" class="form-control" name="name" id="name" />
			    		<label for="album">Nome Album:</label>
			    		<input type="text" class="form-control" name="album" id="album" />
			    	</div>
			    	<div class="col-md-4">
			    		<label for="author">Autore:</label>
			    		<input type="text" class="form-control" name="author" id="author" />
			    		<label for="lyric">Testo:</label>
			    		<textarea class="form-control" name="lyric" id="lyric"></textarea>
			    	</div>
		    	</div>
		    	<div class="row">
		    		<div class="col-md-5"></div>
		    		<div class="col-md-2">
				    	<input type="submit" class="form-control" value="cerca" />
			    	</div>
		    	</div>
		    </form>
		    <div class="row">
		    	<p>${advancedErr}
		    	<p><a href="<c:url value="/advancedsearch.jsp" />">Ricerca Avanzata</a></p>
		    </div>
	    </div> -->
			
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
	                    <li><a href="#">Perch� siamo nati</a></li>
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