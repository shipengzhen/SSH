package com.bdqn.spz.scott.entity;

public class DeptSalary {
	private String deptName;//��������
	private Double avgSalary;//����ƽ������
	
	public DeptSalary(String deptName, Double avgSalary) {
		super();
		this.deptName = deptName;
		this.avgSalary = avgSalary;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public Double getAvgSalary() {
		return avgSalary;
	}
	public void setAvgSalary(Double avgSalary) {
		this.avgSalary = avgSalary;
	}
	
}