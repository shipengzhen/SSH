/**
 * 
 */
package com.spz.bdqn.house.action;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @���� bdqn_house
 * @���� ʩ����
 * @�������� 2017��12��20��
 * @����ʱ�� ����1:32:10
 */
@SuppressWarnings("serial")
public class DateConvertAction extends ActionSupport{

	private Date timeDate;
	public Date getTimeDate() {
		return timeDate;
	}
	public void setTimeDate(Date timeDate) {
		this.timeDate = timeDate;
	}
	
	public String execute(){
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("name","spz");
		System.out.println(timeDate);
		return SUCCESS;
	}
}
