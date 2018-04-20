<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="zh-CN">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>OA办公系统</title>
     <script type="text/javascript" src="js/jquery-1.12.4.js" ></script>
	 <script type="text/javascript" src="js/bootstrap.js" ></script>
    <link href="css/bootstrap.css" rel="stylesheet">
    <link href="css/dashboard.css" rel="stylesheet">
	<style type="text/css">
		
		.list{margin-bottom: 0px;}
		*{ padding: 0px; }
		
	</style>
	
  </head>

  <body>
  	<div>
    <nav class="navbar navbar-default navbar-fixed-top" >
      <div class="container-fluid">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="welcome.jsp"><span class="glyphicon glyphicon-home"></span>&nbsp;&nbsp;<span>自动化办公系统</span></a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav navbar-right">
            <li><a href="#"><span class="glyphicon glyphicon-log-in"> </span>&nbsp;&nbsp;退出</a></li>
          </ul>
        </div>
      </div>
    </nav>
    <div class="container-fluid" >
      <div class="row" >
        <div class="col-sm-3 col-md-2 sidebar">
           <div class="panel-group nav-sidebar list" id="accordion" role="tablist">
           	<!--用户名 -->
           	
				    <div class="panel panel-default list">
				      <div class="panel-heading"  role="tab" id="collapseListGroupHeading1">
				        <h4 class="panel-title" >
				          <span  class="collapsed"  data-toggle="collapse" data-parent="#accordion" href="#collapseListGroup"  aria-controls="collapseListGroup1">
				            	<span class="glyphicon glyphicon-cog"></span> 报销单管理
				          </span>
				        </h4>
				      </div>
				      
				      <div id="collapseListGroup" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="collapseListGroupHeading1">
				        <ul class="list-group" >
				          <li class="list-group-item " href="#">&nbsp;&nbsp;&nbsp;
				          	<span class="glyphicon glyphicon-th"></span> 
				          	<a href="cvList.jsp">查看报销单</a>
				          </li>
				          <li class="list-group-item" href="#">&nbsp;&nbsp;&nbsp;
				          	<span class="glyphicon glyphicon-th"></span>
				          	<a href="addcv.jsp">添加报销单</a>
				          </li>
				        </ul>
				      </div>
				    </div>
				    <!--  2-->
				    <div class="panel panel-default list">
				      <div class="panel-heading" role="tab" id="collapseListGroupHeading2">
				        <h4 class="panel-title">
				          <span class="collapsed" data-parent="#accordion" data-toggle="collapse" href="#collapseListGroup2"  aria-controls="collapseListGroup2">
				            	<span class="glyphicon glyphicon-cog "></span> 请假管理
				          </span>
				        </h4>
				      </div>
				      
				      <div id="collapseListGroup2" class="panel-collapse collapse " role="tabpanel" aria-labelledby="collapseListGroupHeading2">
				        <ul class="list-group" >
				          <li class="list-group-item " >&nbsp;&nbsp;&nbsp;
				          	<span class="glyphicon glyphicon-th">
				          	</span> <a href="skipLeaveList.action">查看请假</a>
				          </li>
				          <li class="list-group-item">&nbsp;&nbsp;&nbsp;
				          	<span class="glyphicon glyphicon-th">
				          	</span> <a href="skipAddLeave.action">申请请假</a>
				          </li>
				          
				        </ul>
				      </div>
				    </div>
				    <!--3 -->
				    <div class="panel panel-default list">
				      <div class="panel-heading" role="tab" id="collapseListGroupHeading4">
				        <h4 class="panel-title">
				          <a class="collapsed" data-parent="#accordion" data-toggle="collapse" href="#collapseListGroup4"  aria-controls="collapseListGroup4">
				            	<span class="glyphicon glyphicon-cog"></span> 统计中心
				          </a>
				        </h4>
				      </div>
				      
				      <div id="collapseListGroup4" class="panel-collapse collapse " role="tabpanel" aria-labelledby="collapseListGroupHeading4">
				        <ul class="list-group" >
				          <li class="list-group-item " >&nbsp;&nbsp;&nbsp;
				          	<span class="glyphicon glyphicon-th">
				          	</span> <a href="#">请假统计</a>
				          </li>
				          <li class="list-group-item">&nbsp;&nbsp;&nbsp;
				          	<span class="glyphicon glyphicon-th">
				          	</span> <a href="#">报销单统计</a>
				          </li>
				          
				        </ul>
				      </div>
				    </div>
					<!--  4-->
				    <div class="panel panel-default list">
				      <div class="panel-heading" role="tab" id="collapseListGroupHeading3">
				        <h4 class="panel-title">
				          <a class="collapsed" data-parent="#accordion" data-toggle="collapse" href="#collapseListGroup3"  aria-controls="collapseListGroup3">
				            	<span class="glyphicon glyphicon-cog"></span> 信息中心
				          </a>
				        </h4>
				      </div>
				 
				      <div id="collapseListGroup3" class="panel-collapse collapse " role="tabpanel" aria-labelledby="collapseListGroupHeading3">
				        <ul class="list-group" >
				          <li class="list-group-item " >&nbsp;&nbsp;&nbsp;
				          	<span class="glyphicon glyphicon-th">
				          	</span> <a href="#">信息中心1</a>
				          </li>
				          <li class="list-group-item">&nbsp;&nbsp;&nbsp;
				          	<span class="glyphicon glyphicon-th">
				          	</span> <a href="#">信息中心2</a>
				          </li>
				          
				        </ul>
				      </div>
				    </div>
				  </div>
				  
				  </div>
				  
       </div>
       </div>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2">
        	
