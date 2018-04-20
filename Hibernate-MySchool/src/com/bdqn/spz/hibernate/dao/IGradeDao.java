package com.bdqn.spz.hibernate.dao;

import java.io.Serializable;
import com.bdqn.spz.hibernate.entity.Grade;

/**
 * Dao����ͽӿ�
 * 
 * @author ʩ����
 *
 */
public interface IGradeDao {

	/**
	 * ͨ��Session��get()��������id����ָ������,���û���ݶ�����null,�������Իᱨ�쳣(java.lang.NullPointerException)
	 * 
	 * @param gradeId
	 * @return Grade
	 */
	public Grade get(Serializable gradeId);

	/**
	 * ͨ��Session��load()��������id����ָ������,���û���ݶ�����null,�������Ի����쳣
	 * 
	 * @param gradeId
	 * @return Grade
	 */
	public Grade load(Serializable gradeId);

	/**
	 * ����ָ����Grade����,����OID
	 * 
	 * @param grade
	 * @return Integer
	 */
	public Integer save(Grade grade);

	/**
	 * ����ָ����Grade����
	 * 
	 * @param grade
	 */
	public void update(Grade grade);

	/**
	 * ɾ��ָ����Grade����
	 * 
	 * @param grade
	 */
	public void delete(Grade grade);
	
	/**
	 * ʹ��merge()�����������������ݺϲ���ӵ����ͬOID�ĳ־�̬�����л��߱�����ʱ����ĸ������õ��µĳ־�̬����
	 * @param grade
	 * @return Grade
	 */
	public Grade merge(Grade grade);
	
	
}
