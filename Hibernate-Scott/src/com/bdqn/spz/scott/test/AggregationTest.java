package com.bdqn.spz.scott.test;


import org.hibernate.*;
import org.junit.Test;

import com.bdqn.spz.scott.util.HibernateUtil;

public class AggregationTest {

    /**
     * ͳ�Ʋ��Ÿ�����
     */
    @Test
    public void eg_countDept() {
        Transaction tx = null;
        try {
            tx = HibernateUtil.currentSession().beginTransaction();
            Long count = (Long) HibernateUtil.currentSession().createQuery(
                    "select count(id) from Dept").uniqueResult();
            System.out.println(count);
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (tx != null)
                tx.rollback();
        }
    }

    /**
     * ͳ��Ա�������ܺ͡�
     */
    @Test
    public void eg_totalSalary() {
        Transaction tx = null;
        try {
            tx = HibernateUtil.currentSession().beginTransaction();
            Double salarySum = (Double) HibernateUtil.currentSession().createQuery(
                    "select sum(e.salary) from Emp e").uniqueResult();
            System.out.println(salarySum);
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (tx != null)
                tx.rollback();
        }
    }

    /**
     * ͳ��Ա����͹��ʡ�
     */
    @Test
    public void eg_MinSalary() {
        Transaction tx = null;
        try {
            tx = HibernateUtil.currentSession().beginTransaction();
            Double salary = (Double) HibernateUtil.currentSession().createQuery(
                    "select min(e.salary) from Emp e").uniqueResult();
            System.out.println(salary);
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (tx != null)
                tx.rollback();
        }
    }

    /**
     * ͳ��Ա����߹��ʡ�
     */
    @Test
    public void eg_MaxSalary() {
        Transaction tx = null;
        try {
            tx = HibernateUtil.currentSession().beginTransaction();
            Double salary = (Double) HibernateUtil.currentSession().createQuery(
                    "select max(e.salary) from Emp e").uniqueResult();
            System.out.println(salary);
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (tx != null)
                tx.rollback();
        }
    }

    /**
     * ͳ��Ա��ƽ�����ʡ�
     */
    @Test
    public void eg_AvgSalary() {
        Transaction tx = null;
        try {
            tx = HibernateUtil.currentSession().beginTransaction();
            Double salary = (Double) HibernateUtil.currentSession().createQuery(
                    "select avg(e.salary) from Emp e").uniqueResult();
            System.out.println(salary);
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (tx != null)
                tx.rollback();
        }
    }

    /**
     * ͳ����͹��ʡ���߹����Լ�ƽ�����ʡ�
     */
    @Test
    public void eg_Salary() {
        Transaction tx = null;
        try {
            tx = HibernateUtil.currentSession().beginTransaction();
            Object[] salarys = (Object[]) HibernateUtil.currentSession().createQuery(
                    "select min(salary), max(salary), avg(salary) from Emp")
                    .uniqueResult();
            System.out
                    .println(salarys[0] + ", " + salarys[1] + ", " + salarys[2]);
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (tx != null)
                tx.rollback();
        }
    }

    /**
     * �ж�ͳ�ƽ�����������͡�
     */
    @Test
    public void eg_getType() {
        Transaction tx = null;
        try {
            tx = HibernateUtil.currentSession().beginTransaction();
            Object count = HibernateUtil.currentSession().createQuery(
                    "select count(distinct job) from Emp ").uniqueResult();
            System.out.println(count.getClass().getName());
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (tx != null)
                tx.rollback();
        }
    }

}