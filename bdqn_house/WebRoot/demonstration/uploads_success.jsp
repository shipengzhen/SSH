<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags"  prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>文件上传</title>
    
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
  	  您所上传的文件是：
  	   	 <s:if test="uploadFileName!=null">
	 	 	<s:iterator value="uploadFileName" id="name"> 
	 	 		<s:property value="name"/>
	 	 	</s:iterator>
 		 </s:if>
 		 <br/>
<%--   	  <s:property value="uploadFileName"/><br/> --%>
 	  文件类型：
 	   	<s:if test="uploadContentType!=null">
 	 		<s:iterator value="uploadContentType" id="type"> 
 	 			<s:property value="type"/>
 	 		</s:iterator>
 	 </s:if>
 	 <br/>
 	  <%-- <s:property value="uploadContentType"/><br/> --%>
 	  图片：
 	 <s:if test="uploadFileName!=null">
 	 	<s:iterator value="uploadFileName" id="name"> 
 	  		<img src="<%=basePath%>/upload/<s:property value='name'/>"  width="200" height="200"/>
 	  		<a href="download.action?fileName=<s:property value='name'/>">点击此处下载文件</a>
 	 	</s:iterator>
 	 </s:if>
  </body>
</html>
