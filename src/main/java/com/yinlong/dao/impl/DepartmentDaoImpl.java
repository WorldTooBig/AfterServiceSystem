package com.yinlong.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.yinlong.dao.IDepartmentDao;
import com.yinlong.entity.Department;

@Repository("departmentDao")
public class DepartmentDaoImpl extends BaseDao implements IDepartmentDao {

	/**
	 * ��Ӳ��� 
	 * @param department
	 * @return
	 */
	public boolean addDepartment(Department department) {
		try {
			getSession().save(department);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * ����HQL��ѯ��Ϣ
	 * @return
	 */
	public List<Department> queryDepartmentListHql(String hql) {
		try {
			return getSession().createQuery(hql).list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
