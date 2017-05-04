<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Logout.jsp'</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="bootstrap.min.css">

  </head>
  
  <body>
  	<jsp:include page="Navbar.jsp"></jsp:include>
  		<!-- 添加再见内容 -->
  		
  		
  		
  		
  	<%	Cookie cookies[] = request.getCookies();
  		Cookie cookie = null;
  		for(int i=0; i<cookies.length; i++){
  			if(cookies[i].getName().equals("username")){
  				cookie = cookies[i];
		  		cookie.setMaxAge(0);
		  		response.addCookie(cookie);		
		  	}
  		}
  		
  		response.setHeader("Refresh", "5;URL=index.jsp"); 
  	 %>
  	 
  	 
  </body>
</html>
