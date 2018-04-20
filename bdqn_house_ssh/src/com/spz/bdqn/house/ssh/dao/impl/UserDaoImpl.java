/**
 * 
 */
package com.spz.bdqn.house.ssh.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.spz.bdqn.house.ssh.dao.IUserDao;
import com.spz.bdqn.house.ssh.entity.User;



/**
 * @���� Dao���û�ʵ����
 * @���� ʩ����
 * @�������� 2017��12��18��
 * @����ʱ�� ����12:54:19
 */
public class UserDaoImpl extends HibernateDaoSupport implements IUserDao {

	private Session session=getHibernateTemplate().getSessionFactory().getCurrentSession();

	/* ���� Javadoc��
	 * @see com.spz.bdqn.house.dao.IUserDao#findUser(java.lang.String, java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public User findUser(String username, String password) {
		String hql="from User u where u.username=? and u.password=?";
		Object[] objects={username,password};
		List<User> users= getHibernateTemplate().find(hql, objects);
		System.out.println(users.size());
		User user=null;
		for (User user1 : users) {
			user=user1;
		}
		return user;
	}

	
	/* ���� Javadoc��
	 * @see com.spz.bdqn.house.dao.IUserDao#addUser(com.spz.bdqn.house.entity.User)
	 */
	@Override
	public boolean addUser(User user) {
		boolean b=true;
		Transaction transaction=session.beginTransaction();
		try {
			session.save(user);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
			b=false;
		}
		return b;
	}

	/* ���� Javadoc��
	 * @see com.spz.bdqn.house.dao.IUserDao#findMaxUserId()
	 */
	@Override
	public Integer findMaxUserId() {
		String hql="select max(u.id) from User u";
		Query query=session.createQuery(hql);
		Integer integer=(Integer) query.uniqueResult();
		if (integer==null) {
			integer=0;
		}
		return integer;
	}

}
