package com.bdqn.oa.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * 部门表
 * @author lizhen
 * @date 2017年12月26日
 */
public class SysDepartment implements java.io.Serializable {

	// Fields

	private Integer did;
	private String dname;
	private Set sysEmployees = new HashSet(0);

	// Constructors

	/** default constructor */
	public SysDepartment() {
	}

	/** minimal constructor */
	public SysDepartment(Integer did, String dname) {
		this.did = did;
		this.dname = dname;
	}

	/** full constructor */
	public SysDepartment(Integer did, String dname, Set sysEmployees) {
		this.did = did;
		this.dname = dname;
		this.sysEmployees = sysEmployees;
	}

	// Property accessors

	public Integer getDid() {
		return this.did;
	}

	public void setDid(Integer did) {
		this.did = did;
	}

	public String getDname() {
		return this.dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public Set getSysEmployees() {
		return this.sysEmployees;
	}

	public void setSysEmployees(Set sysEmployees) {
		this.sysEmployees = sysEmployees;
	}

}