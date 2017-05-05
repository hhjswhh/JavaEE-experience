<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my welcome page">

<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<!-- Bootstrap -->
<link href="bootstrap.min.css" rel="stylesheet">

</head>

<body >

	<!-- nav start -->
	<div class="container">
 		<jsp:include page="Navbar.jsp"></jsp:include>
	<!-- nav end -->

	<div class="container">
		<div class="jumbotron">
			<h1 class="">欢迎来到山东大学地图导航</h1>
			<p>查看各类地图请点击按钮</p>
			<p>
			
			<% Cookie cookies[] = request.getCookies();
			   Cookie cookie = null;
			   for(int i=0; i<cookies.length; i++){
			   		if(cookies[i].getName().equals("username")){
			   		cookie = cookies[i];
			   		}
			   }
			   if(cookie != null){
			%>			
			<div class="list-group">
				<a href="zxschool.jsp" class="list-group-item">中心校区</a> <a
					href="qfsschool.jsp" class="list-group-item">千佛山校区</a> <a
					href="btqschool.jsp" class="list-group-item">趵突泉校区</a> <a
					href="hjlschool.jsp" class="list-group-item">洪家楼校区</a> <a
					href="rjyschool.jsp" class="list-group-item">软件园校区</a> <a
					href="xlsschool.jsp" class="list-group-item">兴隆山校区</a>
			</div>
			<% }else{ %>
			<div class="list-group">
				<a href="Login.jsp" class="list-group-item">中心校区</a> <a
					href="Login.jsp" class="list-group-item">千佛山校区</a> <a
					href="Login.jsp" class="list-group-item">趵突泉校区</a> <a
					href="Login.jsp" class="list-group-item">洪家楼校区</a> <a
					href="Login.jsp" class="list-group-item">软件园校区</a> <a
					href="Login.jsp" class="list-group-item">兴隆山校区</a>
			</div>
			<% } %>
			</p>
		</div>
	</div>

		<%@ include file="Bottom.jsp" %>
	</div>
</body>

</html>