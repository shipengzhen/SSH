/**
 * 
 */
package com.bdqn.oa.dao;

import java.io.Serializable;
import java.util.List;

/**
 * @描述 Hibernate-Scott
 * @作者 施鹏振
 * @创建日期 2017年12月31日
 * @创建时间 下午2:03:55
 */
public interface IBaseDao<T> {

	/**
	 * 新增
	 * @param t
	 * @return Serializable
	 */
	Serializable save(T t);

	/**
	 * 新增或修改
	 * @param t void
	 */
	void saveOrUpdate(T t);

	/**
	 * 修改一个对象
	 * @param t void
	 */
	void update(T t);

	/**
	 * 修改对象集合
	 * @param list void
	 */
	void update(List<T> list);

	/**
	 * 删除一个对象
	 * @param t void
	 */
	void delete(T t);

	/**
	 * 删除多个对象
	 * @param t void
	 */
	void deleteAll(List<T> t);

	/**
	 * 通过id删除对象
	 * @param id void
	 */
	void deleteById(Integer id);
	
	/**
	 * 对个id删除多个对象
	 * @param ids void
	 */
	void deleteByIds(Integer[] ids);

	/**
	 * 删,通过屬性删除
	 * @param name
	 * @param value void
	 */
	void deleteByPropertie(String name, String value);

	/**
	 * 查询某张表的全部数据
	 * @return List<T>
	 */
	List<T> queryAll();

	/**
	 * 查,通过id获取对象(立即加载)
	 * @param id
	 * @return T
	 */
	T get(Integer id);
	
	/**
	 * 查,通过id获取对象(懒加载)
	 * @param id
	 * @return T
	 */
	T load(Integer id);

	/**
	 * 查,通过名字获取对象
	 * @param name
	 * @param value
	 * @return T
	 */
	T queryUnique(String name, String value);
}
