/**
 * 
 */
package com.bdqn.oa.service.leave;

import com.bdqn.oa.entity.SysLeave;
import com.bdqn.oa.util.Paging;

/**
 * @描述 请假Service层接口
 * @作者 施鹏振
 * @创建日期 2017年12月27日
 * @创建时间 上午10:32:28
 */
public interface ILeaveService {

	/**
	 * 修改请假
	 * @param leave
	 * @return boolean
	 */
	boolean saveOrUpdateLeave(SysLeave leave);
	
	/**
	 * 查询请假列表分页
	 * @param paging
	 * @return Paging<SysLeave>
	 */
	Paging<SysLeave> findLeavesByPaging(Paging<SysLeave> paging);
	
	/**
	 * 查询某部门的经理
	 * @param departmentId
	 * @return Object[]
	 */
	Object[] findEmployeeIsDepartmentManager(Integer departmentId);
	
	/**
	 * 查询请假详情
	 * @param leaveId
	 * @return SysLeave
	 */
	SysLeave findLeaveInformation(Integer leaveId);
	
	/**
	 * 审核请假
	 * @param leave
	 * @return boolean
	 */
	boolean updateLeave(SysLeave leave);
}
