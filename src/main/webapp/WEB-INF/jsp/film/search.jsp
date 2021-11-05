<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="it" class="h-100">
	<head>
		<jsp:include page="../header.jsp" />
		<title>Ricerca</title>
	</head>
	<body class="d-flex flex-column h-100">
		<jsp:include page="../navbar.jsp" />
		
		<!-- Begin page content -->
		<main class="flex-shrink-0">
		  <div class="container">
		
				<div class="alert alert-danger alert-dismissible fade show ${errorMessage==null?'d-none':'' }" role="alert">
				  ${errorMessage}
				  <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close" ></button>
				</div>
				
				<div class="alert alert-warning alert-dismissible fade show " role="alert">
				  Attenzione!!! Funzionalità ancora non implementata. Sulla 'Conferma' per il momento parte il 'listAll'
				  <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close" ></button>
				</div>
				
				<div class='card'>
				    <div class='card-header'>
				        <h5>Ricerca elementi</h5> 
				    </div>
				    <div class='card-body'>
		
							<form method="post" action="list" class="row g-3">
							
								<div class="col-md-6">
									<label for="titolo" class="form-label">Titolo</label>
									<input type="text" name="titolo" id="titolo" class="form-control" placeholder="Inserire il titolo" >
								</div>
									
								<div class="col-md-6">
									<label for="genere" class="form-label">Genere</label>
									<input type="text" name="genere" id="genere" class="form-control" placeholder="Inserire il genere" >
								</div>
								
								<div class="col-md-6">
									<label for="dataPubblicazione" class="form-label">Data di Pubblicazione</label>
	                        		<input class="form-control" id="dataPubblicazione" type="date" placeholder="dd/MM/yy"
	                            		title="formato : gg/mm/aaaa"  name="dataPubblicazione" >
								</div>
								
								<div class="col-md-6">
									<label for="minutiDurata" class="form-label">Durata (minuti)</label>
									<input type="number" class="form-control" name="minutiDurata" id="minutiDurata" placeholder="Inserire la durata" >
								</div>
								
								<div class="col-md-6">
									<label for="regista.id" class="form-label">Regista</label>
								    <select class="form-select" id="regista.id" name="regista.id">
								    	<option value=""> -- Selezionare una voce -- </option>
								      	<c:forEach items="${registi_list_attribute }" var="registaItem">
								      		<option value="${registaItem.id}">${registaItem.nome } ${registaItem.cognome }</option>
								      	</c:forEach>
								    </select>
								</div>
									
								<div class="col-12">
									<button type="submit" name="submit" value="submit" id="submit" class="btn btn-primary">Conferma</button>
									<input class="btn btn-outline-warning" type="reset" value="Ripulisci">
									<a class="btn btn-outline-primary ml-2" href="${pageContext.request.contextPath }/film/insert">Add New</a>
								</div>
								
							</form>
		
				    
				    
					<!-- end card-body -->			   
				    </div>
				<!-- end card -->
				</div>	
				
			<!-- end container -->
			</div>
		<!-- end main -->	
		</main>
		<jsp:include page="../footer.jsp" />
		
	</body>
</html>