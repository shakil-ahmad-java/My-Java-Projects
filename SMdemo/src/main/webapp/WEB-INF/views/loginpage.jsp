<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="allcssjs.jsp"/>
<title>Login</title>
</head>
<body>
<div class="container-fluid">
	<div class="row justify-content-center mt-4">
		<div class="col-md-4">
			<div class="card shadow">
				<div class="card-header text-center">
					<h3>Login</h3>
				</div>
				<div class="card-body">
					<form action="signin" method="post">
						<label class="form-label">Email</label>
						<input class="form-control" type="email" name="email" placeholder="Enter email address"/>
						<label class="form-label">Password</label>
						<input class="form-control" type="password" name="password" placeholder="Enter password"/>
						<div class="text-center mt-2">
							<button class="btn btn-primary">Login</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</div>
</body>
</html>