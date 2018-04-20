/**
 * 
 */
package com.spz.bdqn.house.ssh.dao;

import com.spz.bdqn.house.ssh.entity.User;

/**
 * @���� Dao���û��ӿ�
 * @���� ʩ����
 * @�������� 2017��12��18��
 * @����ʱ�� ����11:54:12
 */
public interface IUserDao {


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
	
	/**
	 * ��ѯ����
	 * @return Integer
	 */
	Integer findMaxUserId();
}
