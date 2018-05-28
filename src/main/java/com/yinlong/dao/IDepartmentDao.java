package com.yinlong.dao;

import java.util.List;

import com.yinlong.entity.Department;

public interface IDepartmentDao {

	/**
	 * ��Ӳ��� 
	 * @param department
	 * @return
	 */
	public boolean addDepartment(Department department);
	
	/**
	 * ����HQL��ѯ��Ϣ
	 * @return
	 */
	public List<Department> queryDepartmentListHql(String hql);
}
