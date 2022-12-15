<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <div class="container-fluid">
    <a class="navbar-brand fw-lighter" href="${pageContext.request.contextPath }/">ComE</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
    
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
      
	        <li class="nav-item">
	          <a class="nav-link active" aria-current="page" href="${pageContext.request.contextPath }/">Home</a>
	        </li>
	        
	        <li class="nav-item">
	          <a class="nav-link" href="${pageContext.request.contextPath }/">Cart</a>
	        </li>
	        
	        <li class="nav-item me-auto">
	          <a class="nav-link" href="${pageContext.request.contextPath }/login">Login</a>
	        </li>
	        
	        <li class="nav-item me-2">
	          <a class="nav-link" href="${pageContext.request.contextPath }/register">Sign up</a>
	        </li>
        
      </ul>  
    </div>
  </div>
</nav>
</body>
</html>