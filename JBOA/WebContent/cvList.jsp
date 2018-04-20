<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

	<%@include file="indexTop.jsp" %>
	<div class="container-fluid">
			<br />
			<h4>报销单列表</h4>
			<hr/>
			
			<div class="row">
				<div class="col-md-12">
			
					<form class="form-inline" method="post"  <c:if test="${User.sysPosition.pid==4}">
																action="findAllfy.action" </c:if>
															 <c:if test="${User.sysPosition.pid==2||User.sysPosition.pid==1||User.sysPosition.pid==3}">
																action="getVouList.action" </c:if>>
					  <div class="form-group">
					    <label for="exampleInputName2">报销单状态：</label>
					    
					   <select name="bizClaimVoucher.status" class="form-control input-sm">
					   <!-- <c:if test="${page.t.status=='全部'}">selected="selected"</c:if>  -->
						  <option value="">全部</option>
						  <option value="新创建" <c:if test="${pcv.t.status=='新创建'}">selected="selected"</c:if> >新创建</option>
						  <option value="已提交" <c:if test="${pcv.t.status=='已提交'}">selected="selected"</c:if>>已提交</option>
						  <option value="已打回" <c:if test="${pcv.t.status=='已打回'}">selected="selected"</c:if>>已打回</option>
						  <option value="以付款" <c:if test="${pcv.t.status=='以付款'}">selected="selected"</c:if>>以付款</option>
						  <option value="以终止" <c:if test="${pcv.t.status=='以终止'}">selected="selected"</c:if>>以终止</option>
						</select>
						
					  </div>
					  <div class="form-group">
					    <label for="exampleInputEmail2">&nbsp;&nbsp; 开始时间：</label>
					   
					    <input name="bizClaimVoucher.begindate"  value="<s:property value="#request.pcv.t.begindate"/>" type="date" class="form-control input-sm" >
					  </div>
					   <div class="form-group">
					    <label for="exampleInputName2">&nbsp;&nbsp;结束时间：</label>
					    <input name="pageNo" value="1" class="sr-only">
					    <input name="bizClaimVoucher.finishdate"  value="<s:property value="#request.pcv.t.finishdate"/>" type="date" class="form-control input-sm" >
					  
					  </div>
					  <button type="submit" class="btn btn-primary" >查询</button >
					</form>
				</div>
				<br />
				<br />
				<br />
				<div class="col-lg-12" >
					<table class="table table-bordered table-hover ">
					  <tr style="background-color: #337ab7; color: #FFFFFF;" >
					  	<th width="6%" class="text-center">编号</th>
					  	<th width="18%" class="text-center">填报日期</th>
					  	<th width="10%"class="text-center">填报人</th>
					  	<th width="10%"class="text-center">总金额</th>
					  	<th width="10%"class="text-center">状态</th>
					  	<th width="10%"class="text-center">处理人</th>
					  	<th width="20%" style="padding-left: 100px;">操作 </th>
					  </tr>
					  
			
					  <c:forEach items="${pcv.list}" var="cvt" >
						  <tr>
						  	<td class="text-center">${cvt.id}</td>
						  	<td class="text-center"><fmt:formatDate value="${cvt.begindate}" pattern="yyyy-MM-dd HH:mm"/></td>
						  	<td class="text-center">${cvt.sysEmployeeByProposerEid.ename}</td>
						  	<td class="text-center">${cvt.moeny}</td>
						  	<td class="text-center">${cvt.status }</td>
						 	<td class="text-center">
						 		<c:if test="${cvt.sysEmployeeByExecutorEid.ename==''||cvt.sysEmployeeByExecutorEid.ename==null}">无</c:if>	
						 		${cvt.sysEmployeeByExecutorEid.ename}
						 	</td>
						 	<td style="padding-left: 100px;">
						 		<a href="selectCv.action?cvId=${cvt.id}" class="tooltip-test" data-toggle="tooltip" title="查看" >
						 				<span class="glyphicon glyphicon-search" ></span>
						 		</a>
						 		<c:if test="${cvt.status=='新创建'||cvt.status=='已打回'}">
						 		&nbsp;&nbsp;
							 		<c:if test="${User.sysPosition.pid==4}">
								 		<a  href="updateCv.action?cvId=${cvt.id}"   class="tooltip-test" data-toggle="tooltip" title="修改"   >
								 				<span class="glyphicon glyphicon-pencil"></span>
								 		</a>
							 		</c:if>
						 		</c:if>
						 		
							 		<c:if test="${User.sysPosition.pid==2||User.sysPosition.pid==1||User.sysPosition.pid==3}">
								 		&nbsp;&nbsp;
								 		<a href="getVoucher.action?cvId=${cvt.id}" class="tooltip-test" data-toggle="tooltip" title="审批">
								 				<span class="glyphicon glyphicon-pencil"></span>
								 		</a>
							 		</c:if>
						 		<c:if test="${cvt.status=='已付款'}">
							 		&nbsp;&nbsp;
							 		<a href="#" class="tooltip-test" data-toggle="tooltip" title="以完成">
							 			<span class="glyphicon glyphicon-ok"></span>
							 		</a>
							 	</c:if>
						 	</td>
						  </tr>
						  </c:forEach>
					
					</table>
				</div>
					<div class="col-lg-12" style="margin-top: -20px;">
				
						 <nav aria-label="Page navigation pagination-lg" >
						  <ul class="pagination ">
						    <li>
						      <a href="javascript:page(document.forms[0],1)" aria-label="Previous">
						        <span aria-hidden="true">&laquo;</span>
						      </a>
						    </li>
						    <li>
						      <a href="javascript:page(document.forms[0],${pcv.currentPageNo-1})" aria-label="Previous">
						        <span aria-hidden="true">&lsaquo;</span>
						      </a>
						    </li>
						    <li class="active"><a class="active"><s:property value="#request.pcv.currentPageNo"/>/<s:property value="#request.pcv.totalPageCount"/></a></li>
						    <li>
						      <a href="javascript:page(document.forms[0],${pcv.currentPageNo+1})" aria-label="Next" >
						        <span aria-hidden="true">&rsaquo;</span>
						      </a>
						    </li>
						    <li>
						      <a href="javascript:page(document.forms[0],<s:property value="#request.pcv.totalPageCount"/>)" aria-label="Next">
						        <span aria-hidden="true">&raquo;</span>
						      </a>
						    </li>
						  </ul>
						</nav>	
												
					</div>
					
			</div>
		</div>
		<script>
			$(function () { $("[data-toggle='tooltip']").tooltip(); });
			//分页方法
			function page(frm,num){
				frm.pageNo.value = num;		//给当前pageNo 赋值
				frm.submit();				//提交
			}
		
			load();
			
		</script>
		
<%@include file="indexbottm.jsp" %>