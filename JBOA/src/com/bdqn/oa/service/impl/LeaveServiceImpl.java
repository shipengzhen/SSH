/**
 * 
 */
package com.bdqn.oa.service.impl;

import java.util.Date;

import com.bdqn.oa.dao.ILeaveDao;
import com.bdqn.oa.entity.SysEmployee;
import com.bdqn.oa.entity.SysLeave;
import com.bdqn.oa.service.ILeaveService;
import com.bdqn.oa.util.Paging;

/**
 * @���� oa
 * @���� ʩ����
 * @�������� 2017��12��27��
 * @����ʱ�� ����10:57:58
 */
public class LeaveServiceImpl implements ILeaveService {
	
	private ILeaveDao leaveDao;

	public ILeaveDao getLeaveDao() {
		return leaveDao;
	}

	public void setLeaveDao(ILeaveDao leaveDao) {
		this.leaveDao = leaveDao;
	}

	/* ���� Javadoc��
	 * @see com.bdqn.oa.service.leave.ILeaveService#saveOrUpdateLeave(com.bdqn.oa.entity.SysLeave)
	 */
	@Override
	public boolean saveOrUpdateLeave(SysLeave leave) {
		return leaveDao.saveOrUpdateLeave(leave);
	}

	/* ���� Javadoc��
	 * @see com.bdqn.oa.service.leave.ILeaveService#findLeavesByPaging(com.bdqn.oa.util.Paging)
	 */
	@Override
	public Paging<SysLeave> findLeavesByPaging(Paging<SysLeave> paging) {
		//����Ǿ���
		if (paging.getT().getSysEmployeeByProposerEid().getSysPosition().getPid()==2) {
			Object[] objects=leaveDao.findEmployeeIsDepartmentManager(paging.getT().getSysEmployeeByProposerEid().getSysDepartment().getDid());
			SysEmployee employee=new SysEmployee();
			employee.setEid(Integer.parseInt(objects[0].toString()));
			paging.getT().setSysEmployeeByExecutorEid(employee);
			paging.getT().setSysEmployeeByProposerEid(null);
			paging.getT().setStatus("������");
		}
		paging.setTotalCount(leaveDao.findLeaveCount(paging.getT()));
		paging.setList(leaveDao.findLeavesByPaging(paging));
		return paging;
	}

	/* ���� Javadoc��
	 * @see com.bdqn.oa.service.leave.ILeaveService#findEmployeeIsDepartmentManager(java.lang.Integer)
	 */
	@Override
	public Object[] findEmployeeIsDepartmentManager(Integer departmentId) {
		return leaveDao.findEmployeeIsDepartmentManager(departmentId);
	}

	/* ���� Javadoc��
	 * @see com.bdqn.oa.service.leave.ILeaveService#findLeaveInformation(java.lang.Integer)
	 */
	@Override
	public SysLeave findLeaveInformation(Integer leaveId) {
		return leaveDao.findLeaveInformation(leaveId);
	}

	/* ���� Javadoc��
	 * @see com.bdqn.oa.service.leave.ILeaveService#updateLeave(com.bdqn.oa.entity.SysLeave)
	 */
	@Override
	public boolean updateLeave(SysLeave leave) {
		try {
			SysLeave sysLeave=leaveDao.findLeaveInformation(leave.getId());
			sysLeave.setStatus(leave.getStatus());
			System.out.println(leave.getLeaveResult().getShsuggestion());
			sysLeave.setLeaveResult(leave.getLeaveResult());
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

}
