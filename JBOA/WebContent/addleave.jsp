<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="indexTop.jsp"%>
<script type="text/javascript">
	$(function() {
		var begindate = $("input[name=leave\\.begindate]");
		var closuredate = $("input[name=leave\\.closuredate]");
		var days = $("input[name=leave\\.days]");
		var event= $("textarea[name=leave\\.event]");
		var form = $("form[action=addLeave]");

		//请假事由
		function checkEvent(){
			if (event.val() == "" || event.val() == null) {
				$("#event").html("请假事由不能为空");
				return false;
			}else{
				$("#event").html("");
				return true;
			}
			
		};
		
		event.blur(function(){
			checkEvent();
		});
		
		//请假开始时间
		function checkBegindate(){
			if (begindate.val() == "" || begindate.val() == null) {
			
				$("#begindate").html("请选择开始请假时间");
				return false;
			}else{
				$("#begindate").html("");
				return true;
			}			
		};
		
		begindate.blur(function(){
			checkBegindate();
		});
		
		//请假结束时间
		function checkClosuredate(){		
			if (closuredate.val() == "" || closuredate.val() == null) {
				$("#jsdate").html("请选择结束请假时间");
				return false;
			}else{
				$("#jsdate").html("");
				return true;
			}
		};
		//鼠标离开 结束时间
		closuredate.blur(function(){
			checkClosuredate();
			checkDate();
		});
	
		function checkDate() {
			
			var startTime = Date.parse(begindate.val());
			var endTime = Date.parse(closuredate.val());
			if (startTime >= endTime) {
				$("#jsdate").html("开始时间不能大于结束时间");
				bool=false;
			}else{
				$("#jsdate").html("");
				bool=true;
			}
			var leaveDay = (endTime - startTime) / 1000 / 60 / 60 / 24;
			days.val(leaveDay);
			return bool;
		};

		form.submit(function() {
			checkClosuredate();
			checkBegindate();
			checkEvent();
			 if(checkDate()==true&&checkClosuredate()==true&&checkBegindate()==true&&checkEvent()==true){
			 	return true;
			 }
			return false;
		});

	});
</script>
<div class="container-fluid">
	<br />
	<h4>请假申请</h4>
	<hr />
	<div class="row">
		<div class="col-lg-2"></div>
		<div class="col-lg-4">
			<form class="form-horizontal" action="addLeave">
				<div class="form-group">
					<label class="col-sm-3 control-label">请假类型:</label>
					<div class="col-sm-9">
						<select class="form-control" name="leave.leavetype">
							<option>年假</option>
							<option>婚假</option>
						</select>
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-3 control-label">开始时间:</label>
					<div class="col-sm-9">
						<input type="date" class="form-control" name="leave.begindate">
						 <span id="begindate" style="color:red;" class="help-block"></span>
					</div>
					
				</div>
				<div class="form-group">
					<label class="col-sm-3 control-label">结束时间:</label>
					<div class="col-sm-9">
						<input type="date" class="form-control" name="leave.closuredate">
						<span id="jsdate" style="color:red;" class="help-block"></span>
					</div>
					
				</div>
				<input type="hidden" class="form-control" name="leave.days">
				
				<div class="form-group">
					<label class="col-sm-3 control-label">请假事由:</label>
					<div class="col-sm-9">
						<textarea class="form-control" name="leave.event"></textarea>
						 <span id="event" style="color:red;" class="help-block"></span>
					</div>
					
				</div>
				<div class="form-group">
					<label class="col-sm-3 control-label">审批人:&nbsp;&nbsp;&nbsp;</label>
					<div class="col-sm-9">
						<input type="hidden" class="form-control"
							name="leave.sysEmployeeByExecutorEid.eid"
							value="${departmentManagerId}"> <input type="text"
							class="form-control" name="leave.sysEmployeeByExecutorEid.ename"
							value="${departmentManagerName}" readonly>
					</div>
				</div>
				<br />
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-5">
						<button type="submit" class="btn btn-primary">提交流程</button>
					</div>
					<div class="col-sm-offset-2 col-sm-3">
						<button type="submit" class="btn btn-primary">&nbsp;&nbsp;&nbsp;取消&nbsp;&nbsp;&nbsp;</button>
					</div>
				</div>
			</form>

		</div>
		<div class="col-lg-4"></div>
	</div>
</div>
<%@include file="indexbottm.jsp"%>