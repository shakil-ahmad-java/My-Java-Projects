<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-dark bg-secondary">
	<div class="container-fluid">
		<a class="navbar-brand" href="${pageContext.request.contextPath}/"><img alt="..." src="resources/images/logo.png" style="width:100px;height:80px;"></a>
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse" id="btn1"
			data-bs-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav me-auto mb-2 mb-lg-0">
				<li class="nav-item"><a class="nav-link active"
					aria-current="page" href="${pageContext.request.contextPath}/">Home</a></li>
					
				<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath }/loginpage">Login</a></li>
				
				<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath }/registerpage">Register</a></li>
				
				<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath }/users">Users</a></li>
			</ul>
			<form class="d-flex">
				<input class="form-control me-2" type="search" placeholder="Search"
					aria-label="Search">
				<button class="btn btn-outline-light" type="submit">Search</button>
			</form>
		</div>
	</div>
</nav>
<script type="text/javascript">
	$(document).ready(function(){
		
		$("#btn1").click(function(){
			$("#navbarSupportedContent").toggle()
		})
	});
</script>
</body>
</html>