/**
 * 
 */
package com.spz.bdqn.house.ssh.service;

import com.spz.bdqn.house.ssh.entity.User;

/**
 * @���� Service���û��ӿ�
 * @���� ʩ����
 * @�������� 2017��12��18��
 * @����ʱ�� ����1:03:00
 */
public interface IUserService {


	/**
	 * ��ѯ�û���Ϣ
	 * @param username
	 * @param password
	 * @return User
	 */
	User findUser(String username,String password);
	
	/**
	 * �����û�
	 * @param user
	 * @return boolean
	 */
	boolean addUser(User user);
	
}
