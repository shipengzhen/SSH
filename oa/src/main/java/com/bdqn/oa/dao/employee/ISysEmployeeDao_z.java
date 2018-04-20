package com.bdqn.oa.dao.employee;

import com.bdqn.oa.entity.SysEmployee;

/**
 * �û�
 * @author lizhen
 * @date 2017��12��27��
 */
public interface ISysEmployeeDao_z {
	
	/**
	 * ��¼
	 * @return
	 */
	SysEmployee findempByPwd(String ename,String epassword);
}
