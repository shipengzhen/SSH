package com.bdqn.oa.dao;

import com.bdqn.oa.entity.SysEmployee;

/**
 * 用户
 * @author lizhen
 * @date 2017年12月27日
 */
public interface ISysEmployeeDao_z {
	
	/**
	 * 登录
	 * @return
	 */
	SysEmployee findempByPwd(String ename,String epassword);
	
	/**
	 * 当前用户的部门经理
	 */
	SysEmployee findempJl(SysEmployee emp);
}
