<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title></title>
		<link rel="stylesheet" type="text/css" href="bootstrap.min.css" />
	</head>

	<body>
	<%@ include file="Navbar.jsp" %>
		<div class="container-fluid">
			<div class="row">

				<h2 align="center">这是千佛山校区的地图</h2>
				<div class="col-xs-3"></div>
				<div class="col-xs-8">

					<iframe src="qfsmap.html" width="1000" height="680" frameborder="0" scrolling="no"></iframe>

				</div>
			</div>
		</div>
			<%@ include file="Bottom.jsp" %>
	</body>

</html>