package com.bdqn.spz.scott.entity;

import java.util.Date;
import java.util.List;

/**
 * 员工实体类
 * @author 施鹏振
 * date 2017年12月11日
 * time 上午11:46:38
 */
@SuppressWarnings("serial")
public class Emp implements java.io.Serializable{

	// 员工编号
	private Integer empNo;
	// 员工姓名
	private String empName;
	// 职位
	private String job;
	// 工资
	private Double salary;
	// 入职时间
	private Date hireDate;
	// 所属部门
	private Dept dept;
	//项目集合
	private List<Pro> pros;
	//部门id(外键)
	private Integer deptNo;
	
	
	public Integer getEmpNo() {
		return empNo;
	}
	public void setEmpNo(Integer empNo) {
		this.empNo = empNo;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	public Date getHireDate() {
		return hireDate;
	}
	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}
	public Dept getDept() {
		return dept;
	}
	public void setDept(Dept dept) {
		this.dept = dept;
	}
	public List<Pro> getPros() {
		return pros;
	}
	public void setPros(List<Pro> pros) {
		this.pros = pros;
	}
	public Integer getDeptNo() {
		return deptNo;
	}
	public void setDeptNo(Integer deptNo) {
		this.deptNo = deptNo;
	}
}
