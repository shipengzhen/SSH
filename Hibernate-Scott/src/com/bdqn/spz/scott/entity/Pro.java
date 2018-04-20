/**
 * 
 */
package com.bdqn.spz.scott.entity;

import java.util.List;

/**
 * @author 施鹏振
 * date 2017年12月11日
 * time 下午4:42:53
 */
@SuppressWarnings("serial")
public class Pro implements java.io.Serializable{

	//项目ID
	private Integer proId;
	
	//项目名称
	private String proName;
	
	//员工集合
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
