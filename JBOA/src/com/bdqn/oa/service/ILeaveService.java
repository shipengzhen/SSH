/**
 * 
 */
package com.bdqn.oa.service;

import com.bdqn.oa.entity.SysLeave;
import com.bdqn.oa.util.Paging;

/**
 * @���� ���Service��ӿ�
 * @���� ʩ����
 * @�������� 2017��12��27��
 * @����ʱ�� ����10:32:28
 */
public interface ILeaveService {

	/**
	 * �޸����
	 * @param leave
	 * @return boolean
	 */
	boolean saveOrUpdateLeave(SysLeave leave);
	
	/**
	 * ��ѯ����б��ҳ
	 * @param paging
	 * @return Paging<SysLeave>
	 */
	Paging<SysLeave> findLeavesByPaging(Paging<SysLeave> paging);
	
	/**
	 * ��ѯĳ���ŵľ���
	 * @param departmentId
	 * @return Object[]
	 */
	Object[] findEmployeeIsDepartmentManager(Integer departmentId);
	
	/**
	 * ��ѯ�������
	 * @param leaveId
	 * @return SysLeave
	 */
	SysLeave findLeaveInformation(Integer leaveId);
	
	/**
	 * ������
	 * @param leave
	 * @return boolean
	 */
	boolean updateLeave(SysLeave leave);
}
