/**
 * 
 */
package com.bdqn.oa.test;

import java.util.Date;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bdqn.oa.dao.employee.ISysEmployeeDao_z;
import com.bdqn.oa.dao.employee.SysEmployeeDaoImpl;
import com.bdqn.oa.dao.leave.ILeaveDao;
import com.bdqn.oa.dao.leave.LeaveDaoImpl;
import com.bdqn.oa.entity.SysEmployee;
import com.bdqn.oa.entity.SysLeave;
import com.bdqn.oa.service.employee.ISysEmployeeService_z;
import com.bdqn.oa.service.employee.SysEmployeeServiceImpl_z;
import com.bdqn.oa.util.Paging;

/**
 * @描述 oa
 * @作者 施鹏振
 * @创建日期 2017年12月26日
 * @创建时间 下午5:09:09
 */
public class LeaveTest {


	@SuppressWarnings("resource")
	@Test
	public void testDao_findLeaveCount(){
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
		ILeaveDao leaveDao=applicationContext.getBean(LeaveDaoImpl.class);
		SysLeave leave=new SysLeave();
		SysEmployee employee=new SysEmployee();
		employee.setEid(4);
		leave.setSysEmployeeByProposerEid(employee);
		leave.setStatus("新创建");
		leave.setBegindate(new Date());
		System.out.println(leaveDao.findLeaveCount(leave));
	}
	
	@SuppressWarnings("resource")
	public void testDao_findLeavesByPaging(){
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
		ILeaveDao leaveDao=applicationContext.getBean(LeaveDaoImpl.class);
		SysLeave leave=new SysLeave();
		SysEmployee employee=new SysEmployee();
		employee.setEid(4);
		leave.setSysEmployeeByProposerEid(employee);
		leave.setStatus("新创建");
		Paging<SysLeave> paging=new Paging<SysLeave>();
		paging.setT(leave);
		paging.setCurrentPageNo(1);
		paging.setTotalCount(1);
		paging.setPageSize(3);
		leaveDao.findLeavesByPaging(paging);
	}
	
	@SuppressWarnings("resource")
	public void testDao_findempByPwd(){
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
		ISysEmployeeDao_z employeeDao_z=applicationContext.getBean(SysEmployeeDaoImpl.class);
		
		System.out.println(employeeDao_z.findempByPwd("李财迷","123"));
	}
	
	public static void main(String[] args) {
		new LeaveTest().testDao_findempByPwd();
	}
}
