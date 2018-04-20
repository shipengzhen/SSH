<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<base href="<%=basePath%>"/>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>青鸟租房 - 用户登录</title>
	<link type="text/css" rel="stylesheet" href="css/style.css" />
	<script type="text/javascript" src="scripts/function.js"></script>
	<script type="text/javascript" src="scripts/jquery-3.2.1.js"></script>
	<script type="text/javascript">
		$(function(){
			$("#username").blur(function(){
				var username=$(this).val();
				/* $.get('checkName.action','user.username='+username,
					function(data){
						$('#demo').html(data);
					}
				); */
				$.ajax({
					type:"get",
					url:"checkName.action",
					datatype:"json",
					data:"user.username="+username,
					success:function(data){
						if(data.isok){
							$('#demo').html("用户存在");
						}else{
							$('#demo').html("用户不存在");
						};
					},error:function(){
						alert("失败");
					}
				});
			});
		});
	</script>
</head>
<body>
<div id="header" class="wrap">
	<div id="logo"><img src="images/logo.gif" /></div>
</div>
<div id="regLogin" class="wrap">
	<div class="dialog">
		<div class="box">
			<h4>用户登录</h4>
			<s:form action="dologin.action" method="post">
				<div class="infos">
					<table class="field">					
						<tr>
							<td colspan="2" ><s:property value="message" /></td>
						</tr>
						<tr>
							<td class="field">用 户 名：</td>
							<td>
								<s:textfield name="user.username" id="username" cssClass="text" required="true"/>
								<!-- <input type="text" name="username" id="username" cssClass="text"/> -->
							</td>
						</tr>
						<tr>
							<td class="field">密　　码：</td>
							<td>
							<s:password name="user.password" cssClass="text" required="true"/>
							<!-- <input type="password" name="password" cssClass="text"/> -->
							</td>
						</tr>
					</table>
					<div class="buttons">
						<s:submit value="立即登录" />
						<s:submit value="注册" onclick="document.location='page/register.jsp';return false"></s:submit>
						<div id="demo" style="height:30px;"></div>
						<s:actionerror />
						${error}
						<!-- <input type='button' value='注册' onclick='document.location="page/register.jsp"'/> -->
					</div>
				</div>
			</s:form>
		</div>
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


