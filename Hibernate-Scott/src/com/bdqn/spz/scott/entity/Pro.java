/**
 * 
 */
package com.bdqn.spz.scott.entity;

import java.util.List;

/**
 * @author ʩ����
 * date 2017��12��11��
 * time ����4:42:53
 */
@SuppressWarnings("serial")
public class Pro implements java.io.Serializable{

	//��ĿID
	private Integer proId;
	
	//��Ŀ����
	private String proName;
	
	//Ա������
	private List<Emp> emps;

	public Integer getProId() {
		return proId;
	}

	public void setProId(Integer proId) {
		this.proId = proId;
	}

	public String getProName() {
		return proName;
	}

	public void setProName(String proName) {
		this.proName = proName;
	}

	public List<Emp> getEmps() {
		return emps;
	}

	public void setEmps(List<Emp> emps) {
		this.emps = emps;
	}
	
}
