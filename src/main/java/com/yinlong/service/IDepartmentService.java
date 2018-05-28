package com.yinlong.service;

import java.util.List;

import com.yinlong.entity.Company;
import com.yinlong.entity.Department;

public interface IDepartmentService {

	/**
	 * 添加部门
	 * @param department
	 * @return
	 */
	public boolean addDepartment(Department department);
	
	/**
	 * 查询所有的部门信息  根据公司ID
	 * @return
	 */
	public List<Department> findDepartmentList(Company company);
}
