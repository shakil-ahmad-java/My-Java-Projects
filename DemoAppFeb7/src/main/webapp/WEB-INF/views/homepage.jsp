<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
<%@ include file="allcssjs.jsp"%>
<style type="text/css">
.banner {
	clip-path: polygon(0 0, 100% 0, 100% 65%, 63% 50%, 31% 68%, 0% 50%);
}

.footer {
	position: fixed;
	width: 100%;
	height: 80px;
	bottom: 0;
}
</style>
</head>
<body>
	<%@ include file="header.jsp"%>

	<div class="container-fluid banner"
		style="background-color: #003300; height: 400px;">

		<div class="container text-light">
			<h2>Hasanpurwa</h2>
			<p>Established in 1989, we are India’s oldest Weather Technology
				Company. We have a history of innovation and our mission is to
				provide turn-key solutions in weather monitoring and forecasting for
				a wide variety of applications. Our industries include Meteorology,
				Renewable Energy, Aviation, Agriculture, Disaster Management, Road
				Transport, and Hydrology.</p>
		</div>

	</div>

	<div class="footer" style="background-color: #003300;">
		<div class="col-md-4 offset-4 text-center">
			<p class="text-light mt-4" style="font-size: 12px;">
				<span>&#169;</span>&nbsp;&nbsp; Bkc Weathersys Pvt. Ltd.
			</p>
		</div>
	</div>
</body>
</html>