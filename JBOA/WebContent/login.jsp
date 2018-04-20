<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>OA</title>
		<link href="./Wopop_files/style_log.css" rel="stylesheet" type="text/css">
	</head>

	<body class="login" mycollectionplug="bind">
		<div class="login_m">
			<div class="login_logo"></div>
			<div class="login_boder">
				<form class="form-horizontal" action="login.action" method="post" role="form">
				<div class="login_padding" id="login_model">
				
					<h2>用户名：</h2>
					<label>
    				<input type="text"  name="ename" class="txt_input txt_input2" value="">
    			</label>
					<h2>密码：</h2>
					<label>
    				<input type="password" name="epassword" class="txt_input" value="">
  				</label>

					<p class="forgot">
						<a id="iforget" href="javascript:void(0);">忘记密码？</a>
					</p>

					<div class="rem_sub">
						<div class="rem_sub_l">
							<input type="checkbox" name="checkbox" id="save_me">
							<label for="checkbox">记住密码</label>
						</div>
						<label>
     				 <input type="submit" class="sub_button" name="button" id="button" value="登录" style="opacity: 0.7;">
    				</label>
					</div>	
					</div>
				</form>
				
			</div>
		</div>

	</body>

</html>