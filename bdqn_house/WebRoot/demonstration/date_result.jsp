<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'success.jsp' starting page</title>
    
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
  	<%-- <s:set name="name" value="spz" /> --%>
  	对于字符串类型的属性，如果要访问动态数据，必须使用%{...}这样的语法，否则将被直接看作字符串常量
  	<s:property value="#request.name"/> <br>
  	<%-- ${name} <br> --%>
    <s:property value="timeDate"/> <br>
    <s:date name="timeDate" format="dd/MM/yyyy"/> <br>
    <s:date name="timeDate"/> <br>
  </body>
</html>
