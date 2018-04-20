/**
 * 
 */
package com.bdqn.oa.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import com.bdqn.oa.dao.IBaseDao;

/**
 * @描述 oa
 * @作者 施鹏振
 * @创建日期 2017年12月31日
 * @创建时间 下午2:24:05
 */
public class BaseDaoImpl<T> extends HibernateDaoSupport implements IBaseDao<T> {

	// 注入获取sessionFactory
	/*
	 * @Autowired private void setMySessionFactory(SessionFactory
	 * sessionFactory) { // 这个方法名可以随便写，@Resource可以通过name 或者type来装载的
	 * super.setSessionFactory(sessionFactory); }
	 */
	

	private Class<T> clazz;

	/**
	 * 通过子类获取运行时的泛型
	 */
	@SuppressWarnings("unchecked")
	public BaseDaoImpl() {

		// 获取当前运行时的类的泛型
		// System.out.println(getClass().getTypeParameters()[0]);

		// 获取当前运行时的类的父类的泛型
		System.out.println(getClass().getSuperclass().getTypeParameters()[0]);

		// 使用反射技术得到T的真实类型
		// 获取当前new的对象的泛型的父类(获取当前运行类的父类的泛型)
		Type type = getClass().getGenericSuperclass();
		ParameterizedType parameterizedType = (ParameterizedType) type;
		// 获取第一个类型参数的真实类型this.clazz=(Class<T>) pt.getActualTypeArguments()[0];
		clazz = (Class<T>) parameterizedType.getActualTypeArguments()[0];
	}

	// 新增
	@Override
	public Serializable save(T t) {
		return getHibernateTemplate().save(t);
	}

	// 删除
	@Override
	public void delete(T t) {
		getHibernateTemplate().delete(t);
	}

	// 删除多个对象
	@Override
	public void deleteAll(List<T> t) {
		getHibernateTemplate().deleteAll(t);
	}

	// 根据id删除对象
	@Override
	public void deleteById(Integer id) {
		getHibernateTemplate().delete(get(id));
	}

	// 根据多个id删除对个对象
	@Override
	public void deleteByIds(Integer[] ids) {
		for (Integer id : ids) {
			getHibernateTemplate().delete(get(id));
		}
	}

	@Override
	public T queryUnique(String name, String value) {
		return null;
	}
	
	public void deleteByPropertie(String name, String value) {
		T t = queryUnique(name, value);
		getHibernateTemplate().delete(t);
	}

	// 修改
	public void update(T t) {
		getHibernateTemplate().update(t);
	}

	// 修改对个对象
	public void update(List<T> list) {
		for (T t : list) {
			getHibernateTemplate().update(t);
		}
	}

	// 根据id查对象,立即加载
	public T get(Integer id) {
		return getHibernateTemplate().get(clazz, id);
	}

	// 根据id查对象,懒加载
	public T load(Integer id) {
		return getHibernateTemplate().load(clazz, id);
	}

	// 查询该类全部数据
	@SuppressWarnings("unchecked")
	public List<T> queryAll() {
		// 泛型from 类名(clazz.getSimpleName())
		return (List<T>) getHibernateTemplate().find("from " + clazz.getSimpleName());
	}

	// 会自定选定save或者update操作
	public void saveOrUpdate(T t) {
		getHibernateTemplate().saveOrUpdate(t);
	}


}
