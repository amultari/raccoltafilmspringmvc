<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!doctype html>
<html lang="it">
<head>
	<jsp:include page="../header.jsp" />
	<title>Pagina dei risultati</title>
	
	<!-- style per le pagine diverse dalla index -->
    <link href="${pageContext.request.contextPath }/assets/css/global.css" rel="stylesheet">
    
</head>
<body>
	<jsp:include page="../navbar.jsp" />
	
	<main role="main" class="container">
	
		<div class="alert alert-success alert-dismissible fade show ${successMessage==null?'d-none': ''}" role="alert">
		  ${successMessage}
		  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
		    <span aria-hidden="true">&times;</span>
		  </button>
		</div>
		<div class="alert alert-danger alert-dismissible fade show ${errorMessage==null?'d-none': ''}" role="alert">
		  ${errorMessage}
		  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
		    <span aria-hidden="true">&times;</span>
		  </button>
		</div>
		<div class="alert alert-info alert-dismissible fade show d-none" role="alert">
		  Aggiungere d-none nelle class per non far apparire
		  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
		    <span aria-hidden="true">&times;</span>
		  </button>
		</div>
		
		<div class='card'>
		    <div class='card-header'>
		        <h5>Lista dei risultati</h5> 
		    </div>
		    <div class='card-body'>
		    	<a class="btn btn-primary " href="insert">Add New</a>
		    	<a href="search" class='btn btn-outline-secondary' >
			            <i class='fa fa-chevron-left'></i> Torna alla Ricerca
			        </a>
		    
		        <div class='table-responsive'>
		            <table class='table table-striped ' >
		                <thead>
		                    <tr>
		                        <th>Titolo</th>
		                        <th>Genere</th>
		                        <th>Data Pubblicazione</th>
		                        <th>Durata (min.)</th>
		                        <th>Azioni</th>
		                    </tr>
		                </thead>
		                <tbody>
		                	<c:forEach items="${film_list_attribute }" var="filmItem">
								<tr>
									<td>${filmItem.titolo }</td>
									<td>${filmItem.genere }</td>
									<td><fmt:formatDate type = "date" value = "${filmItem.dataPubblicazione }" /></td>
									<td>${filmItem.minutiDurata }</td>
									<td>
										<a class="btn  btn-sm btn-outline-secondary" href="${pageContext.request.contextPath }/film/show/${filmItem.id }">Visualizza</a>
										<a class="btn  btn-sm btn-outline-primary ml-2 mr-2" href="laservletpermodificare">Edit</a>
										<a class="btn btn-outline-danger btn-sm" href="laservletperrimuovere">Delete</a>
									</td>
								</tr>
							</c:forEach>
		                </tbody>
		            </table>
		        </div>
		   
			<!-- end card-body -->			   
		    </div>
		</div>	
	
	
	<!-- end container -->	
	</main>
	<jsp:include page="../footer.jsp" />
	
</body>
</html>