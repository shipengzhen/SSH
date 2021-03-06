package com.bdqn.spz.scott.entity;

import java.util.List;

/**
 * 部门实体类
 * @author 施鹏振
 */
@SuppressWarnings("serial")
public class Dept implements java.io.Serializable {
	
	//部门编号
	private Integer deptNo;
	//部门名称
	private String deptName;
	//部门地址
	private String location;
	//员工集合
	private List<Emp> emps;
	//员工对象
	private Emp emp;
	
	/**
	 * 部门编号
	 * @return Integer deptNo
	 */
	public Integer getDeptNo() {
		return deptNo;
	}
	/**
	 * 部门编号
	 * @param deptNo
	 */
	public void setDeptNo(Integer deptNo) {
		this.deptNo = deptNo;
	}
	/**
	 * 部门名称
	 * @return String deptName
	 */
	public String getDeptName() {
		return deptName;
	}
	/**
	 * 部门名称
	 * @param deptName
	 */
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	/**
	 * 部门地址
	 * @return String location
	 */
	public String getLocation() {
		return location;
	}
	/**
	 * 部门地址
	 * @param location
	 */
	public void setLocation(String location) {
		this.location = location;
	}
	/**
	 * 员工集合
	 * @return List<Emp> emps
	 */
	public List<Emp> getEmps() {
		return emps;
	}
	/**
	 * 员工集合
	 * @param emps
	 */
	public void setEmps(List<Emp> emps) {
		this.emps = emps;
	}
	
	/**
	 * 员工对象
	 * @return Emp
	 */
	public Emp getEmp() {
		return emp;
	}
	/**
	 * 员工对象
	 * @param emp void
	 */
	public void setEmp(Emp emp) {
		this.emp = emp;
	}
	
	public Dept() {
		super();
		// TODO 自动生成的构造函数存根
	}
	
	public Dept(Integer deptNo, String deptName) {
		super();
		this.deptNo = deptNo;
		this.deptName = deptName;
	}
	public Dept(Integer deptNo, String deptName, String location) {
		super();
		this.deptNo = deptNo;
		this.deptName = deptName;
		this.location = location;
	}
	public Dept(Integer deptNo, String deptName, String location, List<Emp> emps) {
		super();
		this.deptNo = deptNo;
		this.deptName = deptName;
		this.location = location;
		this.emps = emps;
	}
}
