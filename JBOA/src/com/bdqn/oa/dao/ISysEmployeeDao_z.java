package com.bdqn.oa.dao;

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
	
	/**
	 * ��ǰ�û��Ĳ��ž���
	 */
	SysEmployee findempJl(SysEmployee emp);
}
