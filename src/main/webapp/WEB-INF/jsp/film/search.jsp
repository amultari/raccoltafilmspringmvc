<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="it">
<head>
	<jsp:include page="../header.jsp" />
	<title>Ricerca</title>
	
	<!-- style per le pagine diverse dalla index -->
    <link href="${pageContext.request.contextPath }/assets/css/global.css" rel="stylesheet">
    
</head>
<body>
	<jsp:include page="../navbar.jsp" />
	
	<main role="main" class="container">
	
		<div class="alert alert-warning alert-dismissible fade show " role="alert">
		  Attenzione!!! Funzionalità ancora non implementata. Sulla 'Conferma' per il momento parte il 'listAll'
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
		
		<div class='card'>
		    <div class='card-header'>
		        <h5>Ricerca elementi</h5> 
		    </div>
		    <div class='card-body'>

					<form method="post" action="list" >
					
						<div class="form-row">
							<div class="form-group col-md-6">
								<label>Titolo</label>
								<input type="text" name="titolo" id="titolo" class="form-control" placeholder="Inserire il titolo" >
							</div>
							
							<div class="form-group col-md-6">
								<label>Genere</label>
								<input type="text" name="genere" id="genere" class="form-control" placeholder="Inserire il genere" >
							</div>
						</div>
						
						<div class="form-row">	
							<div class="form-group col-md-6">
								<label>Data di Pubblicazione</label>
                        		<input class="form-control" id="dataPubblicazione" type="date" placeholder="dd/MM/yy"
                            		title="formato : gg/mm/aaaa"  name="dataPubblicazione" >
							</div>
							<div class="form-group col-md-6">
								<label>Durata (minuti)</label>
								<input type="number" class="form-control" name="minutiDurata" id="minutiDurata" placeholder="Inserire la durata" >
							</div>
						</div>
						<div class="form-row">	
							<div class="form-group col-md-6">
								<label for="regista.id">Regista</label>
							    <select class="form-control" id="regista.id" name="regista.id">
							    	<option value=""> -- Selezionare una voce -- </option>
							      	<c:forEach items="${registi_list_attribute }" var="registaItem">
							      		<option value="${registaItem.id}">${registaItem.nome } ${registaItem.cognome }</option>
							      	</c:forEach>
							    </select>
							</div>
						</div>
							
						<button type="submit" name="submit" value="submit" id="submit" class="btn btn-primary">Conferma</button>
						<input class="btn btn-outline-warning" type="reset" value="Ripulisci">

						<a class="btn btn-outline-primary ml-2" href="${pageContext.request.contextPath }/film/insert">Add New</a>
						
					</form>

		    
		    
			<!-- end card-body -->			   
		    </div>
		</div>	
	
	
	<!-- end container -->	
	</main>
	<jsp:include page="../footer.jsp" />
	
</body>
</html>