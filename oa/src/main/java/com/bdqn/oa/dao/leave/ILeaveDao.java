package com.bdqn.oa.dao.leave;

import java.util.List;

import com.bdqn.oa.entity.SysLeave;
import com.bdqn.oa.util.Paging;

/**
 * @描述 Dao层请假接口
 * @作者 施鹏振
 * @创建日期 2017年12月26日
 * @创建时间 下午1:24:53
 */
public interface ILeaveDao {

	/**
	 * 新增请假
	 * @param leave
	 * @return boolean
	 */
	boolean saveOrUpdateLeave(SysLeave leave);
	
	/**
	 * 查询请假的数量
	 * @param leave
	 * @return Integer
	 */
	Integer findLeaveCount(SysLeave leave);
	
	/**
	 * 查询请假列表分页
	 * @param paging
	 * @return List<SysLeave>
	 */
	List<SysLeave> findLeavesByPaging(Paging<SysLeave> paging);
	
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
}
