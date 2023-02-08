<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<%@ include file="allcssjs.jsp"%>
</head>
<body>
	<jsp:include page="header.jsp" />
	<div class="container-fluid">
		<div class="row mt-3">
			<div class="col-md-4 offset-4 p-2">
				<div class="card">

					<div class="card-header"><h2 class="text-center">Login Here</h2></div>
					<div class="card-body">
						<form action="process-login" method="post">
							<label class="form-label">Username</label> <input
								class="form-control" type="text" name="username"> <label
								class="form-label">Password</label> <input class="form-control"
								type="password" name="password">

							<button class="btn btn-success mt-2">Sumit</button>
						</form>
					</div>


				</div>
			</div>
		</div>
	</div>
</body>
</html>