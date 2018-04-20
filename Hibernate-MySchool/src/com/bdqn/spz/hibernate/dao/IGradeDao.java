package com.bdqn.spz.hibernate.dao;

import java.io.Serializable;
import com.bdqn.spz.hibernate.entity.Grade;

/**
 * Dao层年纪接口
 * 
 * @author 施鹏振
 *
 */
public interface IGradeDao {

	/**
	 * 通过Session的get()方法根据id加载指定对象,如果没数据对象是null,调用属性会报异常(java.lang.NullPointerException)
	 * 
	 * @param gradeId
	 * @return Grade
	 */
	public Grade get(Serializable gradeId);

	/**
	 * 通过Session的load()方法根据id加载指定对象,如果没数据对象不是null,调用属性会抛异常
	 * 
	 * @param gradeId
	 * @return Grade
	 */
	public Grade load(Serializable gradeId);

	/**
	 * 保存指定的Grade对象,返回OID
	 * 
	 * @param grade
	 * @return Integer
	 */
	public Integer save(Grade grade);

	/**
	 * 更新指定的Grade对象
	 * 
	 * @param grade
	 */
	public void update(Grade grade);

	/**
	 * 删除指定的Grade对象
	 * 
	 * @param grade
	 */
	public void delete(Grade grade);
	
	/**
	 * 使用merge()方法将游离对象的数据合并到拥有相同OID的持久态对象中或者保存临时对象的副本，得到新的持久态对象
	 * @param grade
	 * @return Grade
	 */
	public Grade merge(Grade grade);
	
	
}
