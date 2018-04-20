<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="indexTop.jsp"%>
<script type="text/javascript">
	function page_nav(frm, num) {
		if (typeof (frm) != 'object') {
			frm = document.forms[0];
		}
		frm[2].value = num;
		frm.submit();
	}
</script>
<div class="container-fluid">
	<br />
	<h3>请假列表</h3>
	<hr />

	<div class="row">
		<div class="col-md-12">
			<form class="form-inline" action="leaveListPaging.action" method="post" id="leaveListPaging">
				<div class="form-group">
					<label for="exampleInputEmail2">&nbsp;&nbsp; 开始时间：</label> <input
						type="date" class="form-control input-sm" id="exampleInputEmail2"
						name="leave.begindate"
						value="<fmt:formatDate value="${leave.begindate}" pattern="yyyy/mm/dd" />">
				</div>
				<div class="form-group">
					<label for="exampleInputName2">&nbsp;&nbsp;结束时间：</label> <input
						type="date" class="form-control input-sm" id="exampleInputName2"
						name="leave.closuredate"
						value="<fmt:formatDate value="${leave.closuredate}"/>">
				</div>
				<input type="hidden" name="paging.currentPageNo" value="1">
				<input type="hidden" name="paging.pageSize" value="3">
				<button type="submit" class="btn btn-primary">查询</button>
			</form>
		</div>
		<br />
		<br />
		<br />
		<div class="col-lg-12">
			<table class="table table-bordered table-hover text-center">
				<tr style="background-color: #337ab7; color: #FFFFFF;">
					<th width="5%" class="text-center">编号</th>
					<th width="15%" class="text-center">详情</th>
					<th width="15%" class="text-center">发起时间</th>
					<th width="20%" class="text-center">审批时间</th>
					<th width="10%" class="text-center">审批人</th>
					<th width="10%" class="text-center">审批状态</th>
					<th width="20%" class="text-center">操作</th>
				</tr>
				<c:forEach var="leave" items="${paging.list}">
					<tr>
						<td>${leave.id}</td>
						<td>${leave.sysEmployeeByProposerEid.ename}请假${leave.days}天</td>
						<td>${leave.begindate}</td>
						<td>${leave.closuredate}</td>
						<td>${leave.sysEmployeeByExecutorEid.ename}</td>
						<td>${leave.status}</td>
						<td><a href="selectleave.action?leave.id=${leave.id}" class="tooltip-test"
							data-toggle="tooltip" title="查看"> <span
								class="glyphicon glyphicon-search"></span>
						</a>&nbsp;&nbsp; <c:if
								test="${leave.sysEmployeeByExecutorEid.eid==User.eid}">
								<c:if test="${leave.status=='待审批'}">
									<a href="skipCheckLeave.action?leave.id=${leave.id}" class="tooltip-test"
										data-toggle="tooltip" title="审批"><span
										class="glyphicon glyphicon-pencil"></span>
									</a>
								</c:if>
							</c:if></td>
					</tr>
				</c:forEach>
			</table>
		</div>
		<div class="col-lg-12" style="margin-top: -20px;">
			<nav aria-label="Page navigation pagination-lg">
				<ul class="pagination ">
					<li><a href="javascript:page_nav(document.forms[0],1);" aria-label="Previous"> <span
							aria-hidden="true">首页&laquo;</span>
					</a></li>
					<li><a href="javascript:page_nav(document.forms[0],${paging.currentPageNo}-1);" aria-label="Previous"> <span
							aria-hidden="true">上一页&lsaquo;</span>
					</a></li>
					<li class="active"><a href="#" class="active">${paging.currentPageNo}/${paging.totalPageCount}</a></li>
					<li><a href="javascript:page_nav(document.forms[0],${paging.currentPageNo}+1);" aria-label="Next"> <span
							aria-hidden="true">&rsaquo;下一页</span>
					</a></li>
					<li><a href="javascript:page_nav(document.forms[0],${paging.totalPageCount});" aria-label="Next"> <span
							aria-hidden="true">&raquo;尾页</span>
					</a></li>
				</ul>
			</nav>
		</div>
	</div>
</div>
<script>
	$(function() {
		$("[data-toggle='tooltip']").tooltip();
	});
</script>
<%@include file="indexbottm.jsp"%>