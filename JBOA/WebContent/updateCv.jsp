<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
	<%@include file="indexTop.jsp" %>

<script type="text/javascript" src="js/updateCV.js"></script>
<div class="container-fluid">
	<br />
	<h4>基本信息</h4>
	<hr/>
		<form class="form-inline" name="claimForm" action="updateCvd.action">
			<div class="row">
				<div class="col-md-3">
					<div class="form-group">
					    <label>&nbsp;&nbsp; 填写人：</label>
					    <input type="hidden" id="rowNumber" name="rowNumber" value="${cd.size()}"/>	
					     <input type="hidden"  name="bizClaimVoucher.id" value="${cv.id}"/>	
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
					<input type="hidden" id="status" name="bizClaimVoucher.status" value="${cv.status}"/>	
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
					    <input type="hidden" name="bizClaimVoucher.moeny" id="totalAccount" value="${cv.moeny}"/>	
					     <p id="totalAccount2" class="form-control-static">${cv.moeny }</p>
					</div>
				</div>
				<div class="col-md-3">
					<div class="form-group">
						<label>&nbsp;&nbsp;创建时间：</label>
						<p class="form-control-static"><fmt:formatDate value="${cv.begindate}" pattern="yyyy-MM-dd HH:mm"/></p>
					</div>
				</div>
				<div class="col-md-2">
					<div class="form-group">
					    <label>&nbsp;&nbsp;处理人：</label>
						<p class="form-control-static">${cv.sysEmployeeByExecutorEid.ename }</p>
					</div>
				</div>

			</div>
		<hr />
		
			<div class="row">
				<div class="col-lg-9">
					<table id="myTable" class="table table-bordered table-hover  text-center">
						<tr>
							<th width="8%" class="text-center">#</th>
							<th width="20%" class="text-center">项目类型</th>
							<th width="10%" class="text-center">项目金额</th>
							<th width="40%" class="text-center">费用说明</th>
							<th class="text-center">操作</th>
						</tr>
						
						<tr class="sr-only">
								<td><span style="color:#337ab7" class="glyphicon glyphicon-list-alt"></span></td>
								<td></td>
							  	<td></td>
							 	<td></td>
							 	<td>
							 		<a href="#" class="tooltip-test" data-toggle="tooltip" title="删除">
							 			<span class="glyphicon glyphicon-trash"></span>
							 		</a>
							 	</td>
						</tr>
						 
						<c:forEach var="cd" items="${cd}" varStatus="k">
						<tr>
							<td><span style="color:#337ab7" class="glyphicon glyphicon-list-alt"></span></td>
							<td>
								<input id="id${k.index}" type="text" class="sr-only" value="${cd.id}" name="bizCvDetailly[${k.index}].id">
								<input id="item${k.index}" type="text" class="sr-only" value="${cd.item}" name="bizCvDetailly[${k.index}].item">
								${cd.item}
							</td>
							<td>
								<input id="acount${k.index}" type="text"  class="sr-only"  value="${cd.acount}" name="bizCvDetailly[${k.index}].acount" />
								${cd.acount}
							</td>
							<td>
								<input  id="des${k.index}" type="text"  class="sr-only"   value="${cd.des}" name="bizCvDetailly[${k.index}].des" />
								${cd.des}
							</td>
							<td>
							 	<a href="#" id="DelRow${k.index}"  onclick="delRow(${k.index})"  class='tooltip-test btn-del' data-toggle='tooltip' title='删除'>
							 		<span  ng="${cd.id}"   class="ll glyphicon glyphicon-trash"></span>
							 	</a>
					
							</td>
						</tr>
						</c:forEach>
					</table>
				</div>
				<div class="col-lg-3">	<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal">
							   添加子项
				</button>
				</div>
			</div>
		<hr />	
			<div class="row">
				<div class="col-lg-1" style="margin-left: 10px;"><label>事由：</label></div>
				<div class="col-lg-6" style="margin-left: -40px;">
					<textarea name="bizClaimVoucher.event" class="form-control  input-lg">${cv.event }</textarea>
				</div>
				<div class="col-lg-5"></div>
			</div>
		<br />
			<div class="row">
				<div class="col-lg-8"></div>
				<div class="btn-group" role="group" aria-label="...">
					  <button type="button" nd="1" class="submit002  btn btn-default">保存</button>
					  <button type="button" nd="2" class="submit002 btn btn-default">提交</button>
					  <button type="button" onclick="window.history.go(-1)" class="btn btn-default">返回</button>
				</div>
			</div>
	</form>
</div>


					<!-- Modal -->
					<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
						  <div class="modal-dialog" role="document">
						    <div class="modal-content">
						      <div class="modal-header">
						        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
						        <h4 class="modal-title" id="myModalLabel">添加子项</h4>
						      </div>
						      <div class="modal-body">
						        	
						        	<form>
						        	 <div class="form-group">
							            <label  class="control-label">项目类别:</label>
							            <select name="itemName" id="itemName" class="form-control">
										  <option value="城市交通费">城市交通费</option>
										  <option value="住所费">住所费</option>
										  <option value="餐饮费">餐饮费</option>
										  <option value="保险费">保险费</option>
										</select>
							          </div>
							          <div class="form-group">
							            <label  class="control-label">项目金额:</label>
							            <input type="text" id="itemMoney" class="form-control">
							            <span id="span1" style="color:red;" class="help-block"></span>
							          </div>
							          
							          <div class="form-group">
							            <label class="control-label">项目说明:</label>
							            <textarea id="itemDoc" class="form-control"></textarea>
							            <span id="span2" style="color:red;" class="help-block"></span>
							          </div>
						        	</form>
						        	
						      </div>
						      <div class="modal-footer">
						        <button type="button" class=" btn btn-default"  id="modelclose" data-dismiss="modal">关闭</button>
						        <button type="button" class=" btn btn-primary" id="modelAdd" >保存</button>
						      </div>
						    </div>
						  </div>
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
						      		至少有一条
						      </div>
						      <div class="modal-footer">
						        <button type="button" class=" btn btn-default"    data-dismiss="modal">关闭</button>
					
						      </div>
						    </div>
						  </div>
						</div>
				
					 
		<script>
			var i=parseInt(document.getElementById("rowNumber").value);
			var rowNumber=parseInt(document.getElementById("rowNumber").value);
			var totalAccount =(document.getElementById("totalAccount").value);
			
			$(function () { $("[data-toggle='tooltip']").tooltip(); });
		</script>
<%@include file="indexbottm.jsp" %>					 