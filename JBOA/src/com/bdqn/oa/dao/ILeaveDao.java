package com.bdqn.oa.dao;

import java.util.List;

import com.bdqn.oa.entity.SysLeave;
import com.bdqn.oa.util.Paging;

/**
 * @���� Dao����ٽӿ�
 * @���� ʩ����
 * @�������� 2017��12��26��
 * @����ʱ�� ����1:24:53
 */
public interface ILeaveDao {

	/**
	 * �������
	 * @param leave
	 * @return boolean
	 */
	boolean saveOrUpdateLeave(SysLeave leave);
	
	/**
	 * ��ѯ��ٵ�����
	 * @param leave
	 * @return Integer
	 */
	Integer findLeaveCount(SysLeave leave);
	
	/**
	 * ��ѯ����б��ҳ
	 * @param paging
	 * @return List<SysLeave>
	 */
	List<SysLeave> findLeavesByPaging(Paging<SysLeave> paging);
	
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
}
