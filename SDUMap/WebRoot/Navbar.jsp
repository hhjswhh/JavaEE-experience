<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'Navbar.jsp' </title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my navbar">
	<link rel="stylesheet" type="text/css" href="bootstrap.min.css">

  </head>
  
  <body style="height:100%;background-color: gainsboro;">
		<div class="container">
		<nav class="navbar navbar-default">
				<div class="container-fluid">
					<!-- Collect the nav links, forms, and other content for toggling -->
					<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
						<ul class="nav navbar-nav">
							<li class="navbar-left">
								<h3>山东大学地图导航</h3>
							</li>
							<li>
								 &nbsp &nbsp &nbsp &nbsp  
							</li>
							<li class="active">
								<a href="index.jsp">首页<span class="sr-only">(current)</span></a>
							</li>
							<!-- <li class="navbar-right">
								<a href="#">导航</a>
							</li> -->

						</ul>
						
						<%	Cookie cookies[] = request.getCookies();
							Cookie username = null; 
							int i = 0;
								System.out.println("cookie number "+cookies.length);
							while(i < cookies.length){
								System.out.println("cookie name "+cookies[i].getName());
								if(cookies[i].getName().equals("username")){
									username = cookies[i];
									break;
								}
								i++;
							}
							if(username != null){
									System.out.println("Find cookie");
						%>		
							<div class="navbar-form navbar-right">
								欢迎回来 &nbsp &nbsp <%= java.net.URLDecoder.decode(username.getValue(),"UTF-8") %> &nbsp &nbsp
								<a class="btn btn-primary" href="Logout.jsp">注销</a>
							</div>
							
						<%
							} 
							else{
									System.out.println("Not find cookie");	
						%>
						<div class="navbar-form navbar-right">
							<a class="btn btn-primary" href="Login.jsp">登录</a>
							&nbsp &nbsp
							<a class="btn btn-default" href="Register.jsp">注册</a>
						</div>
						<%	
							} 
						%>
					</div>
				</div>
			</nav>
		
	</div>
	</body>

</html>
