<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC 
	"-//W3C//DTD XHTML 1.0 Transitional//EN" 
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>iterator标签</title>
	</head>
	<body>
		使用iterator标签遍历集合:<br/>
		<s:iterator value="list">
			<s:property value="name"/><br/>
		</s:iterator>
	</body>
</html>