package com.bdqn.spz.scott.entity;

import java.util.Date;
import java.util.List;

/**
 * Ա��ʵ����
 * @author ʩ����
 * date 2017��12��11��
 * time ����11:46:38
 */
@SuppressWarnings("serial")
public class Emp implements java.io.Serializable{

	// Ա�����
	private Integer empNo;
	// Ա������
	private String empName;
	// ְλ
	private String job;
	// ����
	private Double salary;
	// ��ְʱ��
	private Date hireDate;
	// ��������
	private Dept dept;
	//��Ŀ����
	private List<Pro> pros;
	//����id(���)
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