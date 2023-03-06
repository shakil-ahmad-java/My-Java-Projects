<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Users List</title>
<jsp:include page="allcssjs.jsp"/>
<script src='https://kit.fontawesome.com/a076d05399.js' crossorigin='anonymous'></script>
</head>
<body>
<jsp:include page="header.jsp"/>

<div class="col-md-8 col-sm-8 offset-2 mt-2">
	<table class="table table-striped">
		<thead>
			<tr class="bg-secondary">
				<th>ID</th>
				<th>Name</th>
				<th>Mobile</th>
				<th>Email</th>
				<th>Action</th>
			</tr>
		</thead>
		
		<c:forEach var="u" items="${userslist }">
			<tr>
		  		<td>${u.id}</td>
		  		<td>${u.name}</td>
		  		<td>${u.mobile}</td>
		  		<td>${u.email}</td>
		  		<td class="">
		  			<a href="${pageContext.request.contextPath }/edit/${u.id }"><i class="fas fa-edit text-primary me-3"></i></a>
		  			<a href="delete/${u.id }"><i class="fas fa-trash text-danger "></i></a>
		  		</td>
		  		
		  	</tr>
		</c:forEach>
			
	</table>	
</div>
</body>
</html>