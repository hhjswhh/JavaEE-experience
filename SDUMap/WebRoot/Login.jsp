<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>

	<head>
    <base href="<%=basePath%>">
		<meta charset="UTF-8">
		<meta name="keywords" content="山东大学 地图">
		<meta name="description" content="山东大学各校区地图查询">
		<meta name="title" content="山东大学地图查询">
		<title>山东大学地图导航</title>
		<link rel="stylesheet" type="text/css" href="bootstrap.min.css">
	</head>

	<body style="height:100%;background-color: gainsboro;">
		<div class="container">
			<jsp:include page="Navbar.jsp"></jsp:include>
			
			<div class="row">
				<div class="col-md-4"></div>
				<div class="col-md-4">
					<h1>山东大学地图导航</h1>
				</div>
				<div class="col-md-4"></div>
			</div>

			<div class="row">
				<div class="col-md-4"></div>
				<div class="col-md-4">
					<form class="form-horizontal" action="./servlet/LoginServlet" method="POST">
						<!--<div class="form-group">-->
						<div class="row">
							<label class="col-xs-4">用户名</label>
						</div>

						<div class="row">
							<div class="col-xs-10">
								<input type="text" class="form-control" name="username" placeholder="用户名">
							</div>
						</div>
						<!--</div>-->

						<!--<div class="form-group">-->
						<div class="row">
							<label class="col-xs-4">密码</label>
						</div>

						<div class="row">
							<div class="col-xs-10">
								<input type="password" class="form-control" name="password" placeholder="密码">
							</div>
						</div>
						<!--</div>-->
						<div class="form-group">
						</div>

						<div class="col-xs-1"></div>
						<div class="col-xs-4">
							<input class="btn btn-primary" type="submit" value="登录">
						</div>
						<div class="col-xs-4">
							<input class="btn btn-default" type="button" value="注册">
						</div>
					</form>
				</div>
				<div class="col-md-4"></div>
			</div>
		</div>
		</div>
			<jsp:include page="Bottom.jsp"></jsp:include>
	</body>

</html>
