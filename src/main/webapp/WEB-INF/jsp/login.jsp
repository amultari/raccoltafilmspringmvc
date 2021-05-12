<!doctype html>
<html lang="it">
	<head>
	  <!-- Required meta tags -->
	  <meta charset="utf-8">
	  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	
	  <!-- Bootstrap CSS -->
	  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/bootstrap.min.css" >
	
	  <title>Accedi</title>
	  
	  <!-- Favicons -->
	<link rel="apple-touch-icon" href="${pageContext.request.contextPath}/assets/img/favicons/apple-touch-icon.png" sizes="180x180">
	<link rel="icon" href="${pageContext.request.contextPath}/assets/img/favicons/favicon-32x32.png" sizes="32x32" type="image/png">
	<link rel="icon" href="${pageContext.request.contextPath}/assets/img/favicons/favicon-16x16.png" sizes="16x16" type="image/png">
	<link rel="manifest" href="${pageContext.request.contextPath}/assets/img/favicons/manifest.json">
	<link rel="mask-icon" href="${pageContext.request.contextPath}/assets/img/favicons/safari-pinned-tab.svg" color="#563d7c">
	<link rel="icon" href="${pageContext.request.contextPath}/assets/img/favicons/favicon.ico">
	<meta name="msapplication-config" content="${pageContext.request.contextPath}/assets/img/favicons/browserconfig.xml">
	<meta name="theme-color" content="#563d7c">
	
	
	   <style>
	    .bd-placeholder-img {
	      font-size: 1.125rem;
	      text-anchor: middle;
	      -webkit-user-select: none;
	      -moz-user-select: none;
	      -ms-user-select: none;
	      user-select: none;
	    }
	
	    @media (min-width: 768px) {
	      .bd-placeholder-img-lg {
	        font-size: 3.5rem;
	      }
	    }
	  </style>
	  
	  <!-- Custom styles for this template -->
	  <link href="${pageContext.request.contextPath}/assets/css/signin.css" rel="stylesheet">
	</head>
	<body class="text-center">
		
		<form class="form-signin" name='login' action="login" method='POST' novalidate="novalidate">
	   	
		   	<div class="alert alert-danger alert-dismissible fade show ${errorMessage==null?'d-none': ''}" role="alert">
			  ${errorMessage}
			</div>
			
			
		  <img class="mb-4" src="${pageContext.request.contextPath}/assets/brand/bootstrap-solid.svg" alt="" width="72" height="72">
		  <h1 class="h3 mb-3 font-weight-normal">Please sign in</h1>
		  <label for="inputUsername" class="sr-only">Username</label>
		  <input type="text" id="inputUsername" name="username" class="form-control" placeholder="Username" required autofocus>
		  <label for="inputPassword" class="sr-only">Password</label>
		  <input type="password" id="inputPassword" name="password" class="form-control" placeholder="Password" required>
		  <div class="checkbox mb-3">
		    <label>
		      <input type="checkbox" value="remember-me"> Remember me
		    </label>
		  </div>
		  <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
		  <p class="mt-5 mb-3 text-muted">&copy; 2017-2020</p>
		</form>
	</body>
</html>