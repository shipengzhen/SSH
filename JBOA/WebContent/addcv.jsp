<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="indexTop.jsp" %>
<script type="text/javascript" src="js/addCV.js"></script>

		<div class="container-fluid" >
			<br />
			<h4>新增报销单</h4>
			<hr/>
			<form action="addcxd.action" method="post" name="claimForm" class="form-horizontal">
				<div class="row">
						   <div class="col-lg-2">		
							  <div class="form-group" style="padding: 0px;">
							    <label class="col-xs-4 control-label">姓名:</label>
							    <div class=" col-xs-8" style="padding: 0px;">
							    
							      <input type="text"  value="${User.ename}" class="form-control input-sm" readonly>
							      							
							    </div>
							  </div>
						  </div>
						  
						<div class="col-lg-2">		
							  <div class="form-group" style="padding: 0px;">
							    <label class="col-xs-4 control-label">时间:</label>
							    <div class=" col-xs-8" style="padding: 0px;">
							    
							      <input type="date" name="bizClaimVoucher.begindate" id="shijian"  class="form-control input-sm" readonly>	
							    
							    </div>
							  </div>
						  </div>
						  <div class="col-lg-2">		
							  <div class="form-group" style="padding: 0px;">
							    <label  class="col-xs-4 control-label">金额:</label>
							    <div class=" col-xs-8" style="padding: 0px;">
							      <input id="totalAccount" type="email" name="bizClaimVoucher.moeny"   class="form-control input-sm"readonly>					
							    	<input type="hidden" id="rowNumber" name="rowNumber" value="0"/>
							    </div>
							  </div>
						  </div>
						  <input type="text" name="bizClaimVoucher.status"  id="status" value="新创建" class="form-control sr-only" readonly>
						  <div class="col-lg-2">
						 	&nbsp;&nbsp;
						  	<!-- 模态框 -->
							<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal">
							   添加子项
							</button>
						   </div>
					</div>
				
			
						<div class="row">
							<div class="col-lg-10">
							
							<table id="myTable" class="table table-bordered table-hover text-center">
							  <tr style="background-color: #337ab7; color: #FFFFFF;">
							  	<th width="10%" class="text-center">#</th>
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
							  
							</table>
							
							</div>
							<div class="col-lg-2"></div>
						</div>
						
						<div class="row " >
							<div class="col-md-1">
								<label >事由：</label>
							</div>
							<div class="col-md-6" style="margin-left: -50px;">
								<textarea name="bizClaimVoucher.event"  class="form-control" rows="2"></textarea>
							</div>
						</div>
						<br />
						<div class="row">
							
							<div class="col-lg-4 text-right">
								<input type="button"  nd="1" value="保存 " class="submit001 btn btn-primary" />
							</div>
							<div class="col-lg-8">
								<input type="button"  nd="2" value="提交 " class="submit001 btn btn-primary" />
							</div>
						</div>

					</form>
				
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
						        <button type="button" class=" btn btn-default"   data-dismiss="modal">关闭</button>
					
						      </div>
						    </div>
						  </div>
						</div>
	</div>
		
		<script>
			$(function () { $("[data-toggle='tooltip']").tooltip(); });
		</script>
		
	<%@include file="indexbottm.jsp" %>
		
		
		
		