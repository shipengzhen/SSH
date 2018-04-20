<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<base href="<%=basePath%>">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>青鸟租房 - 用户管理</title>
	<link type="text/css" rel="stylesheet" href="css/style.css" />
	<script type="text/javascript" src="scripts/function.js"></script>
	<script type="text/javascript">
		function toUrl(url){

			window.location.href = url;

			return;
		}
		function update(id){
			document.location = '/HouseRent/page/modify.jsp?id=' + id;
		}
	</script>
</head>
<body>
<div id="header" class="wrap">
	<div id="logo"><img src="images/logo.gif" /></div>
	<div class="search">
	<!--
		<form method="get">
			<input class="text" type="text" name="keywords" />
			<label class="ui-green"><input type="button" name="search" value="搜索房屋" /></label>
		</form>
	-->	
		<label class="ui-green"><input onclick="toUrl('add.jsp');" type="button" name="search" value="发布房屋信息" /></label>	
		<label class="ui-green"><input type="button" name="search" value="退       出" /></label>
	</div>
</div>
<div class="main wrap">
	<table class="house-list">
	<c:if test="${requestScope.result ne null}">	
	<c:forEach items="${requestScope.result}" var="house" varStatus="status">
		<c:if test="${status.count%2 != 0}">
		<tr>
			<td class="house-thumb"><span><a href="show?id=${house.id}"><img src="images/thumb_house.gif" /></a></span></td>
			<td>
				<dl>
					<dt><a href="show?id=${house.id}">${house.title}</a></dt>
					<dd>
						${house.street.district.name}区${house.street.name},${house.floorage }平米<br />
						联系方式：${house.contact }	
					</dd>
				</dl>
			</td>
			<td class="house-type"><label class="ui-green"><input type="button" onclick='update(${house.id})' name="search" value="修    改" /></label></td>
			<td class="house-price"><label class="ui-green"><input type="button" name="search" value="删    除" /></label></td>
		</tr>
		</c:if>
		<c:if test="${status.count%2 == 0}">
		<tr class="odd">
			<td class="house-thumb"><span><a href="view.html"><img src="images/thumb_house.gif" /></a></span></td>
			<td>
				<dl>
					<dt><a href="show?id=${house.id}">${house.title}</a></dt>
					<dd>
						${house.street.district.name}区${house.street.name},${house.floorage }平米<br />
						联系方式：${house.contact }				
					</dd>
				</dl>
			</td>
			<td class="house-type"><label class="ui-green"><input type="button" onclick='update(${house.id})' name="search" value="修    改" /></label></td>
			<td class="house-price"><label class="ui-green"><input type="button" name="search" value="删    除" /></label></td>
		</tr> 
		</c:if>
		
    </c:forEach>
    </c:if>   
  	<c:if test="${empty requestScope.result}">
    	<tr><c:out value="无租房信息"></c:out></tr> 
    </c:if>
	</table>
	<div class="pager">
		<ul>
			<li class="current">首页</li>
			<li><a href="#">上一页</a></li>
			<li><a href="#">下一页</a></li>
			<li><a href="#">末页</a></li>
		</ul>
		<span class="total">1/2页</span>
	</div>
</div>
<div id="footer" class="wrap">
	<dl>
    	<dt>青鸟租房 &copy; 2010 北大青鸟 京ICP证1000001号</dt>
        <dd>关于我们 · 联系方式 · 意见反馈 · 帮助中心</dd>
    </dl>
</div>
</body>
</html>


