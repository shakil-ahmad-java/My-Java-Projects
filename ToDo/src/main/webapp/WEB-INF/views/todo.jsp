<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>To Do</title>
<jsp:include page="allcssjs.jsp"/>
</head>
<body>
<jsp:include page="header.jsp"/>
<div class="container">
	<div class="row mt-3">
		<div class="col-md-6 offset-3">
			 <div class="card shadow rounded-3">
			 <c:forEach var="v" items="${list }">
			 	<div class="card-header text-center" style="background-color:#ff9900;">
			 		<h2>${v.title }</h2>
			 	</div>
			 	
			 	<div class="card-body" style="background-color:#99e6ff;">
			 		<p style="font-family:Lora;">${v.description }</p>
			 	</div>
			 </c:forEach>
			 </div>
		</div>
	</div>
</div>
</body>
</html>