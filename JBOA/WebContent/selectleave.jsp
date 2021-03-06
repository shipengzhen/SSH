<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="indexTop.jsp"%>
<div class="container-fluid">
	<br />
	<h4>请假基本信息</h4>
	<hr />
	<form class="form-inline">
		<div class="row">
			<div class="col-md-3">
				<div class="form-group">
					<label>&nbsp;&nbsp;填写人：</label>
					<p class="form-control-static">${leave.sysEmployeeByProposerEid.ename}</p>
				</div>
			</div>
			<div class="col-md-3">
				<div class="form-group">
					<label>&nbsp;&nbsp;处理人：</label>
					<p class="form-control-static">${leave.sysEmployeeByExecutorEid.ename}</p>
				</div>
			</div>
			<div class="col-md-3">
				<div class="form-group">
					<label>&nbsp;休假类型：</label>
					<p class="form-control-static">${leave.leavetype}</p>
				</div>
			</div>
		</div>
		<br />
		<div class="row">
			<div class="col-md-3">
				<div class="form-group">
					<label>&nbsp;&nbsp;开始时间：</label>
					<p class="form-control-static"><fmt:formatDate value="${leave.begindate}"/></p>
				</div>
			</div>
			<div class="col-md-3">
				<div class="form-group">
					<label>&nbsp;&nbsp;结束时间：</label>
					<p class="form-control-static"><fmt:formatDate value="${leave.closuredate}"/></p>
				</div>
			</div>
			<div class="col-md-3">
				<div class="form-group">
					<label>&nbsp;&nbsp;请假天数：</label>
					<p class="form-control-static">${leave.days}</p>
				</div>
			</div>
		</div>
		<br />
		<div class="row">
			<div class="col-md-3">
				<div class="form-group">
					<label>&nbsp;&nbsp;审批状态:</label>
					<p class="form-control-static">${leave.status}</p>
				</div>
			</div>
			<div class="col-md-3">
				<div class="form-group">
					<label>&nbsp;&nbsp;请假事由:</label>
					<p class="form-control-static">${leave.event}</p>
				</div>
			</div>
			
			
		</div>
		<hr />
		<br />
		<div class="row">
			<div class="col-md-12">
				<div class="form-group">
					<div class="col-md-4" style="padding: 0px;">
						<label>&nbsp;&nbsp;&nbsp;审批意见：</label>
					</div>
					<div class="col-md-6" style="padding: 0px;">
						<textarea readonly="readonly" class="form-control input-lg" rows="" cols="">${leave.leaveResult.shsuggestion}</textarea>
					</div>
				</div>
			</div>
		</div>
		<br />
		<div class="row">
			<div class="col-lg-1"></div>
			<div class="col-lg-6">
				
			</div>
			<div class="col-lg-2"><a type="button" onclick="window.history.go(-1)" class="btn btn-default">&nbsp;&nbsp;返回&nbsp;&nbsp;</a></div>
		</div>
	</form>
</div>
<%@include file="indexbottm.jsp"%>