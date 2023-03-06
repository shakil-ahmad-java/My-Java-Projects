<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register</title>
<jsp:include page="allcssjs.jsp"/>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script type="text/javascript">
function numberOnly(id){
	var element = document.getElementById(id);
	var regex = /[^0-9]/g;
	element.value = element.value.replace(regex, "");
}
</script>
</head>
<body>

	<div class="container">
		<div class="row justify-content-center mt-2">
			<div class="col-md-4 col-sm-4">
			<div class="card shadow p-2">
			
				<form action="${pageContext.request.contextPath }/update" method="post" modelAttribute="emp">
				<div class="card-header text-center mb-2"><h2 class="">Update Form</h2></div>
				
				<c:forEach var="i" items="${list}">
				
				<input class="" type="hidden" name="id" value='${i.id }'/>
				
				<label class="form-label">Full Name</label>
				<input class="form-control mb-2" type="text" name="name" value="${i.name }">
				
				<label class="form-label">Email</label>
				<input class="form-control mb-2" type="email" name="email" value="${i.email }">
				
				<label class="form-label">Mobile</label>
				<input class="form-control mb-2" id="mobile" type="text" name="mobile" oninput="numberOnly(this.id);" maxlength="10" value="${i.mobile }">
				</c:forEach>				
				<div class="text-center">
					<button class="btn btn-success" id="submitbtn">Submit</button>
				</div>
				
			</form>
			</div>
		</div>
		</div>
	</div>
<script type="text/javascript">
	$(document).ready(function(){
		$("#submitbtn").click(function(){
			
		})
	})
</script>
</body>
</html>