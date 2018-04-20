package com.bdqn.oa.service.impl;

import com.bdqn.oa.dao.ISysEmployeeDao_z;
import com.bdqn.oa.entity.SysEmployee;
import com.bdqn.oa.service.ISysEmployeeService_z;

public class SysEmployeeServiceImpl_z implements ISysEmployeeService_z {

	//员工Dao接口
	private ISysEmployeeDao_z sysEmployeeDao_z;
	
	public ISysEmployeeDao_z getSysEmployeeDao_z() {
		return sysEmployeeDao_z;
	}
	public void setSysEmployeeDao_z(ISysEmployeeDao_z sysEmployeeDao_z) {
		this.sysEmployeeDao_z = sysEmployeeDao_z;
	}


	//登录
	@Override
	public SysEmployee emplogin(String ename, String epassword) {
	
		return sysEmployeeDao_z.findempByPwd(ename, epassword);
	}

}
