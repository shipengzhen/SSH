<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
	<%@include file="indexTop.jsp" %>
<div class="container-fluid">
	<script type="text/javascript" src="js/SPcv.js"></script>
	<br />
	<h4>审批报销单</h4>
	<hr/>
		<form class="form-inline" id="resultFrom" action="saveCheckResult2.action" method="post">
			<div class="row">
				<div class="col-md-3">
					<div class="form-group">
					    <label>&nbsp;&nbsp; 填写人：</label>
						 <input type="hidden" value="${cv.id}" name="bizClaimVoucher.id" >
						 <input type="hidden" value="" name="bizCheckResult.result" id="cvresult" >
					     <p class="form-control-static">${cv.sysEmployeeByProposerEid.ename }</p>
					</div>
				</div>
				<div class="col-md-3">
					<div class="form-group">
						<label>&nbsp;&nbsp; 部&nbsp;&nbsp;&nbsp;&nbsp;门：</label>
						 <p class="form-control-static">${cv.sysEmployeeByProposerEid.sysDepartment.dname }</p>
					</div>
				</div>
				<div class="col-md-3">
					<div class="form-group">
					    <label>&nbsp;&nbsp;状态：</label>
						<p class="form-control-static">${cv.status }</p>
					</div>
				</div>
			</div>
		<br />
			<div class="row">
				<div class="col-md-3">
					<div class="form-group">
					    <label>&nbsp;&nbsp; 总金额：</label>
					     <p class="form-control-static">${cv.moeny }</p>
					</div>
				</div>
				<div class="col-md-3">
					<div class="form-group">
						<label>&nbsp;&nbsp;创建时间：</label>
						<p class="form-control-static"><fmt:formatDate value="${cv.begindate}" pattern="yyyy-MM-dd HH:mm" /></p>
					</div>
				</div>
				<div class="col-md-3">
					<div class="form-group">
					    <label>&nbsp;&nbsp;处理人：</label>
						<p class="form-control-static">${cv.sysEmployeeByExecutorEid.ename }</p>
					</div>
				</div>
			</div>
		<hr />
			<div class="row">
				<div class="col-lg-8">
					<table class="table table-bordered table-hover text-center">
						<tr>
							<th width="5%" class="text-center">#</th>
							<th width="15%" class="text-center">项目类型</th>
							<th width="10%" class="text-center">项目金额</th>
							<th width="40%" class="text-center">费用说明</th>
						</tr>
						 <s:iterator value="#request.cd">
						<tr>
							<td><span style="color:#337ab7" class="glyphicon glyphicon-list-alt"></span></td>
							<td><s:property value="item"/></td>
							<td><s:property value="acount"/></td>
							<td><s:property value="des"/></td>
						</tr>
						</s:iterator>
					</table>
				</div>
				<div class="col-lg-4"></div>
			</div>
		<hr />	
		
		
		<div class="row">
				<div class="col-lg-1" style="margin-left: 10px;"><label>审批意见:</label></div>
				<div class="col-lg-6" style="margin-left: -30px;">
					<textarea  name="bizCheckResult.comm" class="form-control "></textarea>
				</div>
				<div class="col-lg-5"></div>
			</div>
		<br/>
			<div class="row">
				<div class="col-lg-5"></div>
				<div class="btn-group col-lg-5" role="group" aria-label="...">
					<c:if test="${cr!=null}">
					  <button type="button" class="btn btn-default" data-toggle="modal" data-target="#myModal2">上一级审核结果</button>
					</c:if>
					  <button type="button" nd="1" class="submit002  btn btn-default">通过</button>
					  <c:if test="${User.sysPosition.pid==1||User.sysPosition.pid==2}">
					 	 <button type="button" nd="2" class="submit002 btn btn-default">拒绝</button>
					  	 <button type="button" nd="3" class="submit002 btn btn-default">打回</button>
					  </c:if>
					  <button type="button" onclick="window.history.go(-1)" class="btn btn-default">返回</button>
				</div>
			</div>
			
	</form>
</div>
 <!-- Modal -->
					<div class="modal fade" id="myModal2" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
						  <div class="modal-dialog" role="document">
						    <div class="modal-content">
						      <div class="modal-header">
						        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
						        <h4 class="modal-title" id="myModalLabel">添加子项</h4>
						      </div>
						      <div class="modal-body">
						      		<table class="table table-bordered table-hover text-center"  >
						      		<tr style="background-color: #999;" >
						      		
						      			<th width="22%" class="text-center">审核人</th>
						      			<th  width="22%" class="text-center">审核时间</th>
						      			<th width="10%" class="text-center">结果</th>
						      			<th width="30%" class="text-center">意见</th>
						      		</tr>
							      		<tr>
							      			<td>${cr.sysEmployee.ename} ( ${cr.sysEmployee.sysPosition.pname} )</td>
							      			<td><fmt:formatDate value="${cr.checkDate }" pattern="yyyy-MM-dd HH:mm"/></td>
							      			<td>${cr.result }</td>
							      			<td>
							      				<c:if test=" ${cr.comm==null||cr.comm==''}">无</c:if> ${cr.comm }
							      			</td>
							      		</tr>
								</table>
						      </div>
						      <div class="modal-footer">
						        <button type="button" class=" btn btn-default"   data-dismiss="modal">关闭</button>
					
						      </div>
						    </div>
						  </div>
						</div>


<%@include file="indexbottm.jsp" %>