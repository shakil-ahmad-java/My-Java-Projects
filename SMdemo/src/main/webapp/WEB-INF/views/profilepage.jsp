<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="allcssjs.jsp"/>
<title>Profile</title>
</head>
<body>
<div class="container-fluid">
	<div class="row">
		<div class="col-md-8 offset-2">
			<form action="post" method="post" enctype="multipart/form-data">
				<textarea class="form-control" name="desc" rows="3" placeholder="Write something.."></textarea>
				<input class="form-control" type="file" name="postImg" >
				<input class="btn btn-primary" type="submit" value="Post">
			</form>
		</div>
	</div>
</div>
</body>
</html>