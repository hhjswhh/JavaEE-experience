<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>

<head>
<base href="<%=basePath%>">

<title>My JSP 'index.jsp' starting page</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my welcome page">

<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<!-- Bootstrap -->
<link href="bootstrap.min.css" rel="stylesheet">

</head>

<body style="height:100%;background-color: gainsboro;">

	<!-- nav start -->
	<div class="container">
		<nav class="navbar navbar-default">
		<div class="container-fluid">
			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
					<li class="active"><a href="index.jsp">首页<span
							class="sr-only">(current)</span>
					</a></li>
					<li class="navbar-right"><a href="#">导航</a></li>

				</ul>
				<div class="navbar-form navbar-right">
					<a class="btn btn-primary" href="Login.html">登录</a> <a
						class="btn btn-default" href="Registe.html">注册</a>
				</div>
			</div>
		</div>
		</nav>

	</div>
	<!-- nav end -->

	<div class="container">
		<div class="jumbotron">
			<h1 class="">欢迎来到山东大学地图导航</h1>
			<p>查看各类地图请点击按钮</p>
			<p>
			<div class="list-group">
				<a href="zxschool.jsp" class="list-group-item">中心校区</a> <a
					href="qfsschool.jsp" class="list-group-item">千佛山校区</a> <a
					href="btqschool.jsp" class="list-group-item">趵突泉校区</a> <a
					href="hjlschool.jsp" class="list-group-item">洪家楼校区</a> <a
					href="rjyschool.jsp" class="list-group-item">软件园校区</a> <a
					href="xlsschool.jsp" class="list-group-item">兴隆山校区</a>
			</div>
			</p>
		</div>
	</div>

</body>

</html>