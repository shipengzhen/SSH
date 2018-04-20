package com.bdqn.spz.scott.entity;

import java.util.List;

/**
 * ����ʵ����
 * @author ʩ����
 */
@SuppressWarnings("serial")
public class Dept implements java.io.Serializable {
	
	//���ű��
	private Integer deptNo;
	//��������
	private String deptName;
	//���ŵ�ַ
	private String location;
	//Ա������
	private List<Emp> emps;
	//Ա������
	private Emp emp;
	
	/**
	 * ���ű��
	 * @return Integer deptNo
	 */
	public Integer getDeptNo() {
		return deptNo;
	}
	/**
	 * ���ű��
	 * @param deptNo
	 */
	public void setDeptNo(Integer deptNo) {
		this.deptNo = deptNo;
	}
	/**
	 * ��������
	 * @return String deptName
	 */
	public String getDeptName() {
		return deptName;
	}
	/**
	 * ��������
	 * @param deptName
	 */
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	/**
	 * ���ŵ�ַ
	 * @return String location
	 */
	public String getLocation() {
		return location;
	}
	/**
	 * ���ŵ�ַ
	 * @param location
	 */
	public void setLocation(String location) {
		this.location = location;
	}
	/**
	 * Ա������
	 * @return List<Emp> emps
	 */
	public List<Emp> getEmps() {
		return emps;
	}
	/**
	 * Ա������
	 * @param emps
	 */
	public void setEmps(List<Emp> emps) {
		this.emps = emps;
	}
	
	/**
	 * Ա������
	 * @return Emp
	 */
	public Emp getEmp() {
		return emp;
	}
	/**
	 * Ա������
	 * @param emp void
	 */
	public void setEmp(Emp emp) {
		this.emp = emp;
	}
	
	public Dept() {
		super();
		// TODO �Զ����ɵĹ��캯�����
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
