package com.bdqn.oa.web;

import java.util.Map;

import com.bdqn.oa.entity.SysEmployee;
import com.bdqn.oa.service.ISysEmployeeService_z;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class SysEmployeeAction_z extends ActionSupport  {

	private ISysEmployeeService_z sysEmployeeService_z;
	private String ename;
	private String epassword;
	private String msg;
	
	//登录
	public String login() {
		
		SysEmployee sysEmployee=sysEmployeeService_z.emplogin(ename, epassword);
		
		System.out.println(sysEmployee==null);
		if(sysEmployee!=null) {
			Map<String, Object> session=ActionContext.getContext().getSession();
			session.put("User", sysEmployee);
		}else {
			System.out.println("null");
			msg="用户名或密码错误";
			return Action.ERROR;
		}
		
		return Action.SUCCESS;
	}
	//注销
	public String zx(){
		
		try {
			Map<String, Object> session=ActionContext.getContext().getSession();
			session.remove("User");
		} catch (Exception e) {
			e.printStackTrace();
			return "404";
		}
		
		return Action.SUCCESS;
	}
	
	
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getEpassword() {
		return epassword;
	}
    public void setEpassword(String epassword) {
		this.epassword = epassword;
	}
    public ISysEmployeeService_z getSysEmployeeService_z() {
		return sysEmployeeService_z;
	}
	public void setSysEmployeeService_z(ISysEmployeeService_z sysEmployeeService_z) {
		this.sysEmployeeService_z = sysEmployeeService_z;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	
}
