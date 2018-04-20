<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="indexTop.jsp"%>
<script type="text/javascript">
	
	$(function(){
		$(".sub01").click(function(){
			if($(this).attr("ng")=='1'){
				
				$("#checkLeaveFrom").submit();
			}
		
		
		});
		
	
	});
	function checkLeave(status) {
		
		$("#mspan").html("确定"+ status + "请假吗");
		$('#myModal2').modal();
		
		document.checkLeaveFrom[2].value=status;
	}
	
</script>
<div class="container-fluid">
	<br />
	<h4>请假基本信息</h4>
	<hr />
	<form class="form-inline"  action="checkLeave.action" method="post"
		name="checkLeaveFrom" id="checkLeaveFrom">
		<div class="row">
			<div class="col-md-3">
				<div class="form-group">
					<label>&nbsp;&nbsp; 填写人:</label>
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
					<label>&nbsp;&nbsp;休假类型:</label>
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
					<label>&nbsp;&nbsp;请假天数:</label>
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
					<label>&nbsp;&nbsp; 请假事由:</label>
					<p class="form-control-static">${leave.event}</p>
				</div>
			</div>
		</div>
		<hr />
		<div class="row">
			<div class="col-md-5">
				<div class="form-group">
					<label>&nbsp;&nbsp;审批意见：</label>
					<textarea class="form-control input-lg "
						name="leave.leaveResult.shsuggestion"></textarea>
				</div>
			</div>
		</div>
		<br/>
		<br />
		<div class="row">
			<input type="hidden" name="leave.id" value="${leave.id}">
			<input type="hidden" id="leave.status" name="leave.status" />
			<div class="col-lg-1"></div>
			<div class="col-lg-1">
				<a type="button" class="btn btn-primary" id="SCCB" onclick="checkLeave('已审批')">审批通过</a>
			</div>
			<div class="col-lg-1">
				<a type="button" class="btn btn-primary" id="ballback" onclick="checkLeave('已打回 ')">打回</a>
			</div>
			<div class="col-lg-1">
				<a type="button" class="btn btn-primary" onclick="window.history.go(-1)">返回</a>
			</div>
			<div class="col-lg-6"></div>
		</div>
	</form>
</div>

	 <!-- Modal -->
					<div class="modal fade" id="myModal2" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
						  <div class="modal-dialog" role="document">
						    <div class="modal-content">
						      <div class="modal-header">
						        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
						        <h4 class="modal-title" id="myModalLabel">提示</h4>
						      </div>
						      <div class="modal-body">
						      		<span id="mspan"></span>
						      </div>
						      <div class="modal-footer">
						        <button type="button" class=" btn btn-default sub01" ng="1"  data-dismiss="modal">确定</button>
								<button type="button" class=" btn btn-default sub01"   data-dismiss="modal">关闭</button>
						      </div>
						    </div>
						  </div>
						</div>

<%@include file="indexbottm.jsp"%>