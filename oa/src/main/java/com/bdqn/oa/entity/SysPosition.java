package com.bdqn.oa.entity;

import java.util.HashSet;
import java.util.Set;


/**
 * 职位表
 * @author lizhen
 * @date 2017年12月26日
 */
public class SysPosition implements java.io.Serializable {

	// Fields

	private Integer pid;
	private String pname;
	private Set sysEmployees = new HashSet(0);

	// Constructors

	/** default constructor */
	public SysPosition() {
	}

	/** minimal constructor */
	public SysPosition(Integer pid, String pname) {
		this.pid = pid;
		this.pname = pname;
	}

	/** full constructor */
	public SysPosition(Integer pid, String pname, Set sysEmployees) {
		this.pid = pid;
		this.pname = pname;
		this.sysEmployees = sysEmployees;
	}

	// Property accessors

	public Integer getPid() {
		return this.pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public String getPname() {
		return this.pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public Set getSysEmployees() {
		return this.sysEmployees;
	}

	public void setSysEmployees(Set sysEmployees) {
		this.sysEmployees = sysEmployees;
	}

}