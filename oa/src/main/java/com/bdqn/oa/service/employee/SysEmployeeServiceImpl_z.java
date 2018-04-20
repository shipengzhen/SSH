package com.bdqn.oa.service.employee;

import com.bdqn.oa.dao.employee.ISysEmployeeDao_z;
import com.bdqn.oa.entity.SysEmployee;

public class SysEmployeeServiceImpl_z implements ISysEmployeeService_z {

	//Ա��Dao�ӿ�
	private ISysEmployeeDao_z sysEmployeeDao_z;
	
	public ISysEmployeeDao_z getSysEmployeeDao_z() {
		return sysEmployeeDao_z;
	}
	public void setSysEmployeeDao_z(ISysEmployeeDao_z sysEmployeeDao_z) {
		this.sysEmployeeDao_z = sysEmployeeDao_z;
	}


	//��¼
	@Override
	public SysEmployee emplogin(String ename, String epassword) {
	
		return sysEmployeeDao_z.findempByPwd(ename, epassword);
	}

}
