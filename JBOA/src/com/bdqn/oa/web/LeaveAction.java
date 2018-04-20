/**
 * 
 */
package com.bdqn.oa.web;

import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.bdqn.oa.entity.SysEmployee;
import com.bdqn.oa.entity.SysLeave;
import com.bdqn.oa.service.ILeaveService;
import com.bdqn.oa.util.Paging;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @���� oa
 * @���� ʩ����
 * @�������� 2017��12��27��
 * @����ʱ�� ����2:10:24
 */
@SuppressWarnings("serial")
public class LeaveAction extends ActionSupport {

	public ILeaveService leaveService;

	public ILeaveService getLeaveService() {
		return leaveService;
	}

	public void setLeaveService(ILeaveService leaveService) {
		this.leaveService = leaveService;
	}

	private SysLeave leave;

	public SysLeave getLeave() {
		return leave;
	}

	public void setLeave(SysLeave leave) {
		this.leave = leave;
	}

	private Paging<SysLeave> paging;
	
	public Paging<SysLeave> getPaging() {
		return paging;
	}

	public void setPaging(Paging<SysLeave> paging) {
		this.paging = paging;
	}

	//��ת�������ҳ��
	public String skipAddLeave(){
		try {
			Map<String,Object> session=ActionContext.getContext().getSession();
			SysEmployee employee=(SysEmployee) session.get("User");
			
			System.out.println("==================="+employee.getEid());
			
			Object[] objects=leaveService.findEmployeeIsDepartmentManager(employee.getSysDepartment().getDid());
			HttpServletRequest request=ServletActionContext.getRequest();
			request.setAttribute("departmentManagerId",objects[0]);
			request.setAttribute("departmentManagerName",objects[1]);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	// �������
	public String addLeave() {
		try {
			System.out.println(leave.getLeavetype());
			System.out.println(leave.getBegindate());
			System.out.println(leave.getClosuredate());
			System.out.println(leave.getDays());
			System.out.println(leave.getEvent());
			System.out.println(leave.getSysEmployeeByExecutorEid().getEid());
			leave.setStatus("������");
			
			Map<String,Object> session=ActionContext.getContext().getSession();
			SysEmployee employee=(SysEmployee) session.get("User");
		
			leave.setSysEmployeeByProposerEid(employee);
			System.out.println(leave.getSysEmployeeByExecutorEid().getEname());
			if (leaveService.saveOrUpdateLeave(leave)) {
				return SUCCESS;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ERROR;
	}

	//��ת����б�ҳ��
	public String skipLeaveList(){
		try {
			Map<String,Object> session=ActionContext.getContext().getSession();
			SysEmployee employee=(SysEmployee) session.get("User");
			SysLeave leave=new SysLeave();
			leave.setSysEmployeeByProposerEid(employee);
			Paging<SysLeave> paging=new Paging<SysLeave>();
			paging.setCurrentPageNo(1);
			paging.setPageSize(3);
			paging.setT(leave);
			
			this.paging=leaveService.findLeavesByPaging(paging);
			
			//HttpServletRequest request=ServletActionContext.getRequest();
			//request.setAttribute("paging",paging);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	
	//��ѯ������ҳ����
	public String leaveListPaging(){
		try {
			Map<String,Object> session=ActionContext.getContext().getSession();
			SysEmployee employee=(SysEmployee) session.get("User");
			leave.setSysEmployeeByProposerEid(employee);
			paging.setT(leave);
			paging=leaveService.findLeavesByPaging(paging);
			//HttpServletRequest request=ServletActionContext.getRequest();
			//request.setAttribute("paging",paging);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	//��ѯ�������
	public String selectleave(){
		try {
			leave=leaveService.findLeaveInformation(leave.getId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	//��ת������ҳ��
	public String skipCheckLeave(){
		try {
			leave=leaveService.findLeaveInformation(leave.getId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	//������
	public String checkLeave(){
		try {
			Map<String,Object> session=ActionContext.getContext().getSession();
			SysEmployee employee=(SysEmployee) session.get("User");
			leave.getLeaveResult().setLeave_id(leave.getId());
			leave.getLeaveResult().setShdate(new Date());
			if (leaveService.updateLeave(leave)) {
				return SUCCESS;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ERROR;
	}
}
