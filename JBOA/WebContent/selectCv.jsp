<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
	<%@include file="indexTop.jsp" %>
<div class="container-fluid">

	<div style="margin-top: 20px; "><h4>基本信息</h4></div>
	<hr/>
		<form class="form-inline">
			<div class="row">
				<div class="col-md-3">
					<div class="form-group">
					    <label>&nbsp;&nbsp; 填写人：</label>
				
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
						<p class="form-control-static"><fmt:formatDate value="${cv.begindate}" pattern="yyyy-MM-dd HH:mm"/></p>
					</div>
				</div>
				<c:if test="${cv.status!='已付款'}">
					<c:if test="${cv.status!='已终止'}">
					<div class="col-md-3">
						<div class="form-group">
						    <label>&nbsp;&nbsp;处理人：</label>
							<p class="form-control-static">${cv.sysEmployeeByExecutorEid.ename}</p>
						</div>
					</div>
					</c:if>
				</c:if>
				
				
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
		<hr/>
		<div class="row">
				<div class="col-lg-1" style="margin-left: 10px;"><label>事由：</label></div>
				<div class="col-lg-6" style="margin-left: -40px;">
					<textarea readonly="readonly" style="font-size: 14px;"  class="form-control  input-lg">${cv.event }</textarea>
				</div>
				<div class="col-lg-5"></div>
			</div>
		<br/>
			<div class="row">
				<div class="col-lg-6"></div>
			
				<div class="col-lg-2">
					<div class="btn-group" role="group" aria-label="...">
					  <c:if test="${User.sysPosition.pid==4}">
					  		<button type="button" class="btn btn-default" data-toggle="modal" data-target="#myModal2" class="btn btn-default">审核进度</button>
					  </c:if>
					  <button type="button" class="btn btn-default" onclick="window.history.go(-1)"  class="btn btn-default">返回列表</button>
					</div>
				</div>
				
			</div>
			
	</form>
</div>

					<div class="modal fade" id="myModal2" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
						  <div class="modal-dialog " role="document">
						    <div class="modal-content">
						      <div class="modal-header">
						        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
						        <h4 class="modal-title" id="myModalLabel">审核进度</h4>
						      </div>
						      <div class="modal-body " >
						      <table class="table table-bordered table-hover text-center"  >
						      		<tr style="background-color: #999;" >
						      			<th width="9%" class="text-center">进度</th>
						      			<th width="19%" class="text-center">审核人</th>
						      			<th  width="22%" class="text-center">审核时间</th>
						      			<th width="20%" class="text-center">结果</th>
						      		</tr>
						      		<c:forEach items="${cv.bizCheckResults}" var="cr">
							      		<tr>
							      			<td><span class="glyphicon glyphicon-arrow-right"></span></td>
							      			<td>${cr.sysEmployee.ename} ( ${cr.sysEmployee.sysPosition.pname} )</td>
							      			<td><fmt:formatDate value="${cr.checkDate }" pattern="yyyy-MM-dd HH:mm"/></td>
							      			<td>${cr.result }</td>
							      		</tr>
						      		</c:forEach>
						      			<c:if test="${ !(cv.status eq '已拒绝'||cv.status eq '已付款'||cv.status eq '已终止')}">
								      		<tr>
								      			<td><span class="glyphicon glyphicon-arrow-right"></span></td>
								      			<td colspan="4"><label>下一级:</label>${cv.sysEmployeeByExecutorEid.ename }(${cv.sysEmployeeByExecutorEid.sysPosition.pname }) 未审核</td>
								      		</tr>
						      			</c:if>
						      			<c:if test="${(cv.status eq '已拒绝'||cv.status eq '已付款'||cv.status eq '已终止')}">
								      		<tr>
								      			<td><span class="glyphicon glyphicon-arrow-right"></span></td>
								      			<td colspan="4"><label>完成！</label></td>
								      		</tr>
						      			</c:if>
								</table>
						      	
						      </div>
						      <div class="modal-footer">
						        <button type="button" class=" btn btn-default"   data-dismiss="modal">关闭</button>
					
						      </div>
						    </div>
						  </div>
						</div>

<%@include file="indexbottm.jsp" %>