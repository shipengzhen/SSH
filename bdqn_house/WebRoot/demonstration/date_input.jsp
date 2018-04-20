<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
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
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
</head>

<body>
	<s:form action="dateConvert.action">
		<div class="infos">
			<table class="field">
				<tr>
					<td class="field">请输入日期：</td>
					<td>
						<input type="text" class="text" name="timeDate" />
						eg:yyyy 年MM 月dd 日,yyyy-MM-dd,MM/dd/yy,yyyy.MM.dd,yyMMdd,yyyy/MM/dd
					</td>
				</tr>
				<s:fielderror />
				<s:submit value="转换格式" />
			</table>
		</div>
	</s:form>
</body>
</html>
