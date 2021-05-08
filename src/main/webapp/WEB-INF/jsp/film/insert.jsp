<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!doctype html>
<html lang="it">
<head>
	<jsp:include page="../header.jsp" />
	<title>Inserisci nuovo</title>
	
	<!-- style per le pagine diverse dalla index -->
    <link href="${pageContext.request.contextPath }/assets/css/global.css" rel="stylesheet">
    
    <link rel="stylesheet" href="${pageContext.request.contextPath }/assets/css/jqueryUI/jquery-ui.min.css" />
	<style>
		.ui-autocomplete-loading {
			background: white url("../assets/img/jqueryUI/anim_16x16.gif") right center no-repeat;
		}
		.error_field {
	        color: red; 
	    }
	</style>
    
</head>
<body>
	<jsp:include page="../navbar.jsp" />
	
	<main role="main" class="container">
	
		<%-- se l'attributo in request ha errori --%>
		<spring:hasBindErrors  name="film_regista_attr">
			<%-- alert errori --%>
			<div class="alert alert-danger " role="alert">
				Attenzione!! Sono presenti errori di validazione
			</div>
		</spring:hasBindErrors>
	
		<div class="alert alert-danger alert-dismissible fade show ${errorMessage==null?'d-none': ''}" role="alert">
		  ${errorMessage}
		  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
		    <span aria-hidden="true">&times;</span>
		  </button>
		</div>
		
		<div class='card'>
		    <div class='card-header'>
		        <h5>Inserisci nuovo elemento</h5> 
		    </div>
		    <div class='card-body'>

					<form:form method="post" modelAttribute="insert_film_attr" action="save" novalidate="novalidate" >
					
						<div class="form-row">
							<div class="form-group col-md-6">
								<label for="titolo">Titolo</label>
								<spring:bind path="titolo">
									<input type="text" name="titolo" id="titolo" class="form-control ${status.error ? 'is-invalid' : ''}" placeholder="Inserire il titolo" value="${insert_film_attr.titolo }">
								</spring:bind>
								<form:errors  path="titolo" cssClass="error_field" />
							</div>
							
							<div class="form-group col-md-6">
								<label for="genere">Genere</label>
								<spring:bind path="genere">
									<input type="text" name="genere" id="genere" class="form-control ${status.error ? 'is-invalid' : ''}" placeholder="Inserire il genere" value="${insert_film_attr.genere }">
								</spring:bind>
								<form:errors  path="genere" cssClass="error_field" />
							</div>
						</div>
						
						<div class="form-row">	
							<fmt:formatDate pattern='yyyy-MM-dd' var="parsedDate" type='date' value='${insert_film_attr.dataPubblicazione}' />
							<div class="form-group col-md-6">
								<label for="dataPubblicazione">Data di Pubblicazione</label>
                        		<spring:bind path="dataPubblicazione">
	                        		<input class="form-control ${status.error ? 'is-invalid' : ''}" id="dataPubblicazione" type="date" placeholder="dd/MM/yy"
	                            		title="formato : gg/mm/aaaa"  name="dataPubblicazione" value="${parsedDate}" >
	                            </spring:bind>
                            	<form:errors  path="dataPubblicazione" cssClass="error_field" />
							</div>
							
							<div class="form-group col-md-6">
								<label for="minutiDurata">Durata (minuti)</label>
								<spring:bind path="minutiDurata">
									<input type="number" class="form-control ${status.error ? 'is-invalid' : ''}" name="minutiDurata" id="minutiDurata" placeholder="Inserire la durata" value="${insert_film_attr.minutiDurata }">
								</spring:bind>
								<form:errors  path="minutiDurata" cssClass="error_field" />
							</div>
						</div>
						
						<div class="form-row">
							<div class="form-group col-md-6">
								<label for="registaSearchInput">Regista:</label>
								<spring:bind path="regista">
									<input class="form-control ${status.error ? 'is-invalid' : ''}" type="text" id="registaSearchInput"
										name="registaInput" value="${insert_film_attr.regista.nome}${empty insert_film_attr.regista.nome?'':' '}${insert_film_attr.regista.cognome}">
								</spring:bind>
								<input type="hidden" name="regista.id" id="registaId" value="${insert_film_attr.regista.id}">
								<form:errors  path="regista" cssClass="error_field" />
							</div>
						</div>
						
<!-- 						<div class="form-row">	 -->
<!-- 							<div class="form-group col-md-6"> -->
<!-- 								<label for="regista.id">Regista</label> -->
<!-- 							    <select class="form-control" id="regista.id" name="regista.id"> -->
<!-- 							    	<option value="" selected> -- Selezionare una voce -- </option> -->
<%-- 							      	<c:forEach items="${registi_list_attribute }" var="registaItem"> --%>
<%-- 							      		<option value="${registaItem.id}" ${insert_film_attr.regista.id == registaItem.id?'selected':''} >${registaItem.nome } ${registaItem.cognome }</option> --%>
<%-- 							      	</c:forEach> --%>
<!-- 							    </select> -->
<!-- 							</div> -->
<!-- 						</div> -->
							
						<button type="submit" name="submit" value="submit" id="submit" class="btn btn-primary">Conferma</button>
						
					</form:form>
					
					<%-- FUNZIONE JQUERY UI PER AUTOCOMPLETE --%>
					<script>
						$("#registaSearchInput").autocomplete({
							 source: function(request, response) {
							        $.ajax({
							            url: "../regista/searchRegistiAjax",
							            datatype: "json",
							            data: {
							                term: request.term,   
							            },
							            success: function(data) {
							                response($.map(data, function(item) {
							                    return {
								                    label: item.label,
								                    value: item.value
							                    }
							                }))
							            }
							        })
							    },
							//quando seleziono la voce nel campo deve valorizzarsi la descrizione
						    focus: function(event, ui) {
						        $("#registaSearchInput").val(ui.item.label)
						        return false
						    },
						    minLength: 2,
						    //quando seleziono la voce nel campo hidden deve valorizzarsi l'id
						    select: function( event, ui ) {
						    	$('#registaId').val(ui.item.value);
						    	//console.log($('#registaId').val())
						        return false;
						    }
						});
					</script>
					<!-- end script autocomplete -->	
					
		    
			<!-- end card-body -->			   
		    </div>
		</div>	
	
	<!-- end container -->	
	</main>
	<jsp:include page="../footer.jsp" />
	
</body>
</html>