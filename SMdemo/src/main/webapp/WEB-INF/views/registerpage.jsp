<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="allcssjs.jsp"/>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
<title>Create Account</title>
</head>
<body>
<div class="container">
	<div class="row mt-3">
		<div class="col-md-6 offset-3">
			 <div class="card border-radius-4 shadow">
			 <div class="card-header text-center">
			 	 <h2>Create a new account</h2>
			 </div>
			 <div class="card-body">
			 	 <form action="register" method="post" id="form_data">
			 	 
			 	 		  <div class="mb-3">
						    <label for="fullname" class="form-label">Full Name</label>
						    <input type="text" class="form-control" name="fullname" placeholder="Enter fullname"
						    		id="fullname" aria-describedby="fullname">
						  </div>
						  
						  <div class="mb-3">
						    <label for="fullname" class="form-label">Email</label>
						    <input type="email" class="form-control" name="email" placeholder="Enter email address"
						    		id="email" aria-describedby="email">
						  </div>
						  
						  <div class="mb-3">
						    <label for="mobile" class="form-label">Mobile</label>
						    <input type="text" maxlength="10" class="form-control" name="mobile" oninput="numberOnly(this.id);"
						    		id="mobile" aria-describedby="mobile" placeholder="Enter mobile">
						  </div>
						  
						  <div class="mb-3">
						    <label for="exampleInputPassword1" class="form-label">Set Password</label>
						    <input type="password" class="form-control" name="password"
						    		id="exampleInputPassword1" placeholder="Set password">
						  </div>
						  
						  <div class="mb-3">
						    <label for="exampleInputPassword1" class="form-label">Date of Birth</label>
						    <input type="date" class="form-control" name="dob"
						    		id="exampleInputPassword1">
						  </div>
  
  						 <div class="text-center">
							 <button type="submit" class="btn btn-success">Submit</button>		 	
  						 </div>
			 	 </form>
			 </div>
			 
			 </div>
		</div>
	</div>
</div>
<script type="text/javascript">
	$(document).ready(function(){
		/* alert("Hello") */
		$(".btn").click(function(){
			var data = $("#form_data").val();
			alert(data);
		})
	})
</script>
</body>
</html>