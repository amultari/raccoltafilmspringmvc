<!doctype html>
<html lang="it">
  <head>
    
    <jsp:include page="./header.jsp" />
    
    <!-- Custom styles for this template -->
    <link href="${pageContext.request.contextPath}/assets/css/global.css" rel="stylesheet" type="text/css">
    <style type="text/css">
    	body {
		  padding-top: 3.5rem;
		}	
    </style>
    
    <title>Gestione della Raccolta Film</title>
  </head>
  <body>
  
	<jsp:include page="./navbar.jsp" />
  
  
	<main role="main">

	  <!-- Main jumbotron for a primary marketing message or call to action -->
	  <div class="jumbotron" >
	    <div class="container">
	      <h1 class="display-3">Benvenuto alla Gestione della Raccolta Film</h1>
	      <p>This is a template for a simple marketing or informational website. It includes a large callout called a jumbotron and three supporting pieces of content. Use it as a starting point to create something more unique.</p>
	    </div>
	  </div>
	  
	  <div class="container">
	  
	  	<div class="alert alert-danger alert-dismissible fade show ${errorMessage==null?'d-none': ''}" role="alert">
		  ${errorMessage}
		  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
		    <span aria-hidden="true">&times;</span>
		  </button>
		</div>
	  
	  
	    <!-- Example row of columns -->
	    <div class="row">
	      <div class="col-md-6">
	        <h2>Gestione Registi</h2>
	        <p>Questa funzionalità è realtiva alla Gestione dei Registi</p>
	        <p><a class="btn btn-primary" href="regista/search" role="button">Vai alla Funzionalità &raquo;</a></p>
	      </div>
	      <div class="col-md-6">
	        <h2>Gestione Film</h2>
	        <p>Questa funzionalità è realtiva alla Gestione di Film</p>
	        <p><a class="btn btn-primary" href="film/search" role="button">Vai alla Funzionalità &raquo;</a></p>
	      </div>
	    </div>
	    
	    <hr>
	
	  </div> <!-- /container -->
	
	</main>
	
	<jsp:include page="./footer.jsp" />
  </body>
</html>