<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>To Do</title>
<jsp:include page="allcssjs.jsp" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>
<jsp:include page="header.jsp"/>
	<div class="container-fluid">
		<!-- 1 Row starts -->
		<div class="row mt-4">
			<!-- 1 Col  -->
			<div class="col-md-6 offset-3">
				<div class="card shadow" style="background-color:#3366cc;">
					<div class="card-header text-center" style="background-color:#000099;">
						<h2 class="text-white">Edit ToDo Task</h2>
					</div>
					<div class="card-body">
					<c:forEach var="i" items="${list }">
						<form action="${pageContext.request.contextPath }/update" method="post">
							<div class="mb-3">
								<input name="id" type="hidden" value="${i.id}">
								<label for="title" class="form-label text-dark fs-4">Title</label> 
								<input type="text" class="form-control" name="title" 
									   id="title" value="${i.title }">
									

							</div>
							<div class="mb-3">
								<label for="description" class="form-label">Description</label>
								<textarea class="form-control" rows="8" name="description"
										   >${i.description}</textarea>
							</div>

							<div class="text-center">
								<button type="submit" class="btn btn-warning">Update</button>
							</div>
						</form>
					</c:forEach>
					</div>
				</div>
			</div>
			<!-- / 1 Col -->

			<!-- 2nd Col -->
			<%-- <div class="col-md-5">
				<div class="card shadow" style="background-color:#80b3ff;">
					<div class="card-header text-center" style="background-color:#003300;" >
						<h4 class="text-light">List of ToDo's</h4>
					</div>
					<div class="card-body">
						<table class="table">
							<thead>
								<tr>
									<th>Id</th>
									<th>Title Name</th>
									<th></th>
								</tr>
							</thead>

							<tbody>
								<c:forEach var="i" items="${list }">
									<tr>
										<td>${i.id }</td>
										<td>${i.title }</td>
										<td>
											<a href="open/${i.id }" class="text-primary"><i class="fa fa-solid fa-eye"></i></a>
											<a href="edit/${i.id }" class="ms-2" style="color:#0099cc;"><i class="fa fa-solid fa-edit"></i></a>
											<a href="delete/${i.id }" class="text-danger ms-2"><i class="fa fa-trash"></i></a>
										</td>
										
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</div> --%>
			<!-- / 2nd Col -->
		</div>
	</div>
</body>
</html>