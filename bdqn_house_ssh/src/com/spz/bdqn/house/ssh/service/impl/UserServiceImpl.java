/**
 * 
 */
package com.spz.bdqn.house.ssh.service.impl;

import com.spz.bdqn.house.ssh.dao.IUserDao;
import com.spz.bdqn.house.ssh.entity.User;
import com.spz.bdqn.house.ssh.service.IUserService;

/**
 * @���� bdqn_house
 * @���� ʩ����
 * @�������� 2017��12��18��
 * @����ʱ�� ����1:08:43
 */
public class UserServiceImpl implements IUserService {

	private IUserDao userDao;

	public IUserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}

	/* ���� Javadoc��
	 * @see com.spz.bdqn.house.service.IUserService#findUser(java.lang.String, java.lang.String)
	 */
	@Override
	public User findUser(String username, String password) {
		return userDao.findUser(username, password);
	}

	/* ���� Javadoc��
	 * @see com.spz.bdqn.house.service.IUserService#addUser(com.spz.bdqn.house.entity.User)
	 */
	@Override
	public boolean addUser(User user) {
		user.setId(userDao.findMaxUserId()+1);
		return userDao.addUser(user);
	}
	

}
