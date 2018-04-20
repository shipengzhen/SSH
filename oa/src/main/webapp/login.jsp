<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<title>OA办公系统</title>
<link href="css/bootstrap.css" rel="stylesheet">
</head>

<body>
	<div class="container" style="margin-top: 150px;">
		<div class="row clearfix">
			<div class="col-md-12 column">
				<div class="row clearfix">
					<div class="col-md-4 column"></div>
					<div class="col-md-4 column">
						<form class="form-horizontal" action="login" role="form" method="post">
							<div class="form-group">
								<label class="col-sm-3 control-label">账号:</label>
								<div class="col-sm-9">
									<input class="form-control" name="ename" type="text" />
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label">密码:</label>
								<div class="col-sm-9">
									<input class="form-control" name="epassword" type="password" />
									<span id="helpBlock" class="help-block"> <s:property
											value="msg" />
									</span>
								</div>

							</div>

							<div class="form-group sr-only">
								<div class="col-sm-offset-2 col-sm-10">
									<div class="checkbox">
										<label><input type="checkbox" />Remember me</label>
									</div>
								</div>
							</div>
							<div class="form-group">
								<s:property value="msg" />
								<div class="col-sm-offset-2 col-sm-10">
									<button type="submit" class="btn btn-primary">&nbsp;登录&nbsp;</button>
								</div>
							</div>
						</form>
					</div>
					<div class="col-md-4 column"></div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
