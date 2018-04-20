<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
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
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  	<%--  <jsp:forward page="/demonstration/file_input.jsp"></jsp:forward> --%>
    <a href="demonstration/array_input.jsp">面向数组的转换</a>
    <a href="demonstration/list_input.jsp">面向集合的转换</a>
    <a href="demonstration/date_input.jsp">日期格式的转换</a>
    <a href="demonstration/timer_input.jsp">Action的执行时间</a>
    <a href="demonstration/file_input.jsp">上传单个文件</a>
    <a href="demonstration/files_input.jsp">上传多个文件</a>
  </body>
</html>
